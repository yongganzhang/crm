package com.shsxt.crm.biz.controller.customer;

import com.shsxt.crm.biz.model.Customer;
import com.shsxt.crm.biz.service.ICustomerService;
import com.shsxt.crm.core.common.util.Result;
import com.shsxt.crm.core.framework.annotation.CheckType;
import com.shsxt.crm.core.framework.annotation.Permission;
import com.shsxt.crm.core.framework.context.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * 客户
 */
@Controller
@RequestMapping("/customer")
public class CustomerController  extends BaseController {

    @Autowired
    private ICustomerService customerService;


    @RequestMapping("/index")
    public String  index () {
        return "customer";
    }


    @Permission(checkType = CheckType.LOGIN)
    @RequestMapping("/queryAllCustomers")
    @ResponseBody
    public List<Customer> queryAllCustomers () {
        return customerService.queryAllCustomers();
    }


    @RequestMapping("/queryCustomersByParams")
    @ResponseBody
    public Map<String ,Object> queryCustomersByParams (Customer customer )   {
        return  customerService.queryCustomersByParams(customer);
    }

        @RequestMapping("/insert")
        @ResponseBody
        public Result insertCustomers (Customer customer )   {
            return  customerService.insertCustomers(customer);
        }

        @RequestMapping("/update")
        @ResponseBody
        public Result updateCustomers (Customer customer )   {
            return  customerService.updateCustomers(customer);
        }

        @RequestMapping("/delete")
        @ResponseBody
        public Result deleteCustomers (@RequestParam("ids") int id)   {
            return  customerService.delCustomers(id);
        }

        @RequestMapping("/toOtherPage/{type}/{cid}")
        public ModelAndView  toOtherPage(@PathVariable (value = "type") Integer type,
                                  @PathVariable (value = "cid")  Integer cid ) {
            ModelAndView mv = new ModelAndView();
            switch (type) {
                case 1:
                    mv.setViewName("customer_linkman");
                    break;
                case 2:
                    mv.setViewName("customer_contact");
                    break;
                case 3:
                    mv.setViewName("customer_order");
                    Customer customer = customerService.queryCustomerById(cid);
                    mv.addObject("customer",customer);
                    break;
                    default:
                        mv.setViewName("error");
            }
            return  mv;
        }
}
