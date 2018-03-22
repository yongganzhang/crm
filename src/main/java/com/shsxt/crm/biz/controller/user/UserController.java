package com.shsxt.crm.biz.controller.user;

import com.shsxt.crm.biz.service.IUserService;
import com.shsxt.crm.core.common.util.Result;
import com.shsxt.crm.core.framework.context.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private IUserService userService;


    @GetMapping("/userLogin")
    @ResponseBody
    public Result userLogin (String userName,String userPwd) {
        return userService.userLogin(userName,userPwd);
    }

}
