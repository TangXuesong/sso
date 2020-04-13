package com.txs.resume.resumeuser;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@EnableEurekaClient
@EnableRedisHttpSession(maxInactiveIntervalInSeconds=1800)
@MapperScan("com.txs.resume.resumeuser.mapper")
public class ResumeUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResumeUserApplication.class, args);
    }

}
