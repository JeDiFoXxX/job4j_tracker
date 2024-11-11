package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import ru.job4j.collection.NotifyAccount;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemTest {
    @Test
    public void whenSortAscByName() {
        List<Item> items = Arrays.asList(
                new Item("Geralt"),
                new Item("Yennefer"),
                new Item("Triss"),
                new Item("Ciri")
        );
        List<Item> expected = List.of(
                new Item("Ciri"),
                new Item("Geralt"),
                new Item("Triss"),
                new Item("Yennefer")
        );
        Collections.sort(items, new ItemAscByName());
        assertThat(items).isEqualTo(expected);
    }

    @Test
    public void whenSortDescByName() {
        List<Item> items = Arrays.asList(
                new Item("Geralt"),
                new Item("Yennefer"),
                new Item("Triss"),
                new Item("Ciri")
        );
        List<Item> expected = List.of(
                new Item("Yennefer"),
                new Item("Triss"),
                new Item("Geralt"),
                new Item("Ciri")
        );
        Collections.sort(items, new ItemDescByName());
        assertThat(items).isEqualTo(expected);
    }
}