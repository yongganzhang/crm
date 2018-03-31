package com.shsxt.crm.test;

public class CHandler extends Handler {

    @Override
    public boolean HandlerRequest(float discout) {

        if (discout >= 0.85) { //        置业顾问A : 95折扣
            System.out.println("C： 卖了 :"+ discout);
            return true;
        }else {
            System.out.println("C: 不卖了  ");
            return  false;
        }
    }
}
