package com.shsxt.crm.biz.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shsxt.crm.biz.dao.SystemUserDao;
import com.shsxt.crm.biz.model.User;
import com.shsxt.crm.biz.service.ISystemUserRoleService;
import com.shsxt.crm.biz.service.ISystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 *  系统用户
 */
@Service
public class SystemUserServiceImpl implements ISystemUserService {

    @Autowired
    private SystemUserDao systemUserDao;

    @Autowired
    private ISystemUserRoleService systemUserRoleService;

    @Override
    public Map<String, Object> queryUsersByParams(User user) {
        //组装查询参数
        Map<String, Object >  params = new HashMap<>();
        params.put("userName",user.getUserName());
        params.put("trueName",user.getTrueName());
        params.put("phone",user.getPhone());
        params.put("email",user.getEmail());
        params.put("isValid",1);
        List<User> userList = systemUserDao.find(params);// 查询未删除用户

        //分页
        PageHelper.startPage(user.getPage(),user.getRows());
        PageInfo<User> pageInfo = new PageInfo<>(userList);

        //设置角色名称
        List<User> list = pageInfo.getList();
        for (User u:list ) {
            String roleName = systemUserRoleService.queryUserRoleNameByUid(u.getId());
            u.setRoleName(roleName);
        }
        //设置返回对象
        Map<String, Object>  map = new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",list);
        return map;

    }
}
