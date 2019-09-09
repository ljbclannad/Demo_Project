package com.example.demo.security;

import com.example.demo.mybaits.bean.entity.UserInfo;
import com.example.demo.mybaits.bean.mapper.UserInfoMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：lejb
 * @date ：Created in 2019/9/9 14:53
 * @Description :SpringBoot+SpringSecurity+JWT
 */
@RestController
@RequestMapping("user")
@Slf4j
public class UserController {

    //密码加密(Bean需要用@Autowired进行注入)
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @ResponseBody
    @RequestMapping("admin")
    public String userAdmin() {
        return "userAdmin";
    }

    @PostMapping("register")
    public void register(@RequestBody UserInfo userInfo) throws Exception {
        log.info("请求的用户内容为:" + userInfo);
        UserInfo userInfo1 = new UserInfo();
        userInfo1.setName(userInfo.getName());
        userInfo1 = userInfoMapper.selectOne(userInfo1);
        if (userInfo1 != null) {
            throw new JwtException("该用户名已注册,请用其他用户名");
        }
        log.info(String.format("用户加密前密码为:%s,加密后密码为:%s", userInfo.getPwd(), bCryptPasswordEncoder.encode(userInfo.getPwd())));
        userInfo.setPwd(bCryptPasswordEncoder.encode(userInfo.getPwd()));
        userInfoMapper.insertSelective(userInfo);
    }

    @PostMapping("login")
    public String userLogin(@RequestBody UserInfo userInfo) {

        Map<String, Object> claims = new HashMap<>();
        claims.put("sub", userInfo.getName());
        claims.put("created", new Date());

        String token = Jwts.builder()
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + 604800 * 1000))
                .signWith(SignatureAlgorithm.HS512, "MyJwtSecret")
                .compact();
        //将生成的Token放入请求头中
        log.info("生成的token为:" + token);
        return token;
    }
}
