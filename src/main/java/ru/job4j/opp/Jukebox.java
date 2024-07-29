package ru.job4j.opp;

public class Jukebox {
        public void music(int position) {
            String melody = switch (position) {
                case 1 -> "Пусть бегут неуклюже";
                case 2 -> "Спокойной ночи";
                default -> "Песня не найдена";
            };
            System.out.println(melody);
        }

        public static void main(String[] args) {
            Jukebox melody = new Jukebox();
            melody.music(1);
        }
}
