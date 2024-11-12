package ru.job4j.collection;

public record User(String name, int age) implements Comparable<User> {
    @Override
    public int compareTo(User o) {
        int resultCompare = this.name.compareTo(o.name);
        if (resultCompare == 0) {
            return Integer.compare(this.age, o.age);
        }
        return resultCompare;
    }
}
