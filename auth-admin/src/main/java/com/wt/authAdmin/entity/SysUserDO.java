package com.wt.authadmin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;

/**
 * @author wangtao
 */
@TableName("sys_user")
@Data
public class SysUserDO extends BaseModel {

    private String name;
    private String nickName;
    private String password;
    private String salt;
    private String email;
    private String mobile;
    private Integer status;
    private Long deptId;
    private Integer delFlag;
    /**
     * 非数据库字段
     */
    private String deptName;
    /**
     * 非数据库字段
     */
    private String roleName;
    /**
     * 非数据库字段
     */
    private List<SysUserRoleDO> userRoles = Lists.newArrayList();

    public static final String NAME = "name";
}