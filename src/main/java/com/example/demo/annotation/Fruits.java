package com.example.demo.annotation;

import java.lang.annotation.*;

/**
 * @author ：lejb
 * @date ：Created in 2019/4/26 8:56
 * @Description 注解类
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD})
@Documented
public @interface  Fruits {
    String name();
    int age() ;
    int[] score();
}
