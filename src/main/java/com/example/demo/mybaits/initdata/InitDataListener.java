package com.example.demo.mybaits.initdata;

import com.example.demo.mybaits.service.CoreMessageServiceImpl;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
import java.util.Map;

/**
 * @author ：lejb
 * @date ：Created in 2019/6/5 10:09
 * @Description 数据库加载配置 放入map中
 */
@Service
public class InitDataListener implements InitializingBean, ServletContextAware {

    @Autowired
    private CoreMessageServiceImpl coreMessageService;

    public static Map<String,String> messageMap;


    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        messageMap =coreMessageService.findAll();
    }
}
