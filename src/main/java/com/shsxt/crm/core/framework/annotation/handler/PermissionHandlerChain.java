package com.shsxt.crm.core.framework.annotation.handler;

import com.shsxt.crm.core.framework.annotation.CheckType;

import javax.servlet.http.HttpServletRequest;

/**
 * 权限校验处理链
 */
public abstract class PermissionHandlerChain {

    // 对象引用
    protected  PermissionHandlerChain  successor;

    /**
     * 权限校验
     * @param request
     * @return
     */
    public abstract   boolean  permissionCherckHandler (HttpServletRequest request,CheckType type, String[] optValue) ;


    /**
     * 设置处理对象
     * @param successor
     */
    protected void setSuccessor(PermissionHandlerChain successor){
        this.successor = successor;
    }

}
