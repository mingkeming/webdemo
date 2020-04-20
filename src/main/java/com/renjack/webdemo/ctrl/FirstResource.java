package com.renjack.webdemo.ctrl;

import com.renjack.webdemo.config.redis.RedisService;
import com.renjack.webdemo.entity.TestDTO;
import com.renjack.webdemo.service.TestService;
import com.renjack.webdemo.tools.HelloJob;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Map changeJobSwitch() throws SchedulerException {
        //参数传递数组
        //String q = redisService.get("applet_access_token1");
        Map<String,Object> retData = new HashMap<>();
        List<TestDTO> testDTOs = new ArrayList<>();
        TestDTO lists = testService.findTest(1L);
        //List<Test> insertedData = testService.batchInsert(testDTOs);
        //log.debug("data:{} ",JSONArray.toJSONString(insertedData));
        //retData.put("retData",insertedData);

        return retData;
    }

    @PostMapping(value = "/openJob")
    public Map openJob() throws SchedulerException {
        Map<String,Object> retData = new HashMap<>();
        changeTheJob("0/2 * * * * ?");
        return retData;
    }

    @PostMapping(value = "/changeJob")
    public Map changeJob() throws SchedulerException {
        changeTheJob("0/5 * * * * ?");
        return new HashMap<>();
    }

    private void changeTheJob(String corn) throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class).withIdentity("myJob1","group1").build();
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("myTrigger1","group1").startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule(corn)).build();

        //需要将jobDetail和trigger传进去，并将jobDetail和trigger绑定在一起。
        JobKey jobKey = new JobKey("myJob1","group1");
        scheduler.deleteJob(jobKey);
        scheduler.scheduleJob(jobDetail,trigger);
    }
}
