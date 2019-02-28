package com.proxy;

/**
 * 客户类
 */
public class NormalHome implements ProxyInterface{

    @Override
    public void marry() {
        System.out.println("我们结婚啦～");
    }

}