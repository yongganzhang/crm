package com.shsxt.crm.test;

/***
 * 规范
 *  整个具体处理角色的行为
 */
public  abstract class  Handler {

    Handler handler;


    // 处理的行为
    public  abstract boolean  HandlerRequest ( float discout) ;


    // 处理角色设置
    protected   void  setNextHandler( Handler handler) {
        this.handler = handler;
    }

}
