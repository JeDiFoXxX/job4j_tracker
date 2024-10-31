package ru.job4j.tracker;

import java.util.ArrayList;

public class Tracker {
    ArrayList<Item> items = new ArrayList<>();
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public Item[] findAll() {
        return items.toArray(new Item[0]);
    }

    public Item[] findByName(String key) {
        ArrayList<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().contains(key)) {
                result.add(item);
            }
        }
        return result.toArray(new Item[0]);
    }

    private int indexOf(int id) {
        int result = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                result = index;
                break;
            }
        }
        return result;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean result = index != -1;
        if (result) {
            item.setId(index + 1);
            items.set(index, item);
        }
        return result;
    }

    public void delete(int id) {
        int index = indexOf(id);
        if (index != -1) {
            items.remove(indexOf(id));
        }
    }
}