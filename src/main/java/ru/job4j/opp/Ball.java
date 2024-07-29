package ru.job4j.opp;

public class Ball {
    public void tryRun(boolean condition) {
        String status = "Колобок съеден";
        if (!condition) {
            status = "Колобок сбежал";
        }
        System.out.println(status);
    }
}
