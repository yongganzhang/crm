package com.shsxt.crm.biz.service.impl;

import com.shsxt.crm.biz.dao.UserDao;
import com.shsxt.crm.biz.model.User;
import com.shsxt.crm.biz.service.IUserService;
import com.shsxt.crm.core.common.util.*;
import com.shsxt.crm.core.framework.exception.GlobalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl  implements IUserService{//提示  alt + enter

    @Autowired
    private UserDao userDao;

    @Autowired (required = false)
    private HttpSession session;

    @Autowired (required = false)
    private HttpServletResponse resp;

    @Autowired (required = false)
    private HttpServletRequest req;


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

    @Override
    public Result userModifyPassword(String userName, String oldPassword, String newPassword, String confirmPassword) {
    //
        User user = VerificationLoginUtil.getUserInfoFromSession(req);

        if (StringUtil.isNotEmpty(newPassword) &&  !newPassword.equals(confirmPassword)) {
            return Result.fail("两次输出密码不相同");
        }
        if (!user.getUserName().equals(userName) ||! user.getUserPwd().equals(Md5Util.encode(oldPassword))) {
            return Result.fail("用户不存在或者密码不正确");
        }
        if (oldPassword.equals(newPassword)) {
            return Result.fail("新密码不能够原密码相同");
        }

        //修改密码
        User user1 = new User();
        user1.setUserName(userName);
        user1.setUserPwd(Md5Util.encode(newPassword));
        user1.setUpdateDate(new Date());
        int res = userDao.updateUserPwdByUserName(user1);

        if (res == 1)
            return   Result.success("修改成功");
        return   Result.fail("修改失败");
    }

    @Override
    public List<User> queryAllCustomerManager() {
        return userDao.queryAllCustomerManager();
    }
}
