package com.renjack.webdemo.ctrl;

import com.renjack.webdemo.entity.Test;
import com.renjack.webdemo.entity.TestDTO;
import com.renjack.webdemo.service.FirstService;
import com.renjack.webdemo.service.TestService;
import org.assertj.core.util.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api")
@RestController
public class FirstResource {

    private static final Logger log = LoggerFactory.getLogger(FirstResource.class);

    @Autowired
    private FirstService firstService;

    @Autowired 
    TestService testService ;

    @RequestMapping(value = "/task"  , method = RequestMethod.POST)
    public Map changeJobSwitch( @RequestParam("taskId") String taskId) {
        Map<String,Object> retData = new HashMap<String,Object>();
        TestDTO testDTO = new TestDTO();
        testDTO.setId(1l);
        testDTO.setName("中国");
        testDTO.setStatus(2);
        List<TestDTO> a = Lists.newArrayList();
        a.add(testDTO);
        a.add(testDTO);
        a.add(testDTO);
        a.add(testDTO);
        testService.findByCondition("111",12);
        List<Test> b = testService.batchInsertT(a);
        log.debug("data: ",b);
        retData.put("id",b);
        firstService.sendEmail(taskId);
        return retData;
    }
}
