package ru.home.aglar.oop.polymorphism;

public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.name = "Circle";
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public String info() {
        return String.format("radius = %.2f", radius);
    }
}