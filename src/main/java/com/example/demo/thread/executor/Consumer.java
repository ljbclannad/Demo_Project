package com.example.demo.thread.executor;

import io.swagger.annotations.Api;

/**
 * @author ：lejb
 * @date ：Created in 2019/10/25 11:00
 * @description : 业务处理类
 */
public class Consumer implements Runnable {

    private String name;

    private String certNum;

    private String phone;

    public Consumer() {
    }

    public Consumer(String name, String certNum, String phone) {
        this.name = name;
        this.certNum = certNum;
        this.phone = phone;
    }

    @Override
    public void run() {
        System.out.println("用户姓名" + name);
        System.out.println("用户身份证" + certNum);
        System.out.println("用户手机号" + phone);
    }
}
