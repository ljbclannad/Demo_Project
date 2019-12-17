package com.example.demo.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：lejb
 * @date ：Created in 2019/12/17 10:19
 * @description : 多线程同步控制：重入锁
 */
@Slf4j
public class ReenterLock implements Runnable {

//    public static ReentrantLock lock = new ReentrantLock();
    //创建公平的重入锁
    public static ReentrantLock lock = new ReentrantLock(true);
    public static int j = 0;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            //重入锁加锁
            lock.lock();
            try {
                j++;
            } finally {
                //重入锁解锁
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ReenterLock reenterLock = new ReenterLock();
        Thread t1 = new Thread(reenterLock);
        Thread t2 = new Thread(reenterLock);
        t1.start();
        t2.start();
        System.out.println(j);
    }
}
