package com.example.demo.mybaits.service;

import com.example.demo.mybaits.bean.entity.UserInfo;
import com.example.demo.mybaits.bean.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author ：lejb
 * @date ：Created in 2019/6/5 9:30
 */
@Service
public class UserInfoServiceImpl {

    @Autowired
    private UserInfoMapper userInfoMapper;

    public UserInfo selectByPrimaryKey(Integer id){
        return userInfoMapper.selectByPrimaryKey(Long.valueOf(id));
    }
}
