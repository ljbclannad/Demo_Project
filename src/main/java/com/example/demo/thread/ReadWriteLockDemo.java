package com.example.demo.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author ：lejb
 * @date ：Created in 2019/12/19 16:08
 * @description : 读写锁Demo
 */
@Slf4j
public class ReadWriteLockDemo {

    //创建重入锁
    private static Lock lock = new ReentrantLock();
    //创建读写锁
    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    //创建读锁
    private static Lock readLock = readWriteLock.readLock();
    //创建写锁
    private static Lock writeLock = readWriteLock.writeLock();

    private int value;

    /**
     * @param: [lock]
     * @return: java.lang.Object
     * @description: 模拟读操作
     * @author: lejb
     * @date: 2019/12/19 16:12
     */
    public Object handleRead(Lock lock) throws InterruptedException{
        try {
            lock.lock();
            Thread.sleep(5000);
            return value;
        }finally {
            lock.unlock();
        }
    }

    /**
     * @param: [lock]
     * @return: java.lang.Object
     * @description: 模拟写操作
     * @author: lejb
     * @date: 2019/12/19 16:12
     */
    public void handleWrite(Lock lock ,Integer value) throws InterruptedException{
        try {
            lock.lock();
            Thread.sleep(5000);
            this.value = value;
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        final ReadWriteLockDemo demo = new ReadWriteLockDemo();

        //调用读操作，用重入锁和读写锁分别进行加锁，获取读操作执行的时间
        Runnable readRunable = new Runnable() {
            @Override
            public void run() {
                try {
                    //用重入锁加锁
                    demo.handleRead(lock);
//                    用读锁加锁
//                    demo.handleRead(readLock);
                }catch (InterruptedException e){
                    log.info(e.getMessage());
                }
            }
        };

        //调用读操作，用重入锁和读写锁分别进行加锁，获取写操作执行的时间
        Runnable writdRunable = new Runnable() {
            @Override
            public void run() {
                try {
                    //用重入锁加锁
                    demo.handleWrite(lock,10);
                    //用写锁加锁
//                    demo.handleWrite(writeLock,10);
                }catch (InterruptedException e){
                    log.info(e.getMessage());
                }
            }
        };

        System.out.println(System.currentTimeMillis());
        for (int i = 0; i <18 ; i++) {
            new Thread(readRunable).start();
        }
        System.out.println(System.currentTimeMillis());

        for (int i = 18; i <20 ; i++) {
            new Thread(writdRunable).start();
        }
        System.out.println(System.currentTimeMillis());
    }

}
