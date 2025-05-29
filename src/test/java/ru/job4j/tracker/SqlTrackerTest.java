package ru.job4j.tracker;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.sql.*;
import java.util.*;

import static org.assertj.core.api.Assertions.*;

public class SqlTrackerTest {
    private static Connection connection;

    @BeforeAll
    public static void initConnection() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("db/liquibase_test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterAll
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @AfterEach
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId())).isEqualTo(item);
    }

    @Test
    public void whenReplaceItemThenFindByIdReturnsUpdatedItem() {
        SqlTracker tracker = new SqlTracker(connection);
        Item firstItem = new Item("firstItem");
        Item secondItem = new Item("secondItem");
        tracker.add(firstItem);
        tracker.replace(firstItem.getId(), secondItem);
        secondItem.setId(firstItem.getId());
        assertThat(tracker.findById(secondItem.getId())).isEqualTo(secondItem);
    }

    @Test
    public void whenDeleteItemThenFindByIdReturnsNull() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        tracker.delete(item.getId());
        assertThat(tracker.findById(item.getId())).isNull();
    }

    @Test
    public void whenAddMultipleItemsThenFindAllReturnsThem() {
        SqlTracker tracker = new SqlTracker(connection);
        Item firstItem = new Item("firstItem");
        Item secondItem = new Item("secondItem");
        tracker.add(firstItem);
        tracker.add(secondItem);
        assertThat(tracker.findAll()).contains(firstItem, secondItem);
    }

    @Test
    public void whenFindByNameThenReturnsAllMatchingItems() {
        SqlTracker tracker = new SqlTracker(connection);
        Item firstItem = new Item("firstItem");
        Item secondItem = new Item("firstItem");
        tracker.add(firstItem);
        tracker.add(secondItem);
        assertThat(tracker.findByName(firstItem.getName())).contains(firstItem, secondItem);
    }

    @Test
    public void whenFindByIdThenReturnCorrectItem() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("firstItem");
        tracker.add(item);
        assertThat(tracker.findById(item.getId())).isEqualTo(item);
    }
}