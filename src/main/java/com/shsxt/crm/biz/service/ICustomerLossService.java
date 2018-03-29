package com.shsxt.crm.biz.service;

import com.shsxt.crm.biz.model.CustomerLoss;

import java.util.Map;

public interface ICustomerLossService {

    /**查询流失客户
     *
     * @param customerLoss
     * @return
     */
    public Map<String ,Object> queryCustomerLossesByParams (CustomerLoss customerLoss);


    public CustomerLoss queryCustomerLossesById (Integer lossId);

    /**
     * 查询 暂缓措施
     *
     * @param lossId
     * @return
     */
    public Map<String ,Object> customerReprievesByLossId (Integer lossId ,Integer page ,Integer rows);

}
