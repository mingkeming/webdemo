package com.renjack.webdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class WebdemoApplication {

	public static void main(String[] args) {
		//SpringApplication.run(WebdemoApplication.class, args);
        SpringApplication app = new SpringApplication(WebdemoApplication.class);
        Environment env = app.run(args).getEnvironment();
        System.out.println(env.getProperty("server.port"));
        System.out.println("this is ok");
	}
}
