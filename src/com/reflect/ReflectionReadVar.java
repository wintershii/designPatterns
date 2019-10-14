package com.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

class MyValClass {
    private int val1;
    public String val2;
    final protected String val3 = "Java";
}

public class ReflectionReadVar {
    public static void main(String[] args) {
        Class<MyValClass> clazz = MyValClass.class;
        //获取这个类的所有属性
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            //输出修饰符
            System.out.print(Modifier.toString(f.getModifiers()) + "  ");
            //输出属性的类型
            System.out.print(f.getGenericType() + "  ");
            //输出属性的名称
            System.out.println(f.getName());
        }
    }
}
