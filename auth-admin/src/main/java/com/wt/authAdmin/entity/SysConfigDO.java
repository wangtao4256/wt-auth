package com.wt.authadmin.entity;

import lombok.Data;
/**
 * @author tao.wang
 */
@Data
public class SysConfigDO extends BaseModel {

    private String value;

    private String label;

    private String type;

    private String description;

    private Long sort;

    private String remarks;

    private Integer delFlag;

}