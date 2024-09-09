package ru.job4j.io;

import java.util.*;

public class MagicBall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Я великий Оракул. Что ты хочешь узнать? ");
        scanner.nextLine();
        int value = new Random().nextInt(3);
        System.out.printf(value == 0 ? "Да" : value == 1 ? "Нет" : "Может быть");
    }
}
