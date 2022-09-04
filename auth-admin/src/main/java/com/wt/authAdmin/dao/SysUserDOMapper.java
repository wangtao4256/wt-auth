package com.wt.authAdmin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wt.authAdmin.entity.SysUserDO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface SysUserDOMapper extends BaseMapper<SysUserDO> {
    @Select("select * from sys_user where name=#{userName}")
    SysUserDO queryUserByName(@Param("userName") String uname);
}
