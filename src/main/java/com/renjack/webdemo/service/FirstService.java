package com.renjack.webdemo.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Michael on 2/28/2018.
 *
 * @author Michael
 */
@Service
public class FirstService {

    private static final Logger log = LoggerFactory.getLogger(FirstService.class);

    public void sendEmail(String taskId) {
        System.out.println(taskId);
    }

}
