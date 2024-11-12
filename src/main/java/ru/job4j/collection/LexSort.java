package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String leftNumber = left.substring(0, left.indexOf('.'));
        String rightNumber = right.substring(0, right.indexOf('.'));
        return Integer.compare(Integer.parseInt(leftNumber), Integer.parseInt(rightNumber));
    }
}
