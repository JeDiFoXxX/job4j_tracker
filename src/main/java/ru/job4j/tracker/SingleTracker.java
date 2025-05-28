package ru.job4j.tracker;

import java.util.List;

public final class SingleTracker {
    private static SingleTracker object = null;

    private Store memTracker = new MemTracker();

    private SingleTracker() { }

    public static SingleTracker getObject() {
        if (object == null) {
            object = new SingleTracker();
        }
        return object;
    }

    public Item add(Item item) {
        return memTracker.add(item);
    }

    public List<Item> findAll() {
        return memTracker.findAll();
    }

    public List<Item> findByName(String key) {
        return memTracker.findByName(key);
    }

    public Item findById(int id) {
        return memTracker.findById(id);
    }

    public boolean replace(int id, Item item) {
        return memTracker.replace(id, item);
    }

    public void delete(int id) {
        memTracker.delete(id);
    }
}

