package com.renjack.webdemo.tools;

import org.quartz.Job;
import org.quartz.JobExecutionContext;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HelloJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext){
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        System.out.println("当前的时间为(HelloJob)：" + localDateTime.format(dateTimeFormatter));
        //编写具体的业务逻辑
    }

}