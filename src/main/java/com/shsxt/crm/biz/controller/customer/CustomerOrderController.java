package com.shsxt.crm.biz.controller.customer;

import com.shsxt.crm.biz.service.ICustomerOrderService;
import com.shsxt.crm.core.common.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/customer_order")
public class CustomerOrderController {

    @Autowired
    private ICustomerOrderService customerOrderService;



    @RequestMapping("/queryOrdersByCid")
    @ResponseBody
    public Map<String ,Object> queryOrdersByCid (Integer  cid ,
                                                 @RequestParam(defaultValue = "1") Integer page,
                                                 @RequestParam(defaultValue = "10") Integer rows ) {
        return  customerOrderService.queryOrdersByCid(cid,page, rows);
    }


    /**
     * 查看订单详情
     * @param orderId
     * @return
     */
    @RequestMapping("/queryCustoemrOrderByOrderId")
    @ResponseBody
    public Result  queryCustoemrOrderByOrderId (Integer  orderId ) {
        return  customerOrderService.queryCustoemrOrderByOrderId(orderId);
    }


    @RequestMapping("/queryOrderDetailsByOrderId")
    @ResponseBody
    public Map<String ,Object> queryOrderDetailsByOrderId (Integer  orderId ,
                                                 @RequestParam(defaultValue = "1") Integer page,
                                                 @RequestParam(defaultValue = "10") Integer rows ) {
        return  customerOrderService.queryOrderDetailsByOrderId(orderId,page,rows);
    }

}
