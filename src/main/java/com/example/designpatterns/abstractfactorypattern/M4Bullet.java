package com.example.designpatterns.abstractfactorypattern;

/**
 * @author ：lejb
 * @date ：Created in 2020/3/2 15:25
 * @description : 具体产品类
 */

public class M4Bullet implements Bullet {
    @Override
    public void load() {
        System.out.println("Load bullets with M4");
    }
}
