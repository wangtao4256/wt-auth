package com.wt.authadmin.entity;

import lombok.Data;

import java.util.List;

/**
 * @author tao.wang
 */
@Data
public class SysDeptDO extends BaseModel {

    private String name;

    private Long parentId;

    private Integer orderNum;

    private Integer delFlag;
    /**
     * 非数据库字段
     */
    private List<SysDeptDO> children;
    /**
     * 非数据库字段
     */
    private String parentName;
    /**
     * 非数据库字段
     */
    private Integer level;

}