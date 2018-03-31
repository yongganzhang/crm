package com.shsxt.crm.test;

/**
 *  销售主管B:  90折扣
 */
public class BHandler  extends  Handler{



    @Override
    public boolean HandlerRequest(float discout) {


        if (discout >= 0.9) { //        置业顾问A : 95折扣
            System.out.println("B： 卖了 :"+ discout);
            return true;
        }else {
            //B处理
//            B 的对象
            CHandler cHandler = new CHandler();
            setNextHandler(cHandler); // 设置下一个处理对象
             return  handler.HandlerRequest(discout);
        }

    }



}
