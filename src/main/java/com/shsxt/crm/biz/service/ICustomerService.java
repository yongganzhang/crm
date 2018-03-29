package com.shsxt.crm.biz.service;

import com.shsxt.crm.biz.model.Customer;
import com.shsxt.crm.core.common.util.Result;

import java.util.List;
import java.util.Map;

public interface ICustomerService {

    /**
     * 查询All客户
     * @return
     */
    public List<Customer> queryAllCustomers ();


    /**
     * 查询客户
     * @param customer
     * @return
     */
    public Map<String ,Object> queryCustomersByParams (Customer customer );


    public Result insertCustomers (Customer customer );

    public Result updateCustomers (Customer customer );

    public Result delCustomers (Integer id );


    public  Customer  queryCustomerById (int id );

}
