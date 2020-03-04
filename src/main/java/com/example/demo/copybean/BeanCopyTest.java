package com.example.demo.copybean;


import org.apache.commons.beanutils.BeanUtils;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author ：lejb
 * @date ：Created in 2020/3/4 11:39
 * @description :
 */

public class BeanCopyTest {

    public static void main(String[] args) throws Exception{

        FromBean fromBean = new FromBean();
        fromBean.setId("ID0001");
        fromBean.setName("张三");
        fromBean.setAge(18);
        fromBean.setCreateTime(new Date());
        fromBean.setMoney(new BigDecimal(100));

        //apache的BeanUtils
        BeanCopyService apacheBeanUtils = new BeanCopyService() {
            @Override
            public String methodName() {
                return "user apacheBeanUtils copy";
            }

            @Override
            public ToBean copyProperty(FromBean fromBean) throws Exception {
                ToBean toBean = new ToBean();
                BeanUtils.copyProperties(toBean,fromBean);
                return toBean;
            }
        };

        //spring的BeanUtils
        BeanCopyService springBeanUtils = new BeanCopyService() {
            @Override
            public String methodName() {
                return "spring BeanUtils";
            }

            @Override
            public ToBean copyProperty(FromBean fromBean) throws Exception {
                ToBean toBean = new ToBean();
                org.springframework.beans.BeanUtils.copyProperties(fromBean, toBean);
                return toBean;
            }
        };

        //进行测试（建议采用spring的beanUtils）
        BeanCopyClient client = new BeanCopyClient();
        //apache的BeanUtils
        client.execute(apacheBeanUtils, fromBean);
        //spring的BeanUtils
        client.execute(springBeanUtils, fromBean);

    }
}
