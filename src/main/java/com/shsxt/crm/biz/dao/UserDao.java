package com.shsxt.crm.biz.dao;

import com.shsxt.crm.biz.model.User;
import com.shsxt.crm.core.framework.context.BaseController;
import com.shsxt.crm.core.framework.dao.BaseDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {

    User queryUserByUserName(@Param("userName") String  userName);

    int updateUserPwdByUserName (User user);

    public List<User> queryAllCustomerManager ();

}
