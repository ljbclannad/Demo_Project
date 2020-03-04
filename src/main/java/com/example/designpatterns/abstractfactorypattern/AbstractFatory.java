package com.example.designpatterns.abstractfactorypattern;

/**
 * @author ：lejb
 * @date ：Created in 2020/3/2 15:26
 * @description :抽象工厂类
 */
public interface AbstractFatory {

    Gun produceGun();

    Bullet produceBullet();
}
