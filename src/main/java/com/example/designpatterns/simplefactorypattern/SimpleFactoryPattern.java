package com.example.designpatterns.simplefactorypattern;

/**
 * @author ：lejb
 * @date ：Created in 2020/3/2 9:41
 * @description : 简单工厂模式
 */

/**
 * 在简单工厂模式中，可以根据参数的不同返回不同类的实例。简单工厂模式专门定义一个类来负责创建其他类的实例，被创建的实例通常都具有共同的父类。
 * 模式由Factory（工厂）,Product（抽象产品角色）,ConcreteProduct（具体产品角色）组成
 * Factory:工厂角色负责实现创建所有实例的内部逻辑(实现不同的参数返回不同的角色)
 * Product:工厂返回的抽象类，实现于类似多态的特性
 * ConcreteProduct:具体返回的角色结果，继承或实现了Product，在Factory中被创建
 * 在使用静态工厂时，调用方便，但是有一个缺点就是每增加一个产品都需要在静态工厂中写一个判断逻辑（例如Demo中增加case）。
 * 在以下的情况下可以使用静态工厂逻辑：工厂类负责创建的对象对较少，或者是客户端只需要记住要创建产品的参数即可创建
 * ps;也可以将一个类看做为工厂，里面的重载方法当作创建产品的不同入参的静态方法
 **/
public class SimpleFactoryPattern {

    /**
     * 创建静态工厂
     */
    private static Product productFactory(String choose) {
        /**
         * 由参数来选择工厂中的产品
         */
        switch (choose) {
            case "A":
                return new ConcreteProductA();
            case "B":
                return new ConcreteProductB();
            default:
                return null;
        }
    }

    public static void main(String[] args) {
       //获取A产品
       productFactory("A");
       //获取B产品
       productFactory("B");
    }
}
