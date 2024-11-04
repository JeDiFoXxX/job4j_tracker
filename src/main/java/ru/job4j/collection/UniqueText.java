package ru.job4j.collection;

import java.util.*;

public class UniqueText {
    public boolean isEquals(String originText, String duplicateText) {
        boolean result = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        Set<String> check = new HashSet<>(Arrays.asList(origin));
        for (String value : text) {
            if (!check.contains(value)) {
                result = false;
                break;
            }
        }
        return result;
    }
}
