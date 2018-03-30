package com.shsxt.crm.biz.service;

import com.shsxt.crm.biz.model.User;

import java.util.Map;

public interface ISystemUserService {

    public Map<String,Object> queryUsersByParams (User user);
}
;