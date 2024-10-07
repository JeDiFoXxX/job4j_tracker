package ru.job4j.tracker;

public final class SingleTracker {
    private static SingleTracker object = null;

    private Tracker tracker = new Tracker();

    private SingleTracker() { }

    public static SingleTracker getObject() {
        if (object == null) {
            object = new SingleTracker();
        }
        return object;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item[] findAll() {
        return tracker.findAll();
    }

    public Item[] findByName(String key) {
        return tracker.findByName(key);
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public boolean replace(int id, Item item) {
        return tracker.replace(id, item);
    }

    public void delete(int id) {
        tracker.delete(id);
    }
}

