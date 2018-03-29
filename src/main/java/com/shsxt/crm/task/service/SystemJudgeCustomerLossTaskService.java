package com.shsxt.crm.task.service;

import com.shsxt.crm.biz.dao.CustomerDao;
import com.shsxt.crm.biz.dao.CustomerLossDao;
import com.shsxt.crm.biz.dao.CustomerOrderDao;
import com.shsxt.crm.biz.model.Customer;
import com.shsxt.crm.biz.model.CustomerLoss;
import com.shsxt.crm.biz.model.CustomerOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SystemJudgeCustomerLossTaskService {

    @Autowired
    private CustomerOrderDao customerOrderDao;

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private CustomerLossDao customerLossDao;

    /**
     * 注册时间超过6个月客户
     * @return
     */
    public List<Customer> queryCustomerBeforeSixMonth () {
        return customerDao.queryCustomerBeforeSixMonth();
    }

    @Transactional
    public  void  SystemJudgeCustomerLossHasOrder   ( ) {
        List<Customer> customers = queryCustomerBeforeSixMonth();
        for (Customer cus:customers ) {
            List<CustomerOrder> customerOrders = queryCustomerOderByCid(cus.getId());
            if (customerOrders == null ||  customerOrders.size() <=0) {
                // 流失客户
                CustomerLoss customerLoss = new CustomerLoss();
                customerLoss.setCusNo(cus.getKhno());
                customerLoss.setCusName(cus.getName());
                customerLoss.setCusManager(cus.getCusManager());
                customerLoss.setState(0);
                customerLoss.setCreateDate(new Date());
                customerLoss.setUpdateDate(new Date());
                customerLoss.setLossReason("系统判定为暂缓流失客户");

                Map<String, Object> params = new HashMap<>();
                params.put("cusNo",cus.getKhno());
                params.put("isValid",1);
                //在插入 流失客户表中 之前 先查询是否已经存在  不存在再次插入数据
                CustomerLoss loss = customerLossDao.findOne(params);
                if (loss == null) {
                    customerLossDao.saveSte(customerLoss);
                }
            }
        }
    }
    /**
     *  根据 客户查询客户订单
     * @param cid
     * @return
     */
    public List<CustomerOrder> queryCustomerOderByCid (Integer cid) {

        Map<String,Object> params = new HashMap<>();
        params.put("cusId",cid );
//        params.put("isValid","1");
        List<CustomerOrder> customerOrders = customerOrderDao.find(params);
        return customerOrders;

    }
}
