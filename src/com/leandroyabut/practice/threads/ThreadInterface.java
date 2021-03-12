package com.leandroyabut.practice.threads;

public class ThreadInterface implements Runnable{
    @Override
    public void run() {
        System.out.println("Running thread from thread interface...");
    }
}
