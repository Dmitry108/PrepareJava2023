package ru.home.aglar.algorithm.list;

import java.util.Iterator;

public class MyLinkedList<E> implements List<E> {
    protected Node<E> firstNode;
    protected Node<E> lastNode;
    protected int size;

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
        for (Node<E> i = firstNode; i != null; i = i.next) {
            if (i.item.equals(e)) return true;
        }
        return false;
    }

    @Override
    public boolean add(E e) {
        Node<E> node = new Node<>(e, lastNode, null);
        if (size == 0) {
            firstNode = node;
        } else {
            lastNode.next = node;
        }
        lastNode = node;
        size++;
        return true;
    }

    @Override
    public boolean remove(E e) {
        boolean isChanged = false;
        Node<E> node = firstNode;
        Node<E> beforeNode = null;
        while (node != null){
            if (node.item.equals(e)){
                if (beforeNode != null) {
                    beforeNode.next = node.next;
                    node.next = null;
                    node = beforeNode.next;
                    size--;
                } else {
                    remove(0);
                    node = firstNode;
                }
                isChanged = true;
            } else {
                beforeNode = node;
                node = node.next;
            }
        }
        return isChanged;
    }

    @Override
    public void clear() {
        firstNode = null;
        lastNode = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        if (index >= size) throw new IllegalArgumentException();
        Node<E> node = firstNode;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.item;
    }

    @Override
    public E set(int index, E element) {
        if (index >= size) throw new IllegalArgumentException();
        Node<E> node = firstNode;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        node.item = element;
        return node.item;
    }

    @Override
    public void add(int index, E element) {
        if (index >= size) throw new IllegalArgumentException();
        Node<E> node = firstNode;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        Node<E> newNode = new Node<>(element, node.previous, node);
        node.previous.next = newNode;
        node.previous = newNode;
        size++;
    }

    @Override
    public E remove(int index) {
        if (index >= size) throw new IllegalArgumentException();
        Node<E> node = firstNode;
        if (index == 0) firstNode = firstNode.next;
        if (index == size - 1) lastNode = lastNode.previous;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        if (node.previous != null) node.previous.next = node.next;
        if (node.next != null) node.next.previous = node.previous;
        size--;
        return node.item;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("[");
        for (Node<E> i = firstNode; i != null; i = i.next) {
            sb.append(i.item);
            if (i.next != null) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> currentNode = firstNode;

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public E next() {
                if (hasNext()) {
                    E value = currentNode.item;
                    currentNode = currentNode.next;
                    return value;
                }
                return null;
            }
        };
    }
}