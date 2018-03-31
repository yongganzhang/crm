package com.shsxt.crm.core.framework.annotation.handler;

import com.shsxt.crm.core.framework.annotation.CheckType;
import com.shsxt.crm.core.framework.annotation.factory.PermissionHandlerBeanFactory;

import javax.servlet.http.HttpServletRequest;

public class PermissionNoneHandler extends PermissionHandlerChain {


    @Override
    public boolean permissionCherckHandler(HttpServletRequest request,CheckType type , String[] optValue) {

        if (type == CheckType.NONE) {
            return true;
        }else {
                // 设置下一个
            setSuccessor(PermissionHandlerBeanFactory.createPermissionLoginHandler());
            // 下一级处理
            return  successor.permissionCherckHandler( request, type,optValue);
        }
    }


}
