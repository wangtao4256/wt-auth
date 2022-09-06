package com.wt.authcore.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wt.authcore.dao.SysUserDoMapper;
import com.wt.authcore.entity.SysUserDO;
import com.wt.authcore.page.PageRequest;
import com.wt.authcore.page.PageResult;
import com.wt.authcore.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public int delete(SysUserDO record) {
        return sysUserDoMapper.deleteById(record);
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
}
