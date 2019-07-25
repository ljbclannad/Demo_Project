package com.example.demo.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author ：lejb
 * @date ：Created in 2019/4/26 9:08
 */

public class TestAnnotation {

    public static void main(String[] args) throws Exception{
        Class studentClass = Class.forName("com.example.demo.annotation.ClassMates");
        Method stuMethod = studentClass.getMethod("study");
        Fruits fruits = stuMethod.getAnnotation(Fruits.class);

        ClassMates classMates = new ClassMates();
        Fruits fruits1 = classMates.getClass().getMethod("study").getAnnotation(Fruits.class);

        System.out.println(fruits.name());
        System.out.println(fruits1.name());

    }
}
