package ru.home.aglar.oop.person;

import java.util.HashSet;
import java.util.Set;

public class PersonMain {
    public static void main(String[] args) {
        Person person1 = Person.Builder.builder()
                .firstName("Dmitrii")
                .lastName("Babanov")
                .age(38)
                .address("Moscow")
                .gender("M")
                .build();
        Person person2 = Person.Builder.builder()
                .firstName("Ivan")
                .lastName("Zajcev")
                .age(32)
                .address("St. Peterburg")
                .country("Russia")
                .build();
        Set<Person> persons = new HashSet<>();
        persons.add(person1);
        persons.add(person2);
        persons.forEach(person -> System.out.println(person.toString()));
    }
}
