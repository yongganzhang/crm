package com.shsxt.crm.biz.controller.report;

import com.shsxt.crm.biz.service.IReportService;
import com.shsxt.crm.core.common.util.Result;
import com.shsxt.crm.core.framework.context.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/report")
public class ReportController extends BaseController{

    @Autowired
    private IReportService reportService;

    @RequestMapping("/{type}")
    public  String index (@PathVariable Integer type ) {

        switch (type){
            case 0 :
               return "error";
            case 1:
                return "customer_gc";
            case 2 :
                return "error";
        }
        return "error";
    }


    /**
     * 查看客户构成分析
     * @return
     */
    @GetMapping("/queryCustomersGc")
    @ResponseBody
    public Result queryCustomersGc() {
        return reportService.queryCustomersGc();
    }
}
