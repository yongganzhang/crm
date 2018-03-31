package com.shsxt.crm.test;

/**
 *   置业顾问A : 95折扣
 */
public class AHandler extends Handler {

    @Override
    public boolean HandlerRequest(float discout) {

        if (discout >= 0.95) { //        置业顾问A : 95折扣
            System.out.println("A:  卖了 :"+ discout);
            return  true;
        }else {
            //B处理
//            B 的对象
            BHandler bHandler = new BHandler();
            setNextHandler(bHandler); // 设置下一个处理对象
           return   handler.HandlerRequest(discout);
        }

    }
}
