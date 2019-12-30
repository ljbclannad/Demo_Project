package com.example.demo.thread.threadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author ：lejb
 * @date ：Created in 2019/12/30 15:28
 * @description : 扩展线程池Demo
 */
@Slf4j
public class ExtThreadPool {

    public static class MyTask implements Runnable {

        public String name;

        public MyTask(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println("正在执行" + Thread.currentThread().getId() + ",Task Name:" + name);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                log.info(e.getMessage());
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                return thread;
            }
        }) {
            @Override
            protected void beforeExecute(Thread t, Runnable r) {
                System.out.println("准备执行");
            }

            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                System.out.println("执行结束");
            }

            @Override
            protected void terminated() {
                System.out.println("线程池退出");
            }
        };

        long cpuAccount = Runtime.getRuntime().availableProcessors();
        System.out.println(cpuAccount);

        for (int i = 0; i < 5; i++) {
            MyTask myTask = new MyTask("My Task" + i);
            executorService.submit(myTask);
            Thread.sleep(1000);
        }

        executorService.shutdown();
    }

}
