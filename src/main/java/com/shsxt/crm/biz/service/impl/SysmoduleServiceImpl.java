package com.shsxt.crm.biz.service.impl;

import com.shsxt.crm.biz.dao.SysmoduleDao;
import com.shsxt.crm.biz.model.SysModule;
import com.shsxt.crm.biz.service.ISysmoduleService;
import com.shsxt.crm.core.common.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysmoduleServiceImpl implements ISysmoduleService {

    @Autowired
    private SysmoduleDao sysmoduleDao;


    @Override
    public Result querySystemMenu(Integer rid) {
        List<SysModule> sysModules = sysmoduleDao.querySystemMenu();
        return Result.success("查询成功",sysModules);
    }
}
