package ru.job4j.collection;

import java.util.*;

public class UsageHashSet {
    public static void main(String[] args) {
        Set<String> autos = new HashSet<>();
        Collections.addAll(autos, "Lada", "BMW", "Volvo", "Toyota");

        for (String auto : autos) {
            System.out.println(auto);
        }
    }
}
