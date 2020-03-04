package com.example.designpatterns.abstractfactorypattern;

/**
 * @author ：lejb
 * @date ：Created in 2020/3/2 15:22
 * @description : 具体产品类
 */

public class Ak implements Gun{
    @Override
    public void shooting() {
        System.out.println("Shooting With Ak");
    }
}
