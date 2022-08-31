package com.wt.wtauth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wt.wtauth.mapper")
public class WtAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(WtAuthApplication.class, args);
    }

}
