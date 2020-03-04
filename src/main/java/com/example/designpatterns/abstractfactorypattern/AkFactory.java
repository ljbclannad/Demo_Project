package com.example.designpatterns.abstractfactorypattern;

/**
 * @author ：lejb
 * @date ：Created in 2020/3/2 15:27
 * @description : 具体工厂类
 */

public class AkFactory implements AbstractFatory {
    @Override
    public Gun produceGun() {
        return new Ak();
    }

    @Override
    public Bullet produceBullet() {
        return new AkBullet();
    }
}
