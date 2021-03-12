package com.leandroyabut.assignments.singleton;

public class SingletonClass {

    private static SingletonClass instance = null;

    public synchronized static SingletonClass getInstance() {
        if(instance == null) {
            synchronized (SingletonClass.class) {
                if(instance == null) {
                    instance = new SingletonClass();
                }
            }
        }
        return instance;
    }

    private SingletonClass() {} // Private constructor
}
