//package com.renjack.webdemo.config.schedule;
//
//import com.fasterxml.jackson.annotation.JsonAutoDetect;
//import com.fasterxml.jackson.annotation.PropertyAccessor;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.renjack.webdemo.tools.HelloJob;
//import com.renjack.webdemo.tools.HelloJob1;
//import org.quartz.*;
//import org.quartz.impl.StdSchedulerFactory;
//import org.springframework.cache.CacheManager;
//import org.springframework.cache.annotation.CachingConfigurerSupport;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.cache.RedisCacheConfiguration;
//import org.springframework.data.redis.cache.RedisCacheManager;
//import org.springframework.data.redis.cache.RedisCacheWriter;
//import org.springframework.data.redis.connection.RedisPassword;
//import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
//import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.RedisSerializationContext;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
//import java.time.Duration;
//import java.util.HashMap;
//import java.util.Map;
//
//@Configuration
//public class ScheduleConfig {
//
//    @Bean
//    public Scheduler scheduler() throws SchedulerException {
//        /**
//         * JobDetail：用来绑定Job，并且在job执行的时候携带一些执行的信息
//         */
//        //创建一个JobDetail实例，将该实例与HelloJob Class绑定
//        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class).withIdentity("myJob","group").build();
//
//        JobDetail jobDetail1 = JobBuilder.newJob(HelloJob1.class).withIdentity("myJob1","group1").build();
//
//        /**
//         * Trigger：用来触发job去执行的，包括定义了什么时候去执行，
//         * 第一次执行，是否会一直重复地执行下去，执行几次等
//         */
//        //创建一个Trigger实例，定义该job立即执行，并且每隔2秒钟重复执行一次，直到程序停止
//        /**
//         * trigger通过builder模式来创建，TriggerBuilder.newTrigger()
//         * withIdentity():定义一个标识符，定义了组
//         * startNow()：定义现在开始执行，
//         * withSchedule(SimpleScheduleBuilder.simpleSchedule()：withSchedule也是builder模式创建
//         *.withIntervalInSeconds(2).repeatForever())：定义了执行频度：每2秒钟执行一次，不间断地重复执行
//         * build()：创建trigger
//         */
//        Trigger trigger1 = TriggerBuilder.newTrigger().withIdentity("myTrigger","group").startNow()
//                //.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(3).repeatForever()).build();
//                .withSchedule(CronScheduleBuilder.cronSchedule("0/3 * * * * ?")).build();
//        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("myTrigger1","group1").startNow()
//                .withSchedule(CronScheduleBuilder.cronSchedule("0/3 * * * * ?")).build();
//        //创建scheduler实例：
//        /**
//         * scheduler区别于trigger和jobDetail，是通过factory模式创建的
//         */
//        //创建一个ScheduleFactory
//        SchedulerFactory sfact = new StdSchedulerFactory();
//        Scheduler scheduler = sfact.getScheduler();
//        scheduler.start();
//
//        //需要将jobDetail和trigger传进去，并将jobDetail和trigger绑定在一起。
//        scheduler.scheduleJob(jobDetail,trigger);
//        scheduler.scheduleJob(jobDetail1,trigger1);
//        return scheduler;
//    }
//
//}
