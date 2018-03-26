package com.shsxt.crm.biz.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shsxt.crm.biz.dao.CustomerDao;
import com.shsxt.crm.biz.model.Customer;
import com.shsxt.crm.biz.service.ICustomerService;
import com.shsxt.crm.core.common.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 客户服务
 */
@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerDao customerDao;


    @Override
    public List<Customer> queryAllCustomers() {

        Map<String, Object> params = new HashMap<>();
        params.put("isValid", 1);
        List<Customer> list = customerDao.find(params);

        return list;
//        return customerDao.queryAllCustomers();
    }


    @Override
    public Map<String, Object> queryCustomersByParams(Customer customer) {

        Map<String, Object> params = new HashMap<>();
        params.put("khno", customer.getKhno());
        params.put("name", customer.getName());
        params.put("isValid", 1);

        List<Customer> customers = customerDao.find(params);
        PageHelper.startPage(customer.getPage(), customer.getRows());
        PageInfo<Customer> pageInfo = new PageInfo<>(customers);

        Map<String, Object> map = new HashMap<>();
        map.put("total", pageInfo.getTotal());
        map.put("rows", pageInfo.getList());
        return map;
    }


    @Override
    public Result insertCustomers(Customer customer) {

        customer.setIsValid(1);
        customer.setCreateDate(new Date());
        customer.setUpdateDate(new Date());

        long ste = customerDao.saveSte(customer);

        if (ste == 1) {
            return Result.success("添加成功");
        }
        return Result.fail("添加失败");
    }

    @Override
    public Result updateCustomers(Customer customer) {

        customer.setUpdateDate(new Date());

        long ste = customerDao.updateSte(customer);
        if (ste == 1) {
            return Result.success("更新成功");
        }
        return Result.fail("更新失败");

    }

    @Override
    public Result delCustomers(Integer id) {

        Customer customer = new Customer();
        customer.setId(id);
        customer.setUpdateDate(new Date());
        customer.setIsValid(0);
        long ste = customerDao.updateSte(customer);

        if (ste == 1) {
            return Result.success("删除成功");
        }
        return Result.fail("删除失败");

    }
}
