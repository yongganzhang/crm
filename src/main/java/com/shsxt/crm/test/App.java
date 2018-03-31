package com.shsxt.crm.test;

public class App {

    public static void main(String[] args) {

        AHandler handler = new AHandler();
        boolean b = handler.HandlerRequest(0.5F);
        System.out.println(b);


    }
}
