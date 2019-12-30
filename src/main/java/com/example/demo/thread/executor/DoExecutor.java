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


    ExecutorService executor = new ThreadPoolExecutor(10, 10, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(10), new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            //创建新线程，每次都去执行Runnable.run方法
            Thread thread = new Thread(r);
            //设置为守护线程
            thread.setDaemon(true);
            System.out.println(1);
            return thread;
        }
    });

    private Consumer consumer;

    @PostMapping
    public  void doExecutor() {
        consumer = new Consumer("lejb","123456","123456");
        for (int i = 0; i <20 ; i++) {
//            executor.execute(consumer);
            //每提交一次任务就会调用线程池中的newThread方法。
            executor.submit(consumer);
        }
    }

}
