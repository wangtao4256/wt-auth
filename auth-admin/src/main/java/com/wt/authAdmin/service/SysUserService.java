package com.wt.authadmin.service;


import com.wt.authadmin.entity.SysUserDO;
import com.wt.authadmin.entity.SysUserRoleDO;
import com.wt.authadmin.page.PageRequest;
import com.wt.authadmin.page.PageResult;

import java.io.File;
import java.util.List;
import java.util.Set;

/**
 * 通用CRUD接口
 *
 * @param <T>
 * @author tao.wang
 */
public interface SysUserService {
    int save(SysUserDO record);

    int delete(List<SysUserDO> records);

    SysUserDO findById(Long id);

    SysUserDO findByName(String id);


    PageResult findPage(PageRequest pageRequest);

    /**
     * 查找用户的菜单权限标识集合
     *
     * @param userName
     * @return
     */
    Set<String> findPermissions(String userName);

    /**
     * 查找用户的角色集合
     *
     * @param userName
     * @return
     */
    List<SysUserRoleDO> findUserRoles(Long userId);

    /**
     * 生成用户信息Excel文件
     *
     * @param pageRequest 要导出的分页查询参数
     * @return
     */
    File createUserExcelFile(PageRequest pageRequest);
}
