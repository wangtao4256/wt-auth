package com.wt.authcore.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wt.authcore.entity.SysUserDO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SysUserDoMapper extends BaseMapper<SysUserDO> {
    @Select("select * from sys_user where name=#{userName}")
    SysUserDO queryUserByName(@Param("userName") String uname);

    @Delete("delete from sys_user")
    SysUserDO deleteAll();
}
