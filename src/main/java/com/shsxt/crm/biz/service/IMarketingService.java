package com.shsxt.crm.biz.service;

import com.shsxt.crm.biz.model.SaleChance;

import java.util.Map;

public interface IMarketingService {

    public Map<String, Object> querySaleChanceByParams (SaleChance saleChance);

}
