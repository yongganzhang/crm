package com.shsxt.crm.biz.service;

import com.shsxt.crm.biz.model.SaleChance;
import com.shsxt.crm.core.common.util.Result;

import java.util.Map;

public interface IMarketingService {

    public Map<String, Object> querySaleChanceByParams (SaleChance saleChance);

    public Result insetSaleChanceInfo (SaleChance saleChance);

    public Result updateSaleChanceInfo (SaleChance saleChance);

}
