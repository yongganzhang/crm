package com.shsxt.crm.biz.controller.customer;

import com.shsxt.crm.biz.model.CustomerLoss;
import com.shsxt.crm.biz.service.ICustomerLossService;
import com.shsxt.crm.core.framework.annotation.CheckType;
import com.shsxt.crm.core.framework.annotation.Permission;
import com.shsxt.crm.core.framework.context.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * 流失客户
 */
@Controller
@RequestMapping("/customer_loss")
public class CustomerLossController extends BaseController {

    @Autowired
    private ICustomerLossService customerLossService;

    @RequestMapping("/index")
    public String  index () {
        return  "customer_loss";
    }

    /**
     * 查询流失客户
     * @param customerLoss
     * @return
     */

    @RequestMapping("/queryCustomerLossesByParams")
    @ResponseBody
    public Map<String ,Object> queryCustomerLossesByParams (CustomerLoss customerLoss) {
        return  customerLossService.queryCustomerLossesByParams(customerLoss);
    }


    @RequestMapping("/{lossid}/customerRepriPage")
    public ModelAndView customerRepriPage (@PathVariable("lossid") Integer lossId ) {
        ModelAndView mv = new ModelAndView("customer_repri");
        CustomerLoss customerLoss = customerLossService.queryCustomerLossesById(lossId);
        mv.addObject("customerLoss",customerLoss);
        return  mv;
    }

    @RequestMapping("/customerReprievesByLossId")
    @ResponseBody
    public Map<String ,Object> customerReprievesByLossId (@RequestParam("lossId") Integer lossId,
                                                        @RequestParam(defaultValue = "1")  Integer page,
                                                          @RequestParam(defaultValue = "10")   Integer rows ) {
        return   customerLossService.customerReprievesByLossId(lossId, page, rows);
    }
}
