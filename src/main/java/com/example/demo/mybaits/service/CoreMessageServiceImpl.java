package com.example.demo.mybaits.service;

import com.example.demo.mybaits.bean.entity.CoreMessage;
import com.example.demo.mybaits.bean.mapper.CoreMessageMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：lejb
 * @date ：Created in 2019/6/5 10:24
 */
@Service
@Slf4j
public class CoreMessageServiceImpl {

    @Autowired
    private CoreMessageMapper coreMessageMapper;

    public Map<String,String> findAll(){
        List<CoreMessage> list = coreMessageMapper.findAll();
        if(list == null || list.size() < 1){
            //TODO 抛出异常配置不准确
            log.info("系统配置里没有短信配置,请配置");
        }
        Map<String,String> messageMap = new HashMap<>();
        list.forEach(coreMessage -> {
            messageMap.put(String.valueOf(coreMessage.getId()),coreMessage.getMessage());
        });
        return messageMap;
    }
}
