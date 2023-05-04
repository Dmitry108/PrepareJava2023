package ru.home.aglar.oop.polymorphism;

public abstract class Shape {
    protected String name;

    public Shape() {
        this.name = "Shape";
    }

    public String getName() {
        return name;
    }

    abstract public String info();

    @Override
    public String toString() {
        return name + ": " + info();
    }
}
