package com.wt.authadmin.controller;


import com.wt.authadmin.constant.SysConstants;
import com.wt.authadmin.entity.SysUserDO;
import com.wt.authadmin.http.HttpResult;
import com.wt.authadmin.page.PageRequest;
import com.wt.authadmin.service.SysUserService;
import com.wt.authadmin.util.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @PostMapping(value = "/save")
    public HttpResult save(@RequestBody SysUserDO saveUserReq) {
        SysUserDO user = sysUserService.findById(saveUserReq.getId());
        if (user != null) {
            if (SysConstants.ADMIN.getName().equalsIgnoreCase(user.getName())) {
                return HttpResult.error("超级管理员不允许修改!");
            }
        }
        if (saveUserReq.getPassword() != null) {
            String salt = PasswordUtils.getSalt();
            if (user == null) {
                // 新增用户
                if (sysUserService.findByName(saveUserReq.getName()) != null) {
                    return HttpResult.error("用户名已存在!");
                }
                String password = PasswordUtils.encode(saveUserReq.getPassword(), salt);
                saveUserReq.setSalt(salt);
                saveUserReq.setPassword(password);
            } else {
                // 修改用户, 且修改了密码
                if (!saveUserReq.getPassword().equals(user.getPassword())) {
                    String password = PasswordUtils.encode(saveUserReq.getPassword(), salt);
                    saveUserReq.setSalt(salt);
                    saveUserReq.setPassword(password);
                }
            }
        }
        return HttpResult.ok(sysUserService.save(saveUserReq));
    }

    @PostMapping(value = "/delete")
    public HttpResult delete(@RequestBody List<SysUserDO> records) {
        for (SysUserDO record : records) {
            SysUserDO sysUser = sysUserService.findById(record.getId());
            if (sysUser != null && SysConstants.ADMIN.getName().equalsIgnoreCase(sysUser.getName())) {
                return HttpResult.error("超级管理员不允许删除!");
            }
        }
        return HttpResult.ok(sysUserService.delete(records));
    }

    @GetMapping(value = "/findByName")
    public HttpResult findByName(@RequestParam String name) {
        return HttpResult.ok(sysUserService.findByName(name));
    }

    @GetMapping(value = "/findPermissions")
    public HttpResult findPermissions(@RequestParam String name) {
        return HttpResult.ok(sysUserService.findPermissions(name));
    }

    @PostMapping(value = "/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest) {
        return HttpResult.ok(sysUserService.findPage(pageRequest));
    }
}
