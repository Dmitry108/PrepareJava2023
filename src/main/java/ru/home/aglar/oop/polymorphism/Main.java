package ru.home.aglar.oop.polymorphism;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Shape> shapes = Arrays.asList(
                new Circle(5),
                new Square(7),
                new Triangle(4, 5, 7)
        );
        shapes.forEach(System.out::println);
    }
}
