package com.renjack.webdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//@MapperScan("com.renjack.webdemo.dao") 添加扫描的dao层
@EnableSwagger2 //开启swagger
public class WebdemoApplication {

	public static void main(String[] args){
        SpringApplication app = new SpringApplication(WebdemoApplication.class);
        Environment env = app.run(args).getEnvironment();
        System.out.println(env.getProperty("server.port"));
        System.out.println("this is ok");
	}
}
