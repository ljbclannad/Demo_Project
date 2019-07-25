package com.example.demo.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author ：lejb
 * @date ：Created in 2019/5/5 15:48
 */

public class CallableTest {

    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        while (true){
//            executorService.execute(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println(Thread.currentThread().getName()+"is running");
//                    try {
//                        Thread.sleep(3000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            });
//        }
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("延迟十秒");
            }
        },10,TimeUnit.SECONDS);
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("延迟三秒,过一秒后接着执行");
            }
        },1,3,TimeUnit.SECONDS);

    }
}
