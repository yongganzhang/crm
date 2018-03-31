package com.shsxt.crm.biz.controller.system;

import com.shsxt.crm.biz.service.ISysmoduleService;
import com.shsxt.crm.core.common.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 系统菜单
 */
@Controller
@RequestMapping("/sysmodule")
public class SysmoduleController {

    @Autowired
    private ISysmoduleService sysmoduleService;


    @RequestMapping("/querySystemMenu")
    @ResponseBody
    public Result querySystemMenu (Integer rid){
        return sysmoduleService.querySystemMenu(rid);
    }
}
