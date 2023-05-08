package ru.home.aglar.algorithm.list;

import java.util.*;
import java.util.function.UnaryOperator;

public interface List<E> extends Iterable<E> {
    int size();
    boolean isEmpty();
    boolean contains(E e);
    boolean add(E e);
    boolean remove(E e);
    void clear();
    E get(int index);
    E set(int index, E element);
    void add(int index, E element);
    E remove(int index);
    void display();

    class Node<E> {
        E item;
        Node<E> previous;
        Node<E> next;

        public Node(E item, Node<E> next){
            this(item, null, next);
        }

        public Node(E item, Node<E> previous, Node<E> next){
            this.item = item;
            this.previous = previous;
            this.next = next;
        }
    }
}