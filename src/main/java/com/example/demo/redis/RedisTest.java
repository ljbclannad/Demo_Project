package com.example.demo.redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author ：lejb
 * @date ：Created in 2019/11/12 10:22
 * @description :
 */
@Component
public class RedisTest {

    @Resource(name = "redisTemplate")
    private RedisTemplate redisTemplate;

    public void testRedis(String code, String phone) {
        redisTemplate.opsForValue().set(phone, code);
        System.out.println(redisTemplate.opsForValue().get(phone));
    }
}
