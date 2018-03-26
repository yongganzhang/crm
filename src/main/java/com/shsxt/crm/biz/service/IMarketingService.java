package com.shsxt.crm.biz.service;

import com.shsxt.crm.biz.model.CusDevPlan;
import com.shsxt.crm.biz.model.SaleChance;
import com.shsxt.crm.core.common.util.Result;

import java.util.Map;

public interface IMarketingService {

    public Map<String, Object> querySaleChanceByParams (SaleChance saleChance);

    public Result insetSaleChanceInfo (SaleChance saleChance);

    public Result updateSaleChanceInfo (SaleChance saleChance);


    public Map<String, Object> querySaleChancesDeving (Integer page ,Integer rows);

    public SaleChance querySaleChanceById (int sid);


    public Map<String,Object > queryCusDevPlansByParams (Integer saleChanceId,int page , int rows);

    public Result insertCusDevPlans (CusDevPlan cusDevPlan);

    public Result updateCusDevPlans (CusDevPlan cusDevPlan);

    public Result delCusDevPlans (Integer cusDevPlanId );






}
