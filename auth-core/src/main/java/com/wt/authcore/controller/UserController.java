package com.wt.authcore.controller;


import com.wt.authcore.entity.SysUserDO;
import com.wt.authcore.page.PageRequest;
import com.wt.authcore.page.PageResult;
import com.wt.authcore.req.BaseReq;
import com.wt.authcore.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 登录接口
 *
 * @author tao.wang
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private SysUserService sysUserService;

    @PostMapping("/findPage")
    public PageResult findUserByPage(@RequestBody BaseReq baseReq) {
        PageRequest request = new PageRequest();
        request.setPageSize(baseReq.getPageSize());
        request.setPageNum(baseReq.getPageNum());
        return sysUserService.findPage(request);
    }
}
