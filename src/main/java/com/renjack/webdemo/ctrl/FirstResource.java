package com.renjack.webdemo.ctrl;

import com.renjack.webdemo.config.redis.RedisService;
import com.renjack.webdemo.entity.TestDTO;
import com.renjack.webdemo.service.TestService;
import lombok.extern.slf4j.Slf4j;
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

    @PostMapping(value = "/insertBatch")
    public Map changeJobSwitch() {
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
}
