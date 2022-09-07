package com.wt.authadmin.entity;

import lombok.Data;

/**
 * @author tao.wang
 */
@Data
public class SysUserRoleDO extends BaseModel {
    private Long userId;

    private Long roleId;
}
