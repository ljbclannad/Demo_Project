package com.example.demo.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ：lejb
 * @date ：Created in 2019/12/13 15:10
 * @description : 守护线程Demo类
 */
@Slf4j
public class DaemonDemo {

    public static class Daemon extends Thread{
        @Override
        public void run(){
            while (true){
                System.out.println("I am alive");
                try {
                    Thread.sleep(2000);
                }catch (InterruptedException e){
                    log.info(e.getMessage());
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        Thread t = new Daemon();
        //设置为守护线程，如果线程结束则退出
        t.setDaemon(true);
        t.start();

        Thread.sleep(2000);
    }
}
