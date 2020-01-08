package com.renjack.webdemo.ctrl;

import com.alibaba.fastjson.JSONArray;
import com.renjack.webdemo.entity.Test;
import com.renjack.webdemo.entity.TestDTO;
import com.renjack.webdemo.service.FirstService;
import com.renjack.webdemo.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api")
@RestController // 该注解和Controller的主要差别是该注解为Controller+ ResponseBody
public class FirstResource {

    private static final Logger log = LoggerFactory.getLogger(FirstResource.class);


        @Autowired
        private TestService testService ;

        @PostMapping(value = "/insertBatch")
        public Map changeJobSwitch(@RequestBody List<TestDTO> testDTOs) {
            //参数传递数组
            Map<String,Object> retData = new HashMap<>();
            List<Test> lists = testService.findByCondition("111",12);
            List<Test> insertedData = testService.batchInsert(testDTOs);
            log.debug("data:{} ",JSONArray.toJSONString(insertedData));
            retData.put("retData",insertedData);
            return retData;
    }
}
