package com.example.demo.copybean;

import com.alibaba.fastjson.JSON;

/**
 * @author ：lejb
 * @date ：Created in 2020/3/4 11:37
 * @description :
 */

public class BeanCopyClient {

    public void execute(BeanCopyService beanCopyService, FromBean fromBean) throws Exception {
        System.out.println("=========================");
        System.out.println("使用的工具包：" + beanCopyService.methodName());
        ToBean toBean = beanCopyService.copyProperty(fromBean);
        System.out.println("复制后的对象：" + JSON.toJSONString(toBean));
    }
}
