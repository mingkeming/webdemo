package com.renjack.webdemo;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication
//@MapperScan("com.renjack.webdemo.dao") 添加扫描的dao层
//@EnableSwagger2 开启swagger
public class WebdemoApplication {

	public static void main(String[] args) throws SchedulerException {
        SpringApplication app = new SpringApplication(WebdemoApplication.class);
        Environment env = app.run(args).getEnvironment();
        System.out.println(env.getProperty("server.port"));
        System.out.println("this is ok");
//
//        SchedulerFactory sfact = new StdSchedulerFactory();
//        Scheduler scheduler = sfact.getScheduler();
//        scheduler.start();
	}

	@Bean
    public Scheduler scheduler() throws SchedulerException {
	    SchedulerFactory sfact = new StdSchedulerFactory();
        Scheduler scheduler = sfact.getScheduler();
        scheduler.start();
        return  scheduler;
    }
}
