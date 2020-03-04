package com.example.designpatterns.abstractfactorypattern;

/**
 * @author ：lejb
 * @date ：Created in 2020/3/2 15:28
 * @description : 具体工厂类
 */

public class M4Factory implements AbstractFatory {
    @Override
    public Gun produceGun() {
        return new M4();
    }

    @Override
    public Bullet produceBullet() {
        return new M4Bullet();
    }
}
