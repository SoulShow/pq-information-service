package com.pq.information;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableHystrix
@MapperScan("com.pq.information.mapper")
@EnableEurekaClient
@SpringBootApplication
public class InformationApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(InformationApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(InformationApplication.class);
    }
}
