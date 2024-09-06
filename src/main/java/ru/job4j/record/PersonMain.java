package ru.job4j.record;

public class PersonMain {
    public static void main(String[] args) {
        Person person = new Person("Иван", 30);
        System.out.println("Имя: " + person.getName() + ", Возраст: " + person.getAge());
        System.out.println(person);
        PersonRecord record = new PersonRecord("Иван", 30);
        System.out.println("Имя: " + record.name() + ", Возраст: " + record.age());
        System.out.println(record);
        PersonRecord record1 = new PersonRecord("Иван", 30);
        System.out.println(record.equals(record1));
        PersonRecord newRecord1 = new PersonRecord("Сергей", record.age());
        System.out.println(newRecord1.name() + "........"  + newRecord1.age());
    }
}
