package com.example.demo.proxytest;

/**
 * @author ：lejb
 * @date ：Created in 2020/2/12 17:35
 * @description :
 */

public class StaticProxy implements HelloInterface {

    private HelloInterface helloInterface;

    public StaticProxy(HelloInterface helloInterface) {
        this.helloInterface = helloInterface;
    }

    public void setHelloInterface(HelloInterface helloInterface) {
        this.helloInterface = helloInterface;
    }

    @Override
    public void sayHello() {
        System.out.println("开启静态代理，打印加强内容");
        helloInterface.sayHello();
    }

    @Override
    public void sayBye() {
        System.out.println("开启静态代理，打印加强内容");
        helloInterface.sayHello();
    }

    public static void main(String[] args) {
        //传入需要被代理类，实现加强
        new StaticProxy(new Hello()).sayHello();
    }
}
