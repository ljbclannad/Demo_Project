package com.example.demo.thread.threadjoin;

/**
 * @author ：lejb
 * @date ：Created in 2019/4/21 9:11
 */

public class Joining {
    public static void main(String[] args) {
        Sleeper sleepey = new Sleeper("sleepy",500);
        Sleeper grumpy = new Sleeper("grumpy",1500);
        Joiner dopey = new Joiner("Dopey",sleepey);
        Joiner doc = new Joiner("Doc",grumpy);

        grumpy.interrupt();
    }
}
