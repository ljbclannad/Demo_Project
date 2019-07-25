package com.example.demo.stopwatch;


import org.apache.commons.lang3.time.StopWatch;

/**
 * @author ：lejb
 * @date ：Created in 2019/7/5 14:27
 * @Description Java秒表计时器
 */
public class StopWatchDemo {

    public static void main(String[] args) throws Exception{
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Thread.sleep(2000);
        for (int i = 0; i < 9; i++) {
            System.out.println(1);
            System.out.println(stopWatch.getTime());
        }
        System.out.println(1);
        stopWatch.stop();
        System.out.println(stopWatch.getTime());
    }
}
