package com.renjack.webdemo;

import com.renjack.webdemo.service.FirstService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebdemoApplicationTests {

	@Autowired
	private FirstService firstService;
	@Test
	public void contextLoads() {
		firstService.sendEmail("1");
	}

}
