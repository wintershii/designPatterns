package com.singleton;

/**
 * 懒汉式(线程安全)
 */
public class Singleton2 {
    private static Singleton2 singleton;

    private Singleton2() {
    }

    /**
     * 使用了synchronized关键字
     * @return
     */
    public static synchronized Singleton2 getInstance() {
        if (singleton == null) {
            singleton = new Singleton2();
        }
        return singleton;
    }
}
