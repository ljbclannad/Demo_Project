package com.example.demo;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author ：lejb
 * @date ：Created in 2019/7/17 17:52
 */

@Component
//@PropertySource({"classpath:application.properties"})
public class TestBean {

    @Value("${spring.profiles.active}")
    private String springActive;

    @Value("${sss}")
    private String sss;

    public void testBean() {
        System.out.println(sss + springActive);
    }

    public static void main(String[] args) {
        TestBean testBean = new TestBean();
//        System.out.println(springActive);
//        System.out.println(sss);
//        testBean.testBean();
    }


}
