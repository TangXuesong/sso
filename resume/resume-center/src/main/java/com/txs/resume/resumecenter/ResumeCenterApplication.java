package com.txs.resume.resumecenter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.txs.resume.resumecenter.mapper")
public class ResumeCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResumeCenterApplication.class, args);
    }

    //实例化一个RestTemplate
    @Bean
    @LoadBalanced   //使用该注解能自动将服务的地址替换成真实的ip地址+端口
    public RestTemplate initRestTemplate(){
        return new RestTemplate();
    }

}
