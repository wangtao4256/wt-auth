package com.wt.authAdmin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@MapperScan("com.wt.authAdmin.dao")
@EnableConfigurationProperties
public class AuthAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthAdminApplication.class, args);
    }

}
