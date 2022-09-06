package com.wt.authcore.page;

import com.google.common.collect.Maps;
import lombok.Data;

import java.util.Map;

@Data
public class PageRequest {
    /**
     * 当前页码
     */
    private int pageNum = 1;
    /**
     * 每页数量
     */
    private int pageSize = 10;

    private Map<String, Object> param = Maps.newHashMap();
}
