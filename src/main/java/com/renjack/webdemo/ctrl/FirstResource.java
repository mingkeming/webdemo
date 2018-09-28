package com.renjack.webdemo.ctrl;

import com.renjack.webdemo.service.FirstService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/api")
@RestController
public class FirstResource {

    private static final Logger log = LoggerFactory.getLogger(FirstResource.class);

    @Autowired
    private FirstService firstService;

    @RequestMapping(value = "/task"  , method = RequestMethod.POST)
    public Map changeJobSwitch( @RequestParam("taskId") String taskId) {
        System.out.println(2);
        System.out.println(3);
        Map<String,String> retData = new HashMap<String,String>();
        retData.put("id","1");
        firstService.sendEmail(taskId);
        return retData;
    }
}
