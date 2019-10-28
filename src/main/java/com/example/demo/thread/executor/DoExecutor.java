package com.example.demo.thread.executor;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.*;

/**
 * @author ：lejb
 * @date ：Created in 2019/10/25 10:12
 * @description : 线程池调用类
 */

@RestController
@RequestMapping("doExecutor")
@Slf4j
@Api(value = "调用线程池业务")
public class DoExecutor {

    ExecutorService executor = new ThreadPoolExecutor(10, 10, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(10));

    private Consumer consumer;

    @PostMapping
    public  void doExecutor() {
        consumer = new Consumer("lejb","123456","123456");
        executor.execute(consumer);
    }

}
