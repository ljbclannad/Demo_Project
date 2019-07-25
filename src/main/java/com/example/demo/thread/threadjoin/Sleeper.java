package com.example.demo.thread.threadjoin;

/**
 * @author ：lejb
 * @date ：Created in 2019/4/21 9:06
 */

public class Sleeper extends Thread {
    private int duration;

    public Sleeper(String name, int sleepTime) {
        super(name);
        duration = sleepTime;
        start();
    }

    @Override
    public void run() {
        try {
            sleep(duration);
        } catch (InterruptedException e) {
            System.out.println(getName() + " was interrupted" + "isInterrupted" + isInterrupted());
        }
        System.out.println(getName() + " has awakened");
    }

}
