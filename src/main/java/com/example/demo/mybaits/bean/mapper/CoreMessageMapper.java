package com.example.demo.mybaits.bean.mapper;

import com.example.demo.mybaits.bean.entity.CoreMessage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CoreMessageMapper {

    List<CoreMessage> findAll();

}
