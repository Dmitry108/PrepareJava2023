package ru.home.aglar.oop.polymorphism;

public class Square extends Shape {
    private double side;

    public Square(double side) {
        this.name = "Square";
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public String info() {
        return String.format("side = %.2f", side);
    }
}
