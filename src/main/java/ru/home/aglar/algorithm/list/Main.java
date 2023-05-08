package ru.home.aglar.algorithm.list;

public class Main {
    public static void main(String[] args) {
        List<Integer> link = new MyLinkedList<>();
        System.out.println("isEmpty = " + link.isEmpty());
        link.add(0);
        link.add(1);
        link.add(2);
        link.add(1, 3);
        link.add(3, 4);
        link.display();
        System.out.printf("isEmpty = %s, size = %d, contains(3) = %s, contains(444) = %s%n",
                link.isEmpty(), link.size(), link.contains(3), link.contains(444));
        link.set(3, 6);
        System.out.println(link.get(3));
        link.remove(new Integer(1));
        link.display();
        link.remove(0);
        link.display();
        link.clear();
        link.display();

        List<Integer> array = new MyArrayList<>();
        System.out.println("isEmpty = " + array.isEmpty());
        array.add(0);
        array.add(1);
        array.add(2);
        array.add(1, 3);
        array.add(3, 4);
        array.display();
        System.out.printf("isEmpty = %s, size = %d, contains(3) = %s, contains(444) = %s%n",
                array.isEmpty(), array.size(), array.contains(3), array.contains(444));
        array.set(3, 6);
        System.out.println(array.get(3));
        array.remove(new Integer(1));
        array.display();
        array.remove(0);
        array.display();
        array.clear();
        array.display();
    }
}