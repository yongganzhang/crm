package com.shsxt.crm.biz.dao;

import com.shsxt.crm.biz.model.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SystemUserRoleDao {

    public String queryUserRoleNameByUid( @Param("uid") Integer uid);


   List<Role> queryAllRolesByParams(@Param("roleName") String roleName);

}
