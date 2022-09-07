package com.wt.authadmin.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author tao.wang
 */
@ConfigurationProperties(prefix = "spring.datasource.druid")
@Data
public class DruidDataSourceProperties {
    private String driverClassName;
    private String url;
    private String username;
    private String password;
    //连接池初始化大小
    private int initialSize;
    //最小空闲数
    private int minIdle;
    //最大活跃线程数
    private int maxActive = 100;
    private long maxWait;
    private long timeBetweenEvictionRunsMillis;
    private long minEvictableIdleTimeMillis;
    private String validationQuery;
    private boolean testWhileIdle;
    private boolean testOnBorrow;
    private boolean testOnReturn;
    private boolean poolPreparedStatements;
    private int maxPoolPreparedStatementPerConnectionSize;
    private String filters;

}
