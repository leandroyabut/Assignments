package com.leandroyabut.practice.threads;

public class Threads {

    public static void main(String[] args) {
        ThreadsPractice practice = new ThreadsPractice();

        Runnable threadInterface = new ThreadInterface();
        Thread thread = new Thread(threadInterface);

        practice.start();
        thread.start();
    }

}
