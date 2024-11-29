package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private final ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> namePredicate = person -> person.name().contains(key);
        Predicate<Person> surnamePredicate = person -> person.surname().contains(key);
        Predicate<Person> phonePredicate = person -> person.phone().contains(key);
        Predicate<Person> addressPredicate = person -> person.address().contains(key);
        Predicate<Person> combinePredicate = namePredicate.or(surnamePredicate).or(phonePredicate).or(addressPredicate);

        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combinePredicate.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
