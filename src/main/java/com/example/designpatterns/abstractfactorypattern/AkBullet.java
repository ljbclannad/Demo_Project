package com.example.designpatterns.abstractfactorypattern;

/**
 * @author ：lejb
 * @date ：Created in 2020/3/2 15:25
 * @description :
 */

public class AkBullet implements Bullet {
    @Override
    public void load() {
        System.out.println("Load bullets with AK");
    }
}
