package com.wt.authcore.page;

import lombok.Data;

import java.util.List;

/**
 * @author tao.wang
 */
@Data
public class PageResult {
    private int pageNum;
    private int pageSize;
    private long totalSize;
    private long totalPage;
    private List<?> content;
}
