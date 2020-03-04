package com.example.designpatterns.abstractfactorypattern;

/**
 * @author ：lejb
 * @date ：Created in 2020/3/2 11:55
 * @description :抽象工厂模式
 */

/**
 * 在工厂方法模式中，我们生产的都是同一类产品，都是继承抽象产品类。在抽象工厂中不单单可以创建一种产品，而是创建一组产品
 * 抽象工厂（AbstractFactory）角色 ：是工厂方法模式的核心，与应用程序无关。任何在模式中创建的对象的工厂类必须实现这个接口。
 * 具体工厂类（ConcreteFactory）角色 ：这是实现抽象工厂接口的具体工厂类，包含与应用程序密切相关的逻辑，并且受到应用程序调用以创建某一种产品对象。
 * 抽象产品（Abstract Product）角色 ：工厂方法模式所创建的对象的超类型，也就是产品对象的共同父类或共同拥有的接口。
 * 具体产品（Concrete Product）角色 ：抽象工厂模式所创建的任何产品对象都是某一个具体产品类的实例。在抽象工厂中创建的产品属于同一产品族，这不同于工厂模式中的工厂只创建单一产品。
 * 一个具体工厂可以生成多个具体产品
 */
public class AbstractFactoryPattern {

    public static void main(String[] args) {
        AbstractFatory akFactory = new AkFactory();
        akFactory.produceGun().shooting();
        akFactory.produceBullet().load();

        AbstractFatory m4Factory = new M4Factory();
        m4Factory.produceGun().shooting();
        m4Factory.produceBullet().load();
    }
}
