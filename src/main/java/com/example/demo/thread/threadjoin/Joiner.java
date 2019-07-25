package com.example.demo.thread.threadjoin;

/**
 * @author ：lejb
 * @date ：Created in 2019/4/21 9:09
 */

public class Joiner extends Thread {
    private Sleeper sleeper;

    public Joiner(String name, Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        start();
    }

    @Override
    public void run() {
        try {
            sleeper.join();
        } catch (InterruptedException e) {
            System.out.println("isInterrupted");
        }
        System.out.println(getName() + " join completed");
    }

}
