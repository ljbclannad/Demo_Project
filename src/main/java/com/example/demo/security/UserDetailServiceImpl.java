package com.example.demo.security;

import com.example.demo.mybaits.bean.entity.UserInfo;
import com.example.demo.mybaits.bean.mapper.UserInfoMapper;
import com.sun.security.auth.UserPrincipal;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author ：lejb
 * @date ：Created in 2019/9/9 16:22
 * @description :
 */
@Service
@Slf4j
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserInfo userInfo = new UserInfo();
        userInfo.setName(s);
        userInfo = userInfoMapper.selectOne(userInfo);
        return new UserInfoDetails(userInfo);
    }
}
