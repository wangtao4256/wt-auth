package com.wt.authcore.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author wangtao
 */
@TableName("sys_user")
@Data
public class SysUserDO {
    private Long id;
    private String name;
}