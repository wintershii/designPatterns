package com.reflect.pro;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//提供服务的接口
interface Service {
    String sellCar(String carName);
}

//实现服务的类
class ServiceImp implements Service {

    @Override
    public String sellCar(String carName) {
        return carName + "is ready!";
    }
}

//实现了InvocationHandler接口, 它是包含在反射包中的
class MyInvocationHandler implements InvocationHandler {

    private Object target;

    //在构造函数中初始化target对象
    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    //通过invoke方法, 可以调用target类中的方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Call:" + method.getName());
        //通过method的invoke方法调用target类中的方法
        //args是参数
        Object result = method.invoke(target, args);
        return result;
    }
}

public class DynamicProxy {
    public static void main(String[] args) {
        //要被代理的真实对象
        Service service = new ServiceImp();
        //要代理哪个真实对象, 就把这个对象输进去
        InvocationHandler invocationHandler = new MyInvocationHandler(service);
        //通过第一个参数来指定加载代理对象的类加载器
        //通过第二个参数来指定为代理对象提供服务的接口
        //通过第三个参数把代理对象关联到invocationHandler这个对象上
        Service serviceProxy =(Service) Proxy.newProxyInstance(service.getClass().getClassLoader(),service.getClass().
                        getInterfaces(), invocationHandler);
        System.out.println(serviceProxy.sellCar("Aston Martin"));

    }
}
