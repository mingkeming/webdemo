package com.renjack.webdemo.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class FirstService {

    public void sendEmail(String taskId) {
        System.out.println(taskId);
    }

}
