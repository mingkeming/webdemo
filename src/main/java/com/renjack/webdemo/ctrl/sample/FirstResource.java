package com.renjack.webdemo.ctrl.sample;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import com.renjack.webdemo.config.redis.RedisService;
import com.renjack.webdemo.entity.sample.TestDTO;
import com.renjack.webdemo.service.sample.TestService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 本类主要存储哥哥写法的基础类
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class FirstResource {

    @Autowired
    RedisService redisService;

    @Autowired
    private TestService testService ;

    @Autowired
    private Scheduler scheduler;

    @PostMapping(value = "/insertBatch")
    public Map changeJobSwitch(){
        //参数传递数组
        //redisService.set("city_baoji1","{\"weather\":\"雨\",\"temperature\":\"7\"}",1000, TimeUnit.SECONDS);
        String q = redisService.get("city_baoji1");
        Map<String,Object> retData = new HashMap<>();
        List<TestDTO> testDTOs = new ArrayList<>();
        TestDTO lists = testService.findTest(1L);
        //List<Test> insertedData = testService.batchInsert(testDTOs);
        //log.debug("data:{} ",JSONArray.toJSONString(insertedData));
        //retData.put("retData",insertedData);
        log.trace("trace");
        log.debug("debug");
        log.info("info");
        log.warn("warn");
        log.error("error");
        return retData;
    }

    /**
     * 开启定时任务
     * @return
     * @throws SchedulerException
     */
    @PostMapping(value = "/openJob")
    public Map openJob() throws SchedulerException {
        Map<String,Object> retData = new HashMap<>();
        changeTheJob("0/2 * * * * ?");
        return retData;
    }

    /**
     * 调整日志级别
     * @param logLevel
     * @return
     */
    @RequestMapping(value = "logLevel/{logLevel}")
    public String changeLogLevel(@PathVariable("logLevel") String logLevel) {
        try {
            LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
            loggerContext.getLogger("org.mybatis").setLevel(Level.valueOf(logLevel));
            loggerContext.getLogger("org.springframework").setLevel(Level.valueOf(logLevel));
            loggerContext.getLogger("com.renjack.webdemo.ctrl").setLevel(Level.valueOf(logLevel));
        } catch (Exception e) {
            log.error("动态修改日志级别出错", e);
            return "fail";
        }

        return "success";
    }

    private void changeTheJob(String corn) throws SchedulerException {
        try{
            JobDetail jobDetail = JobBuilder.newJob((Class<? extends Job>) Class.forName("com.renjack.webdemo.tools.HelloJob")).withIdentity("myJob1","group1").build();
            Trigger trigger = TriggerBuilder.newTrigger().withIdentity("myTrigger1","group1").startNow()
                    .withSchedule(CronScheduleBuilder.cronSchedule(corn)).build();

            //需要将jobDetail和trigger传进去，并将jobDetail和trigger绑定在一起。
            JobKey jobKey = new JobKey("myJob1","group1");
            scheduler.deleteJob(jobKey);
            scheduler.scheduleJob(jobDetail,trigger);
        }catch(Exception e){
            System.out.println(1);
        }
    }
}
