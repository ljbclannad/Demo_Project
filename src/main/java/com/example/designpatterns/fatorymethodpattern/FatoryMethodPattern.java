package com.example.designpatterns.fatorymethodpattern;

/**
 * @author ：lejb
 * @date ：Created in 2020/3/2 10:16
 * @description : 工厂方法模式
 */

/**
 *  在工厂方法模式中，我们不再提供一个统一的工厂类来创建所有的对象，而是针对不同的对象提供不同的工厂。也就是说 每个对象都有一个与之对应的工厂 。
 *  抽象工厂(Abstract Factory)角色：是工厂方法模式的核心，与应用程序无关。任何在模式中创建的对象的工厂类必须实现这个接口，与静态工作最重要的区别就是这个抽象工厂。
 *  具体工厂(Concrete Factory)角色 ：这是实现抽象工厂接口的具体工厂类，包含与应用程序密切相关的逻辑，并且受到应用程序调用以创建某一种产品对象。
 *  抽象产品(AbstractProduct)角色 ：工厂方法模式所创建的对象的超类型，也就是产品对象的共同父类或共同拥有的接口。
 *  具体产品(Concrete Product)角色 ：这个角色实现了抽象产品角色所定义的接口。某具体产品有专门的具体工厂创建，它们之间往往一一对应
 *  定义一个抽象工厂，通过实现这个抽象工厂创建不同的工厂类，不同的工厂类中调用抽象产品实现不同的具体产品
 *  核心的工厂类不再负责所有产品的创建，而是将具体创建工作交给子类去做。在子类的视实现中选择产品，完善了静态工厂的缺点（每次新增产品都要修改工厂类的判断）
 */
public class FatoryMethodPattern {

    public static void main(String[] args) {
        /**
         * Demo中创建了AbstractFactory抽象工厂类，创建了A，B两个工厂，分别用来选择A，B两个产品，如果需要新增产品C，只需创建一个工厂C，C工厂选择C产品即可
         */
        AbstractFactory abstractFactoryA = new FactoryA();
        Shape shapeA = abstractFactoryA.getShape();
        AbstractFactory abstractFactoryB = new FactoryB();
        Shape shapeB = abstractFactoryB.getShape();
    }
}
