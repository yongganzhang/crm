package com.shsxt.crm.biz.controller.marketing;

import com.shsxt.crm.biz.model.SaleChance;
import com.shsxt.crm.biz.service.IMarketingService;
import com.shsxt.crm.core.framework.context.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 营销管理
 */
@Controller
@RequestMapping("/marketing")
public class MarketingController extends BaseController {

    @Autowired
    private IMarketingService marketingService;

    /**
     * 跳转
     *  1.营销机会管理
     *  2.客户开发计划
     *
     * @param type
     * @return
     */
    @RequestMapping("/{type}/index")
    public String index (@PathVariable("type") Integer type) {
        switch (type) {
            case 1:
                return  "sale_chance";
            case 2:
                return  "cus_dev_plan";
            default:
                return "error";
        }
    }


    /**
     * 查询营销机会数据
     * @param saleChance
     * @return
     */
    @PostMapping("/querySaleChancesByParams")
    @ResponseBody
    public Map<String, Object> querySaleChanceByParams (SaleChance saleChance) {
        return marketingService.querySaleChanceByParams(saleChance);
    }
}
