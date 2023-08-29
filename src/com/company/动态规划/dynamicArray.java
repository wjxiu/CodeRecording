package com.company.动态规划;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author xiu
 * @create 2023-08-21 14:00
 */
public class dynamicArray implements InvocationHandler {
    Object source;
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("a");
        Object invoke = method.invoke(source,args);
        System.out.println("b");
        return invoke;
    }

    public Object getinstance(Object source){
        this.source=source;
        return  Proxy.newProxyInstance(source.getClass().getClassLoader(), source.getClass().getInterfaces(), this);
    }

    public dynamicArray() {
    }
}
