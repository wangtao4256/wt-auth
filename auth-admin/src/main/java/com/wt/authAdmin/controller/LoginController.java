package com.wt.authAdmin.controller;

import com.wt.authAdmin.dao.SysUserDOMapper;
import com.wt.authAdmin.entity.SysUserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录接口
 *
 * @author tao.wang
 */
@RestController
public class LoginController {
    @Autowired
    private SysUserDOMapper sysUserDOMapper;

    @RequestMapping("/test")
    public String test() throws InterruptedException {
        SysUserDO sysUserDO = sysUserDOMapper.queryUserByName("ssss");
        System.out.println(sysUserDO.getName());
        return "test";
    }
}
