package com.shsxt.crm.biz.controller.server;

import com.shsxt.crm.biz.model.CustomerServe;
import com.shsxt.crm.biz.service.ICustomerServeService;
import com.shsxt.crm.core.common.util.Result;
import com.shsxt.crm.core.framework.context.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/server")
public class CustomerServerController extends BaseController {

    @Autowired
    private ICustomerServeService customerServeService;

    @RequestMapping("/{type}/index")
    public String index (@PathVariable  Integer type) {

        switch (type){
            case 1:
              return "customer_serve_create";// 服务创建
            case 2:
                return "customer_serve_assign"; // 服务分配
            case 3:
                return "customer_serve_proceed";//处理
            case 4:
                return "customer_serve_feed_back";//反馈
            case 5:
                return "customer_serve_archive"; //归档
        }
        return "error";
    }

    /**
     * 服务 创建
     * @param customerServe
     * @return
     */
    @RequestMapping("/insert")
    @ResponseBody
    public Result insertServerInfo (CustomerServe customerServe) {
        return customerServeService.insertServerInfo(customerServe);
    }

    @RequestMapping("/queryCustomerServesByParams")
    @ResponseBody
    public Map<String ,Object> queryCustomerServesByParams (Integer state,
                                                            @RequestParam(defaultValue = "1") Integer page,
                                                            @RequestParam(defaultValue = "10")  Integer rows) {
        return  customerServeService.queryCustomerServesByParams(state,page,rows );
    }


    /**
     * 服务状态 更新
     * @param customerServe
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public Result updateServerInfo (CustomerServe customerServe) {
        return customerServeService.updateServerInfo(customerServe);
    }


}
