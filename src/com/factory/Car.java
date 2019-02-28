package com.factory;

/**
 * 简单工厂模式
 * 抽象类
 */
abstract class Car {
    public abstract void run();

    public abstract void stop();
}

/**
 * 子类
 */
class Benz extends Car {
    public void run() {
        System.out.println("Benz开始启动了。。。。。");
    }

    public void stop() {
        System.out.println("Benz停车了。。。。。");
    }
}

/**
 * 子类
 */
class Ford extends Car {
    public void run() {
        System.out.println("Ford开始启动了。。。");
    }

    public void stop() {
        System.out.println("Ford停车了。。。。");
    }
}

/**
 * 工厂类
 */

class Factory {
    public static Car getCarInstance(String type) {
        Car c = null;
        if ("Benz".equals(type)) {
            c = new Benz();
        }
        if ("Ford".equals(type)) {
            c = new Ford();
        }
        return c;
    }
}