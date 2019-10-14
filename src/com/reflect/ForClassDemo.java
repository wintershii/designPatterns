package com.reflect;

class MyClass {
    public void print() {
        System.out.println("Java");
    }
}

public class ForClassDemo {
    public static void main(String[] args) {
        MyClass myClassObj = new MyClass();
        myClassObj.print();

        try {
            Class<?> clazz = Class.forName("com.reflect.MyClass");
            MyClass my = (MyClass) clazz.newInstance();
            my.print();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
