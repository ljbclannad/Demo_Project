package com.example.demo.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author ：lejb
 * @date ：Created in 2019/4/20 7:54
 */

public class SimplePriorities implements Runnable {

    private int countDown = 5;
    private volatile double d;
    private int priority ;
    public SimplePriorities(int priority){
        this.priority = priority;
    }

    @Override
    public String toString(){
        return Thread.currentThread()+":"+countDown;
    }
    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);
        while (true){
            for (int i = 0; i <10000 ; i++) {
                d +=(Math.PI+Math.E)/i;
                if(i%1000 == 0){
                    Thread.yield();
                }
            }
            System.out.println(this);
            if(--countDown == 0) {
                return;
            }
        }
    }

    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i <5 ; i++) {
            executorService.execute(new SimplePriorities(Thread.MIN_PRIORITY));
        }
        executorService.execute(new SimplePriorities(Thread.MAX_PRIORITY));
        executorService.execute(new SimplePriorities(Thread.NORM_PRIORITY));
        executorService.shutdown();
    }
}
