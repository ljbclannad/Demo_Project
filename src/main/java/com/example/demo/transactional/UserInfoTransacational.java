package com.example.demo.transactional;

import com.example.demo.mybaits.bean.entity.UserInfo;
import com.example.demo.mybaits.bean.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ：lejb
 * @date ：Created in 2019/7/4 15:01
 * @Description 事务测试
 */
@Component
public class UserInfoTransacational {

    @Autowired
    UserInfoMapper userInfoMapper;

    @Transactional(rollbackFor = Exception.class)
    public  void insertUserInfo(){
        UserInfo userInfo = new UserInfo();
        userInfo.setName("lejb");
        userInfo.setPwd("123");
        userInfoMapper.insert(userInfo);
        if("1".equals("1")){
            throw new RuntimeException();
        }
    }
}
