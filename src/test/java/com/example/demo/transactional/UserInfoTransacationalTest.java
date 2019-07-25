package com.example.demo.transactional;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserInfoTransacationalTest {

    @Autowired
    private UserInfoTransacational userInfoTransacational;

    @Test
    public void userInfoTransacationTest() throws Exception{
        userInfoTransacational.insertUserInfo();
    }

}