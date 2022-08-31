package com.wt.wtauth.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({DruidDataSourceProperties.class})
public class DruidConfig {
}
