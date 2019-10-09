package com.example.demo.mybaits;

import com.example.demo.mybaits.bean.entity.UserInfo;
import com.example.demo.mybaits.bean.mapper.UserInfoMapper;
import com.example.demo.mybaits.service.UserInfoServiceImpl;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author ：lejb
 * @date ：Created in 2019/6/5 10:02
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInfoTest {

    @Autowired
    private UserInfoServiceImpl userInfoServiceImpl;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    public void selectByPrimaryKeyTest(){
        UserInfo userInfo = new UserInfo();
        userInfo.setId(8);
        userInfo.setName("lejinbo");
        userInfo.setPwd("12353412412");
        userInfoMapper.updateByPrimaryKeySelective(userInfo);
    }
}
