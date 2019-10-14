package com.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

class MyFuncClass {
    public MyFuncClass() { }
    public MyFuncClass(int i) { }
    private void f1(){ }
    protected int f2(int i){ return 0;}
    public String f2(String s) {return "Java";}
}

public class ReflectionReadFunc {
    public static void main(String[] args) {
        Class<MyFuncClass> clazz = MyFuncClass.class;
        Method[] methods = clazz.getDeclaredMethods();
        for (Method m : methods) {
            System.out.println(m);
        }
        Constructor[] c1= clazz.getDeclaredConstructors();
        for (Constructor c : c1) {
            System.out.println(c);
        }
    }
}
