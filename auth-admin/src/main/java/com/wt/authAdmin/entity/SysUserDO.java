package com.wt.authAdmin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author wangtao
 */
@Data
@TableName("sys_user")
public class SysUserDO {
    private Long id;
    private String name;
}