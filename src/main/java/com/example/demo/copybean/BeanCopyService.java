package com.example.demo.copybean;

/**
 * @author ：lejb
 * @date ：Created in 2020/3/4 11:33
 * @description :
 */
public interface BeanCopyService {

    /**
     * 使用的工具包名称
     * @return
     */
    String methodName();

    /**
     * 执行复制
     * @param fromBean
     * @return
     * @throws Exception
     */
    ToBean copyProperty(FromBean fromBean) throws Exception;
}
