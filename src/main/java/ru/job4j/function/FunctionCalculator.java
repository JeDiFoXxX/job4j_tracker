package ru.job4j.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionCalculator {
    public List<Double> diapason(int start, int end, Function<Double, Double> function) {
        List<Double> list = new ArrayList<>();
        for (int index = start; index < end; index++) {
            list.add(function.apply((double) index));
        }
        return list;
    }
}