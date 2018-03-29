package com.shsxt.crm.biz.dao;

import com.shsxt.crm.biz.model.Customer;
import com.shsxt.crm.core.framework.dao.BaseDao;

import java.util.List;

public interface CustomerDao extends BaseDao<Integer, Customer> {


    List<Customer> queryCustomerBeforeSixMonth ();

}