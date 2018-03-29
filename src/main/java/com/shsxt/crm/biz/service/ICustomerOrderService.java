package com.shsxt.crm.biz.service;

import com.shsxt.crm.core.common.util.Result;

import java.util.Map;

public interface ICustomerOrderService {

    /**
     * 查询客户订单
     *
     * @param cid 客户id
     * @param page
     * @param rows
     * @return
     */
    public Map<String ,Object> queryOrdersByCid (Integer cid, Integer page, Integer rows );

    /**
     * 根据订单id 查询
     * @param orderId  订单 id
     * @return
     */
    public Result queryCustoemrOrderByOrderId (Integer  orderId);

    public Map<String ,Object> queryOrderDetailsByOrderId (Integer orderId, Integer page, Integer rows );

}
