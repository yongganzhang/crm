package com.shsxt.crm.biz.dao;

import com.shsxt.crm.biz.model.SysModule;
import com.shsxt.crm.core.common.util.Result;

import java.util.List;

public interface SysmoduleDao {
    /**
     * 查询系统菜单
     * @return
     */
    List<SysModule> querySystemMenu();

}
