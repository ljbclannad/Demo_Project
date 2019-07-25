package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author ：lejb
 * @date ：Created in 2019/7/17 17:42
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class Test2 {

    @Value("${spring.profiles.active}")
    private String springActive;

    @Value("${sss}")
    private String sss;

    @Autowired
    private TestBean testBean;

    @Test
    public void test(){
        System.out.println(springActive);
        System.out.println(sss);
    }

    @Test
    public void test1(){
        testBean.testBean();
    }
}
