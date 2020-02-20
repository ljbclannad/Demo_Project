package com.example.demo.proxytest;

import java.io.File;

/**
 * @author ：lejb
 * @date ：Created in 2020/2/12 17:35
 * @description :
 */

public class Hello implements HelloInterface{

    @Override
    public void sayHello() {
        System.out.println("hello");
    }

    @Override
    public void sayBye() {
        System.out.println("bye");
    }

    public static void main(String[] args) {

        String s = "a1";
        System.out.println(s.matches("^[0-9]*$"));
        //传入的是CSV
//        if(file.name.indexof("xlsx") != -1 || file.name.indexof("xls") != -1|| file.name.indexof("csv") != -1)

    }
}
