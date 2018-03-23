package com.shsxt.crm.biz.service;

import com.shsxt.crm.biz.model.User;
import com.shsxt.crm.core.common.util.Result;

public interface IUserService {

    public Result userLogin (String userName,String userPwd) ;

    /**
     * 用户修改密码
     * @param userName
     * @param oldPassword
     * @param newPassword
     * @param confirmPassword
     * @return
     */
    public Result userModifyPassword (String userName,String oldPassword,String  newPassword,String confirmPassword );


}
