package com.shsxt.crm.biz.service;

import com.shsxt.crm.biz.model.Customer;

import java.util.List;

public interface ICustomerService {

    /**
     * 查询All客户
     * @return
     */
    public List<Customer> queryAllCustomers ();
}
