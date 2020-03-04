package com.example.designpatterns.fatorymethodpattern;

/**
 * @author ：lejb
 * @date ：Created in 2020/3/2 11:33
 * @description : 创建工厂类A
 */

public class FactoryA implements AbstractFactory {

    @Override
    public Shape getShape() {
        return new ShapeA();
    }
}
