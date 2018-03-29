package com.shsxt.crm.biz.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shsxt.crm.biz.dao.CustomerLossDao;
import com.shsxt.crm.biz.dao.CustomerReprieveDao;
import com.shsxt.crm.biz.model.CustomerLoss;
import com.shsxt.crm.biz.model.CustomerReprieve;
import com.shsxt.crm.biz.service.ICustomerLossService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomerLossServiceImpl implements ICustomerLossService {

    @Autowired
    private CustomerLossDao customerLossDao;

    @Autowired
    private CustomerReprieveDao customerReprieveDao;

    public Map<String, Object> queryCustomerLossesByParams(CustomerLoss customerLoss) {

        Map<String, Object> params = new HashMap<>();
        params.put("cusName",customerLoss.getCusName());
        params.put("cusNo",customerLoss.getCusNo());
        params.put("cusManager",customerLoss.getCusManager());
        params.put("createDate",customerLoss.getCreateDate());
        params.put("isValid",1);
        List<CustomerLoss> list = customerLossDao.find(params);

        //分页
        PageHelper.startPage(customerLoss.getPage(),customerLoss.getRows());
        PageInfo<CustomerLoss> pageInfo = new PageInfo<>(list);

        Map<String, Object> map = new HashMap<>();
        map.put("total", pageInfo.getTotal());
        map.put("rows", pageInfo.getList());
        return map;
    }

    @Override
    public CustomerLoss queryCustomerLossesById(Integer lossId) {
        Map<String, Object> params = new HashMap<>();
        params.put("id",lossId);
        params.put("isValid",1);
        CustomerLoss lossOne = customerLossDao.findOne(params);
        return lossOne;
    }


    /**
     *  查询 暂缓措施
     *
     * @param lossId
     * @return
     */
    @Override
    public Map<String, Object> customerReprievesByLossId(Integer lossId,Integer page ,Integer rows ) {

        Map<String, Object> params = new HashMap<>();
        params.put("lossId",lossId);
        params.put("isValid",1);
        List<CustomerReprieve> customerReprieves = customerReprieveDao.find(params);

        //分页
        PageHelper.startPage(page,rows);
        PageInfo<CustomerReprieve> pageInfo = new PageInfo<>(customerReprieves);

        Map<String, Object> map = new HashMap<>();
        map.put("total", pageInfo.getTotal());
        map.put("rows", pageInfo.getList());
        return map;
    }
}
