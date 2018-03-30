package com.shsxt.crm.biz.service;

import com.shsxt.crm.biz.model.Module;

import java.util.Map;

public interface IModuleService {

    /**
     * 查询系统模块
     * @return
     */
    public Map<String, Object> queryModulesByParams(Module module);

}
