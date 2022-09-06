package com.wt.authcore.service;

import com.wt.authcore.entity.SysUserDO;
import com.wt.authcore.page.PageRequest;
import com.wt.authcore.page.PageResult;

import java.util.List;

/**
 * 通用CRUD接口
 *
 * @param <T>
 * @author tao.wang
 */
public interface SysUserService {
    int save(SysUserDO record);

    int delete(SysUserDO record);

    int delete(List<SysUserDO> records);

    SysUserDO findById(Long id);

    PageResult findPage(PageRequest pageRequest);
}
