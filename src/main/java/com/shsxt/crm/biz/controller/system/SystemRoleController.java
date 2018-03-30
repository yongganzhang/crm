package com.shsxt.crm.biz.controller.system;

import com.shsxt.crm.biz.service.ISystemUserRoleService;
import com.shsxt.crm.core.framework.context.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/sysrole")
public class SystemRoleController extends BaseController {

    @Autowired
    private ISystemUserRoleService systemUserRoleService;

    /**
     * 角色 页面
     * @return
     */
    @RequestMapping("/index")
    public String index () {
        return "role";
    }


    /**
     * 查询用户角色
     * @param roleName
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/queryAllRolesByParams")
    @ResponseBody
    public Map<String,Object> queryAllRolesByParams (String roleName,
                                                     @RequestParam(defaultValue = "1") Integer page,
                                                     @RequestParam(defaultValue = "10")   Integer rows) {
        return systemUserRoleService.queryAllRolesByParams(roleName,page,rows);
    }


}
