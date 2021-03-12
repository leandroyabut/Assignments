package com.leandroyabut.practice.singletons;

public class SingletonPractice {

    private static SingletonPractice instance = null;

    private SingletonPractice() {

    }

    /**
     * Get the only instance of object
     * @return instance of object
     */
    public static SingletonPractice getInstance() {
        synchronized (SingletonPractice.class) {
            if(instance == null) {
                instance = new SingletonPractice();
            }
        }
        return instance;
    }

}
