package ru.home.aglar.threads;

public class PingPong {
    public static void main(String[] args) {
        PingPong pingPong = new PingPong();
        Object obj = new Object();
        pingPong.printWord("ping", obj);
        pingPong.printWord("pong", obj);
    }

    public void printWord(String word, Object monitor) {
        new Thread(() -> {
            synchronized (monitor) {
                while (true) {
                    monitor.notify();
                    System.out.println(word);
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }).start();
    }
}