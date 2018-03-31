package com.shsxt.crm.core.framework.annotation.factory;

import com.shsxt.crm.core.framework.annotation.handler.PermissionHandlerChain;
import com.shsxt.crm.core.framework.annotation.handler.PermissionLoginHandler;
import com.shsxt.crm.core.framework.annotation.handler.PermissionNoneHandler;
import com.shsxt.crm.core.framework.annotation.handler.PermissionRoleHandler;

/**
 * 简单工厂模式
 */
public class PermissionHandlerBeanFactory {

    public  static PermissionHandlerChain createPermissionNoneHandler (){
        return  new PermissionNoneHandler();
    }

    public  static PermissionHandlerChain createPermissionLoginHandler (){
        return  new PermissionLoginHandler();
    }

    public  static PermissionHandlerChain createPermissionRoleHandler (){
        return  new PermissionRoleHandler();
    }

}
