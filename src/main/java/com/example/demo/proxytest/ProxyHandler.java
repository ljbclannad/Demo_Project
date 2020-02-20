package com.example.demo.proxytest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author ：lejb
 * @date ：Created in 2020/2/12 17:40
 * @description :
 */

public class ProxyHandler implements InvocationHandler {

    private Object object;

    public ProxyHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before invoke "  + method.getName());
        //调用了代理类的方法
        method.invoke(object, args);
        System.out.println("After invoke " + method.getName());
        return null;
    }

    public static void main(String[] args) {
        HelloInterface hello = new Hello();

        //创建hello的代理控制器
        InvocationHandler handler = new ProxyHandler(hello);
        //通过Proxy类的静态方法newProxyInstance返回一个接口的代理实例。该对象也继承了interfaces
        HelloInterface helloProxy = (HelloInterface) Proxy.newProxyInstance(hello.getClass().getClassLoader(),hello.getClass().getInterfaces(),handler);
        helloProxy.sayHello();
        helloProxy.sayBye();
    }
}
