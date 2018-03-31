package com.shsxt.crm.core.framework.annotation.handler;

import com.shsxt.crm.core.common.util.VerificationLoginUtil;
import com.shsxt.crm.core.framework.annotation.CheckType;
import com.shsxt.crm.core.framework.annotation.factory.PermissionHandlerBeanFactory;

import javax.servlet.http.HttpServletRequest;

/**
 *  登录校验
 */
public class PermissionLoginHandler extends PermissionHandlerChain{
    @Override
    public boolean permissionCherckHandler(HttpServletRequest request,CheckType type, String[] optValue) {
        if (type == CheckType.LOGIN) {
             return  VerificationLoginUtil.isUserLogin(request);// 登录验证
        }else {
            // 设置下一个
            setSuccessor(PermissionHandlerBeanFactory.createPermissionRoleHandler());
            // 下一级处理
            return  successor.permissionCherckHandler( request, type ,optValue);
        }
    }
}
