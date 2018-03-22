package com.shsxt.crm.biz.service.impl;

import com.shsxt.crm.biz.model.User;
import com.shsxt.crm.biz.service.IMainIndexService;
import com.shsxt.crm.biz.service.IUserPermissionService;
import com.shsxt.crm.core.common.util.VerificationLoginUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 主菜单服务
 */

@Service
public class MainIndexServiceImpl implements IMainIndexService {

    @Autowired
    private IUserPermissionService userPermissionService;

    @Autowired (required =  false)
    private HttpSession session;

    @Override
    public String MainIndexCheck(HttpServletRequest req) {
        //判断用户是否 登录
        if (!VerificationLoginUtil.isUserLogin(req))//未登录
            return "index";

        //登录 获取获取权限
        User user = VerificationLoginUtil.getUserInfoFromSession(req);

        // 权限操作值
        List<String> aclList = userPermissionService.queryUserAclByUid(user.getId());
        session.setAttribute("userPermission",aclList);
        return "main";
    }


}
