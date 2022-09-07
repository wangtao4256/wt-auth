package com.wt.authadmin.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wt.authadmin.dao.SysUserDoMapper;
import com.wt.authadmin.entity.SysUserDO;
import com.wt.authadmin.entity.SysUserRoleDO;
import com.wt.authadmin.page.PageRequest;
import com.wt.authadmin.page.PageResult;
import com.wt.authadmin.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserDoMapper sysUserDoMapper;

    @Override
    public int save(SysUserDO record) {
        return sysUserDoMapper.insert(record);
    }

    @Override
    public int delete(List<SysUserDO> records) {
        List<Long> userIds = records.stream().map(SysUserDO::getId).collect(Collectors.toList());
        return sysUserDoMapper.deleteBatchIds(userIds);
    }

    @Override
    public SysUserDO findById(Long id) {
        return sysUserDoMapper.selectById(id);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        Page page = new Page(pageNum, pageSize);
        QueryWrapper<SysUserDO> queryWrapper = new QueryWrapper<SysUserDO>();
        Map<String, Object> param = pageRequest.getParam();
        Set<Map.Entry<String, Object>> entries = param.entrySet();
        for (Map.Entry<String, Object> entry : entries) {
            queryWrapper.eq(entry.getKey(), entry.getValue());
        }
        Page result = sysUserDoMapper.selectPage(page, queryWrapper);
        List records = result.getRecords();
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageNum);
        pageResult.setPageSize(pageSize);
        pageResult.setTotalSize(result.getTotal());
        pageResult.setTotalPage(result.getPages());
        pageResult.setContent(records);
        return pageResult;
    }

    @Override
    public SysUserDO findByName(String name) {
        QueryWrapper<SysUserDO> queryWrapper = new QueryWrapper();
        queryWrapper.eq(SysUserDO.NAME, name);
        return sysUserDoMapper.selectOne(queryWrapper);
    }

    @Override
    public Set<String> findPermissions(String userName) {
        return null;
    }

    @Override
    public List<SysUserRoleDO> findUserRoles(Long userId) {
        return null;
    }

    @Override
    public File createUserExcelFile(PageRequest pageRequest) {
        return null;
    }
}
