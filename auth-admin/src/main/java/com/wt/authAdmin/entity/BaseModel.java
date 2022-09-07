package com.wt.authadmin.entity;

import lombok.Data;
/**
 * @author tao.wang
 */
@Data
public class BaseModel {

    private Long id;

    private String createBy;

    private Long createTime;

    private String lastUpdateBy;

    private Long lastUpdateTime;

}