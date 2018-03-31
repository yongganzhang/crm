package com.shsxt.crm.biz.service;

import com.shsxt.crm.core.common.util.Result;

public interface ISysmoduleService {

    /**
     * 角色Id
     * @param rid
     * @return
     */
    public Result querySystemMenu (Integer rid);

}
