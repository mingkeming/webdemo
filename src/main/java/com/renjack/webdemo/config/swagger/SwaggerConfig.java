package com.renjack.webdemo.config.swagger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ClassName SwaggerBootstrap
 * @Description Swagger-Bootstarp-ui Config
 **/
@Configuration
@EnableSwagger2
//@EnableSwaggerBootstrapUI
public class SwaggerConfig {

    @Value("${swagger.show:true}")
    private boolean swaggerShow;

    @Bean
    public Docket createApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(swaggerShow)
                .apiInfo(apiInfo())
                .groupName("API管理")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.renjack.webdemo.ctrl"))
                //.paths(PathSelectors.any())
                .build();
    }

    @Bean
    public ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("平台管理API")
                .description("管理API")
                .termsOfServiceUrl("http://www.abc.cn/")
                .version("1.0.0")
                .build();
    }

}
