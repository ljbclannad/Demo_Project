package com.example.demo.thread;

import com.mchange.v1.lang.GentleThread;

/**
 * @author ：lejb
 * @date ：Created in 2019/12/13 10:16
 * @description : 线程中断测试类
 */

public class ThreadInterrupted {

    public static void main(String[] args) throws InterruptedException{
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (true){
                    //判断该线程是否被中断
                    if(Thread.currentThread().isInterrupted()){
                        System.out.println("isInterrupted");
                        break;
                    }
                    try {
                        //睡眠2000ms
                        Thread.sleep(2000);
                    }catch (InterruptedException e){
                        System.out.println("Interruted When Sleep");
                        //中断线程(下次循环时判断线程为中断状态)
                        Thread.currentThread().interrupt();
                    }
                    Thread.yield();
                }
            }
        };

        thread.start();
        //线程睡眠时抛出中断异常
        Thread.sleep(2000);
        thread.interrupt();
    }

}
