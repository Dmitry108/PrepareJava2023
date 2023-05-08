package ru.home.aglar.algorithm.list;

import java.util.Iterator;

public class MyArrayList<E> implements List<E> {
    private int capacity;
    private final double check;

    private int size;
    private E[] array;

    public MyArrayList(int capacity, double check) {
        this.capacity = capacity;
        this.check = check;
        this.size = 0;
        this.array = (E[]) new Object[capacity];
    }

    public MyArrayList(int capacity) {
        this(capacity, 0.75);
    }

    public MyArrayList() {
        this(10, 0.75);
    }


    private void checkCapacity() {
        if (capacity * check < size) {
            capacity = 2 * size;
            E[] newArray = (E[]) new Object[capacity];
            for (int i = 0; i < size; i++) {
                newArray[i] = array[i];
                array = newArray;
            }
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(e)) return true;
        }
        return false;
    }

    @Override
    public boolean add(E e) {
        checkCapacity();
        array[size++] = e;
        return true;
    }

    @Override
    public boolean remove(E e) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(e)) {
                for (int j = i; j < size - 1; j++) {
                    array[j] = array[j+1];
                }
                array[--size] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    @Override
    public E get(int index) {
        return array[index];
    }

    @Override
    public E set(int index, E element) {
        array[index] = element;
        return array[index];
    }

    @Override
    public void add(int index, E element) {
        if (index >= size) throw new IllegalArgumentException();
        checkCapacity();
        E current = element;
        E next;
        for (int i = index; i <= size; i++) {
            next = array[i];
            array[i] = current;
            current = next;
        }
        size++;
    }

    @Override
    public E remove(int index) {
        if (index >= size) throw new IllegalArgumentException();
        E e = array[index];
        for (int i = index; i <= size; i++) {
            array[i] = array[i+1];
        }
        array[--size] = null;
        return e;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(array[i]);
            if (i != size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public E next() {
                if (hasNext()) {
                    return array[currentIndex++];
                }
                return null;
            }
        };
    }
}