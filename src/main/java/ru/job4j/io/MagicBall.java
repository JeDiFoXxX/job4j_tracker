package ru.job4j.io;

import java.util.*;

public class MagicBall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Я великий Оракул. Что ты хочешь узнать? ");
        scanner.nextLine();
         String result = switch (new Random().nextInt(3)) {
            case 0 -> "Да";
            case 1 -> "Нет";
            default -> "Может быть";
         };
        System.out.println(result);
    }
}
