package com.shsxt.crm.biz.service.impl;

import com.github.pagehelper.PageInfo;
import com.shsxt.crm.biz.dao.SystemUserRoleDao;
import com.shsxt.crm.biz.model.Role;
import com.shsxt.crm.biz.model.SaleChance;
import com.shsxt.crm.biz.service.ISystemUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户角色
 */
@Service
public class SystemUserRoleServiceImpl implements ISystemUserRoleService {


    @Autowired
    private SystemUserRoleDao systemUserRoleDao;

    @Override
    public String queryUserRoleNameByUid(Integer uid) {
        return systemUserRoleDao.queryUserRoleNameByUid(uid);
    }


    @Override
    public Map<String, Object> queryAllRolesByParams(String roleName, Integer page, Integer rows) {

        //查询角色数据
        List<Role> roleList = systemUserRoleDao.queryAllRolesByParams(roleName);
        // 分页对象
        PageInfo<Role> pageInfo = new PageInfo<>(roleList);
        Map<String, Object> map = new HashMap<>();
        map.put("total", pageInfo.getTotal());
        map.put("rows", pageInfo.getList());
        return map;
    }
}
