package com.shsxt.crm.biz.service;

import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

public interface ISystemUserRoleService {

    public  String queryUserRoleNameByUid (Integer uid);


    Map<String,Object> queryAllRolesByParams (String roleName,Integer page,  Integer rows);


}
