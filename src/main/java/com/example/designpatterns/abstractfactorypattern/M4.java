package com.example.designpatterns.abstractfactorypattern;

/**
 * @author ：lejb
 * @date ：Created in 2020/3/2 15:24
 * @description : 具体产品类
 */

public class M4 implements Gun {
    @Override
    public void shooting() {
        System.out.println("Shooting With M4");
    }
}
