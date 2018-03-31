package com.shsxt.crm.core.framework.annotation.handler;

import com.shsxt.crm.core.framework.annotation.CheckType;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 角色 校验
 *
 */
public class PermissionRoleHandler extends PermissionHandlerChain{

    @Override
    public boolean permissionCherckHandler(HttpServletRequest request,CheckType type, String[] optValue) {

        if (type == CheckType.ROLE) {
            //获取到用户ACL
            Object userPermission = request.getSession().getAttribute("userPermission");
            List<String> aclList =  ( List<String>) userPermission;
            // opt
            for (String opt: optValue ) {
                boolean c = aclList.contains(opt);
                if (!c)
                    return false;
            }
            return true;
        }else {
            return  false;
        }
    }
}