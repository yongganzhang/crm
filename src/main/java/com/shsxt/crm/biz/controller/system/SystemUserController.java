package com.shsxt.crm.biz.controller.system;

import com.shsxt.crm.biz.model.User;
import com.shsxt.crm.biz.service.ISystemUserService;
import com.shsxt.crm.core.framework.context.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/sysuser")
public class SystemUserController extends BaseController {

    @Autowired
    private ISystemUserService systemUserService;

    /**
     *跳转用户信息管理页面
     * @return
     */
    @RequestMapping("/index")
    public String index () {
        return "user";
    }


    @RequestMapping("/queryUsersByParams")
    @ResponseBody
    public Map<String,Object> queryUsersByParams (User user) {
        return systemUserService.queryUsersByParams(user);
    }

}
