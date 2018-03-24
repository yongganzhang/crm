package com.shsxt.crm.biz.controller.marketing;

import com.shsxt.crm.biz.model.SaleChance;
import com.shsxt.crm.biz.service.IMarketingService;
import com.shsxt.crm.core.common.util.Result;
import com.shsxt.crm.core.framework.context.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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


    @RequestMapping("/insert")
    @ResponseBody
    public Result insetSaleChanceInfo (SaleChance saleChance) {
        return  marketingService.insetSaleChanceInfo(saleChance);
    }

    @RequestMapping("/update")
    @ResponseBody
    public Result updateSaleChanceInfo (SaleChance saleChance) {
        return  marketingService.updateSaleChanceInfo(saleChance);
    }


    /**
     * 查询营销机会数据
     * 默认 state = 1
     *
     * @param
     * @return
     */
    @PostMapping("/querySaleChancesDeving")
    @ResponseBody
    public Map<String, Object> querySaleChancesDeving (
            @RequestParam(defaultValue = "1")  Integer page,
             @RequestParam(defaultValue = "10")  Integer rows) {
        return marketingService.querySaleChancesDeving(page,rows);
    }

}
