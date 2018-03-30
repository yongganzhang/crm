package com.shsxt.crm.biz.controller.system;

import com.shsxt.crm.biz.model.Module;
import com.shsxt.crm.biz.service.IModuleService;
import com.shsxt.crm.core.framework.context.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/module")
public class ModuleController  extends BaseController{

    @Autowired
    private IModuleService moduleService;

    /**
     * 系统模块管理页面
     * @return
     */
    @RequestMapping("/index")
    public String index () {
        return "module";
    }


    @RequestMapping("/queryModulesByParams")
    @ResponseBody
    public Map<String, Object> queryModulesByParams(Module module) {
        return  moduleService.queryModulesByParams(module);
    }


}
