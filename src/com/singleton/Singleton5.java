package com.singleton;

/**
 * 双重校验锁
 */
public class Singleton5 {
    private volatile static Singleton5 singleton;

    private Singleton5() {
    }

    public static Singleton5 getInstance() {
        if (singleton == null) {
            synchronized (Singleton5.class) {
                if (singleton == null) {
                    singleton = new Singleton5();
                }
            }
        }
        return singleton;
    }
}
