package ru.job4j.polymorphism;

public class Bus implements Transport {
    @Override
    public void move() {
        System.out.println("Транспорт двинулся");
    }

    @Override
    public void passengers(int count) {
        System.out.println("Количество пассажиов: " + count);
    }

    @Override
    public int refuel(int fuel) {
        int price = 53;
        return fuel * price;
    }
}
