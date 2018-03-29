package com.shsxt.crm.biz.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shsxt.crm.biz.dao.CustomerOrderDao;
import com.shsxt.crm.biz.dao.OrderDetailsDao;
import com.shsxt.crm.biz.model.Customer;
import com.shsxt.crm.biz.model.CustomerOrder;
import com.shsxt.crm.biz.model.OrderDetails;
import com.shsxt.crm.biz.service.ICustomerOrderService;
import com.shsxt.crm.core.common.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/***
 *
 * 客户订单
 *
 */
@Service
public class CustomerOrderServiceImpl implements ICustomerOrderService {

    @Autowired
    private CustomerOrderDao customerOrderDao;

    @Resource
    private OrderDetailsDao orderDetailsDao;

    @Override
    public Map<String, Object> queryOrdersByCid(Integer cid, Integer page, Integer rows) {

        Map<String,Object> params = new HashMap<>();
        params.put("cusId",cid );
        params.put("isValid","1");
        List<CustomerOrder> customerOrders = customerOrderDao.find(params);

        PageHelper.startPage(page,rows);
        PageInfo<CustomerOrder> pageInfo = new PageInfo<>(customerOrders);

        Map<String, Object> map = new HashMap<>();
        map.put("total", pageInfo.getTotal());
        map.put("rows", pageInfo.getList());
        return map;
    }

    @Override
    public Result queryCustoemrOrderByOrderId(Integer id) {

//        CustomerOrder order = customerOrderDao.get(orderId);
        Map<String ,Object> params = new HashMap<>();
        params.put("id",id);
        params.put("isValid","1");
        CustomerOrder order = customerOrderDao.findOne(params);
        if (order == null ) {
            return Result.success("客户无订单");
        }
        // 设置订单金额
        CustomerOrder customerOrder = queryTotalOfOrderGoodsPrice(order);
        return Result.success("查询成功",customerOrder);
    }

    @Override
    public Map<String, Object> queryOrderDetailsByOrderId(Integer orderId, Integer page, Integer rows) {

        Map<String ,Object> params = new HashMap<>();
        params.put("orderId",orderId);
        params.put("isValid","1");
        List<OrderDetails> orderDetails = orderDetailsDao.find(params);

        //分页
        PageHelper.startPage(page,rows);
        PageInfo<OrderDetails> pageInfo = new PageInfo<>(orderDetails);

        Map<String, Object> map = new HashMap<>();
        map.put("total", pageInfo.getTotal());
        map.put("rows", pageInfo.getList());
        return map;
    }


    /**
     * 订单总额
     */
    private  CustomerOrder  queryTotalOfOrderGoodsPrice (CustomerOrder order ) {

        Map<String ,Object> params = new HashMap<>();
        params.put("isValid","1");
        List<OrderDetails> orderDetails = orderDetailsDao.find(params);
        // 计算总价格
        double total = 0.0;
        Iterator<OrderDetails> itor = orderDetails.iterator();
            while (itor.hasNext()) {
                OrderDetails goods = itor.next();
                total+= goods.getSum();
            }
        order.setTotal(total);
        return order;
    }

}
