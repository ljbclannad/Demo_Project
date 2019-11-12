package com.example.demo;

import com.example.demo.redis.RedisTest;
import org.checkerframework.checker.units.qual.A;
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

    @Autowired
    private RedisTest redisTest;

    @Test
    public void test(){
        System.out.println(springActive);
        System.out.println(sss);
    }

    @Test
    public void test1(){
        testBean.testBean();
    }

    @Test
    public void testRedis(){
        redisTest.testRedis("123456","17681879260");
    }
}
