package com.leandroyabut.assignments.deadlock;

public class Deadlock {

    public static void main(String[] args) {

        Object lock1 = new Object();
        Object lock2 = new Object();

        System.out.println("Deadlock start");

        new Thread(() -> {
            // Waiting for lock1
            synchronized (lock1) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2) {
                    System.out.println("Got lock 2!");
                }
            }
        }).start();

        new Thread(() -> {
            // Waiting for lock2
            synchronized (lock2) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1) {
                    System.out.println("Got lock 1!");
                }
            }
        }).start();

        System.out.println("Deadlock end");

    }

}
