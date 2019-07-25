package com.example.demo.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author ：lejb
 * @date ：Created in 2019/6/3 14:00
 */

public class HelloScheduler {
    public static void main(String[] args) throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(HellJob.class).withIdentity("helloJob").build();
//        SimpleTrigger trigger = TriggerBuilder.newTrigger().withIdentity("helloTrigger").startNow().withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever()).build();
        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ? ")).build();
        //创建schedule实例
        StdSchedulerFactory factory = new StdSchedulerFactory();
        Scheduler scheduler = factory.getScheduler();
//        scheduler.scheduleJob(jobDetail,trigger);
        scheduler.scheduleJob(jobDetail,cronTrigger);
        scheduler.start();
    }
}
