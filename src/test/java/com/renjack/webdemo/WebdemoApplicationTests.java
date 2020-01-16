package com.renjack.webdemo;

import com.renjack.webdemo.config.redis.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebdemoApplicationTests {

	@Autowired
	RedisService redisService;

	@Test
	public void contextLoads() {
		System.out.println("-------------------------------------------------------------------------------------------------------------------");
		String a = redisService.get("applet_access_token1");
		redisService.set("applet_access_token1","1233333",1, TimeUnit.MINUTES);
		String a1 = redisService.get("applet_access_token1");
		System.out.println(a);
		System.out.println("-------------------------------------------------------------------------------------------------------------------");
	}
}
