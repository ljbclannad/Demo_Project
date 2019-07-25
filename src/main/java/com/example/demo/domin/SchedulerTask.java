package com.example.demo.domin;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class SchedulerTask {

    public static int count = 0;

    @Scheduled(cron = "0/5 * * * * ? ")
    public void process() throws Exception {
        System.out.println("this is scheduler task running" + (count++));
    }

    private static void SchedulerTaskTest() {
        System.out.println(1);
    }

}
