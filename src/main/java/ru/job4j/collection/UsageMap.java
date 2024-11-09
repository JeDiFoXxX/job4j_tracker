package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("Chaplin@gmail.com", "Charlie Chaplin");
        map.put("Silver@gmail.com", "Johnny Silverhand");
        map.put("David@gmail.com", "David Duchovny");
        map.put("David@gmail.com", "David Martinez");

        for (String key : map.keySet()) {
            System.out.println(key + ": " + map.get(key));
        }
    }
}