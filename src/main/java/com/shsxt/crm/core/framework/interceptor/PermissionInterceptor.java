package com.shsxt.crm.core.framework.interceptor;

import com.shsxt.crm.core.common.util.VerificationLoginUtil;
import com.shsxt.crm.core.framework.annotation.CheckType;
import com.shsxt.crm.core.framework.annotation.Permission;
import com.shsxt.crm.core.framework.annotation.factory.PermissionHandlerBeanFactory;
import com.shsxt.crm.core.framework.annotation.handler.PermissionHandlerChain;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 *
 * 权限拦截器
 *
 */
public class PermissionInterceptor extends HandlerInterceptorAdapter {

    /***
     *  在请求方法之前执行拦截
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 判断是否是拦截的方法
        if (handler instanceof HandlerMethod) {
            HandlerMethod hm =   (HandlerMethod)  handler;
            // 获取到被拦截的方法
            Method method = hm.getMethod();
            if (! method.isAnnotationPresent(Permission.class))
                return true;
            //获取注解对象
            Permission an = method.getAnnotation(Permission.class);
            CheckType type = an.checkType(); //
            String[] optValue = an.checkTypeValue(); // opt
            //进入处理链
            PermissionHandlerChain permissionNoneHandler = PermissionHandlerBeanFactory.createPermissionNoneHandler();
            boolean b = permissionNoneHandler.permissionCherckHandler(request, type, optValue);
            return  b;
        }
        return  true;
    }
}
