package com.shsxt.crm.biz.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shsxt.crm.biz.dao.ModuleDao;
import com.shsxt.crm.biz.model.Module;
import com.shsxt.crm.biz.service.IModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ModuleServiceImpl implements IModuleService {

    @Autowired
    private ModuleDao moduleDao;


    @Override
    public Map<String, Object> queryModulesByParams(Module module) {

        List<Module> modules = moduleDao.queryModulesByParams(module);
        // 分页
        PageHelper.startPage(module.getPage(),module.getRows());

        PageInfo<Module> pageInfo = new PageInfo<>(modules);

        //组装返回值对象
        Map<String, Object> map = new HashMap<>();
        map.put("total", pageInfo.getTotal());
        map.put("rows", pageInfo.getList());
        return map;
    }
}
