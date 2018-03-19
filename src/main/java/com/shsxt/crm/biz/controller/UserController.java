package com.shsxt.crm.biz.controller;

import com.shsxt.crm.biz.model.User;
import com.shsxt.crm.biz.service.IUserService;
import com.shsxt.crm.core.common.util.Result;
import com.shsxt.crm.core.framework.context.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private IUserService userService;


    @RequestMapping("/userLogin")
//    @ResponseBody
    public Result userLogin (String userName,String userPwd) {
        return userService.userLogin(userName,userPwd);
    }

}
