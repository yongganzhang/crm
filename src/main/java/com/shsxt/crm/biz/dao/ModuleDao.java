package com.shsxt.crm.biz.dao;

import com.shsxt.crm.biz.model.Module;
import com.shsxt.crm.core.framework.dao.BaseDao;

import java.util.List;

public interface ModuleDao extends BaseDao<Integer,Module> {

    List<Module> queryModulesByParams (Module module);

}