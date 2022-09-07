package com.wt.authadmin.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 常量管理
 *
 * @author Louis
 * @date Jan 13, 2019
 */
@AllArgsConstructor
@Getter
public enum SysConstants {

    /**
     * 系统管理员用户名
     */
    ADMIN("admin");
    private String name;
}
