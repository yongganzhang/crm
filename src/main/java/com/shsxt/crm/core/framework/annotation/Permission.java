package com.shsxt.crm.core.framework.annotation;

import java.lang.annotation.*;

/**
 * 权限拦截 注解
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Permission {

    //  权限检查的类型
    CheckType checkType() default CheckType.NONE;

}
