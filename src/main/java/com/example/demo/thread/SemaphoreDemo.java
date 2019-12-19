package com.example.demo.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author ：lejb
 * @date ：Created in 2019/12/19 15:12
 * @description : 线程控制信号量DEMO
 */
@Slf4j
public class SemaphoreDemo implements Runnable {

    //包含5个许可的信号量，即一次可以有5个线程访问资源
    private final Semaphore semaphore = new Semaphore(5);

    @Override
    public void run() {
        try {
            //尝试获得准入的许可
            semaphore.acquire();
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getId());
        }catch (InterruptedException e){
            log.info(e.getMessage());
        }finally {
            //释放一个许可
            semaphore.release();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        final SemaphoreDemo semaphoreDemo = new SemaphoreDemo();
        for (int i = 0; i <20 ; i++) {
            //当多个线程一起请求semaphoreDemo的run时，一次只能有5个请求进入semaphoreDemo的run方法
            executorService.submit(semaphoreDemo);
        }
    }
}
