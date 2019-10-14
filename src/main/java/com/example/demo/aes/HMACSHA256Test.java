package com.example.demo.aes;

/**
 * @author ：lejb
 * @date ：Created in 2019/10/14 15:29
 * @description :HMAC-SHA256签名算法测试类
 **/

public class HMACSHA256Test {

    public static void main(String[] args) {
        //加密内容
        String content = "需要加密的内容";
        //加密的key值
        String key = "9p50184Pul11JzYH";
        //进行加密
        System.out.println(HMACSHA256.sha256_HMAC(content,key));
    }
}
