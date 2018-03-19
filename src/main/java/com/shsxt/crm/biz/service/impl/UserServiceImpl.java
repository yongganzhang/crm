package com.shsxt.crm.biz.service.impl;

import com.shsxt.crm.biz.dao.UserDao;
import com.shsxt.crm.biz.model.User;
import com.shsxt.crm.biz.service.IUserService;
import com.shsxt.crm.core.common.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Service
public class UserServiceImpl  implements IUserService{//提示  alt + enter

    @Autowired
    private UserDao userDao;

    @Autowired (required = false)
    private HttpSession session;

    @Autowired (required = false)
    private HttpServletResponse resp;


    @Override
    public Result userLogin(String userName, String userPwd) {

        if (StringUtil.isEmpty(userName) || StringUtil.isEmpty(userPwd)) {
            return Result.fail("用户登录失败，请输入账户或密码。");
        }

        User user = userDao.queryUserByUserName(userName);
        if (user == null || !user.getUserPwd().equals(Md5Util.encode(userPwd)) )
            return Result.fail("用户登录失败，请核实账户或密码。");

        //登录成功
        VerificationLoginUtil.userLoginTools(session,resp,user);

        return Result.success("登录成功");
    }
}
