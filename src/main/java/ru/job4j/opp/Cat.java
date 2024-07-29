package ru.job4j.opp;

public class Cat {
    public String sound() {
        String voice = "may-may";
        return voice;
    }

    public static void main(String[] args) {
        Cat peppy = new Cat();
        System.out.println(peppy.sound());
    }
}
