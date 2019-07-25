package com.example.demo.annotation;

/**
 * @author ：lejb
 * @date ：Created in 2019/4/26 9:04
 */

public class ClassMates {
    @Fruits(name = "lejb",age = 181,score = {1,2,3})
    public void study(){
        System.out.println("study");
    }
}
