package com.shsxt.crm.biz.service;


import com.shsxt.crm.biz.model.CustomerServe;
import com.shsxt.crm.core.common.util.Result;

import java.util.Map;

public interface ICustomerServeService {

    public Result insertServerInfo (CustomerServe customerServe);

    public Result updateServerInfo (CustomerServe customerServe);

    public Map<String ,Object> queryCustomerServesByParams (Integer state,Integer page, Integer rows);


}
