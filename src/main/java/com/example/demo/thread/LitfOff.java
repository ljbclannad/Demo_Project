package com.example.demo.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author ：lejb
 * @date ：Created in 2019/4/18 18:40
 */

public class LitfOff implements Runnable{
    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = ++taskCount;

    public LitfOff(){}

    protected LitfOff(int countDown){
        this.countDown = countDown;
    }

    public String status(){
        return "#"+id+countDown;
    }

    @Override
    public void run() {
        while (countDown-- >0){
            System.out.println(status());
//            Thread.yield();
            try{
                Thread.sleep(2000);
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) throws Exception {
        LitfOff litfOff = new LitfOff();
        litfOff.run();
        //线程启动
        Thread t = new Thread(new LitfOff());
        t.start();
        System.out.println("Waiting for LiftOff");
        //多线程启动
//        for (int i = 0; i <5 ; i++) {
//            new Thread(new LitfOff()).start();
//        }
//        System.out.println("Waiting for LiftOff");


//        ExecutorService exec = Executors.newFixedThreadPool(5);
//        for (int i = 0; i <5 ; i++) {
//            exec.execute(new LitfOff());
//        }
//        exec.shutdown();
    }
}
