package com.wt.authcore;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@MapperScan("com.wt.authcore.dao")
@EnableConfigurationProperties
public class AuthCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthCoreApplication.class, args);
    }

}
