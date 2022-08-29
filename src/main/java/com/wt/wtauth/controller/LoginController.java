package com.wt.wtauth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录接口
 *
 * @author tao.wang
 */
@RestController
public class LoginController {
    @RequestMapping("/test")
    public String test() throws InterruptedException {
        return "test";
    }
}
