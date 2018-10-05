package com.renjack.webdemo.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class FirstService {

    private static final Logger log = LoggerFactory.getLogger(FirstService.class);

    public void sendEmail(String taskId) {
        System.out.println(taskId);
    }

}
