package com.shsxt.crm.biz.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shsxt.crm.biz.dao.CusDevPlanDao;
import com.shsxt.crm.biz.dao.MarketingDao;
import com.shsxt.crm.biz.model.CusDevPlan;
import com.shsxt.crm.biz.model.SaleChance;
import com.shsxt.crm.biz.model.User;
import com.shsxt.crm.biz.service.IMarketingService;
import com.shsxt.crm.core.common.util.Result;
import com.shsxt.crm.core.common.util.VerificationLoginUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MarketingServiceImpl implements IMarketingService {

    @Autowired
    private MarketingDao marketingDao;

    @Autowired(required = false)
    private HttpServletRequest req;

    @Autowired
    private CusDevPlanDao cusDevPlanDao;


    /**
     * 分页
     *
     * @param saleChance
     * @return
     */
    @Override
    public Map<String, Object> querySaleChanceByParams(SaleChance saleChance) {

        //构建分页对象
        PageHelper.startPage(saleChance.getPage(), saleChance.getRows());

        List<SaleChance> saleChances = marketingDao.querySaleChanceByParams(saleChance);
        // 分页对象
        PageInfo<SaleChance> pageInfo = new PageInfo<>(saleChances);

        Map<String, Object> map = new HashMap<>();
        map.put("total", pageInfo.getTotal());
        map.put("rows", pageInfo.getList());
        return map;
    }

    @Override
    @Transactional
    public Result insetSaleChanceInfo(SaleChance saleChance) {

        User user = VerificationLoginUtil.getUserInfoFromSession(req);

        // 设置参数
        saleChance.setCreateMan(user.getTrueName());
        saleChance.setAssignTime(new Date());

        saleChance.setState(1);
        saleChance.setIsValid(1);
        saleChance.setCreateDate(new Date());
        saleChance.setUpdateDate(new Date());

        int res = marketingDao.insertSaleChanceInfo(saleChance);
        if (res == 1) {
            return Result.success("添加成功");
        }
        return Result.fail("添加失败");
    }


    @Override
    public Result updateSaleChanceInfo(SaleChance saleChance) {

        saleChance.setUpdateDate(new Date());

        //更新
        int res = marketingDao.updateSaleChanceInfoV2(saleChance);
        if (res == 1) {
            return Result.success("更新成功");
        }
        return Result.fail("更新失败");
    }


    /***
     * 查询 营销机会
     * @param page
     * @param rows
     * @return
     */
    @Override
    public Map<String, Object> querySaleChancesDeving(Integer page, Integer rows) {

        List<SaleChance> saleChances = marketingDao.querySaleChancesDeving();

        //1.构建分页参数
        PageHelper.startPage(page,rows);
        PageInfo<SaleChance> pageInfo = new PageInfo<>(saleChances);

        Map<String, Object> map = new HashMap<>();
        map.put("total", pageInfo.getTotal());
        map.put("rows", pageInfo.getList());
        return map;
    }

    @Override
    public SaleChance querySaleChanceById(int sid) {
        return marketingDao.querySaleChanceById(sid);
    }

    @Override
    public Map<String, Object> queryCusDevPlansByParams(Integer saleChanceId,int page , int rows) {

        Map<String,Object >  params = new HashMap<>();

        params.put("saleChanceId",saleChanceId);
        params.put("isValid","1");
        List<CusDevPlan> cusDevPlans = cusDevPlanDao.find(params);

        PageHelper.startPage(page, rows);
        PageInfo<CusDevPlan> pageInfo = new PageInfo<>(cusDevPlans);

        Map<String,Object >  map  = new HashMap<>();
        map.put("total", pageInfo.getTotal());
        map.put("rows", pageInfo.getList());
        return map;
    }

    @Override
    public Result insertCusDevPlans(CusDevPlan cusDevPlan) {

        cusDevPlan.setCreateDate(new Date());
        cusDevPlan.setUpdateDate(new Date());
        cusDevPlan.setIsValid(1);

        long ste = cusDevPlanDao.saveSte(cusDevPlan);
        if (ste == 1) {
            return  Result.success("添加成功") ;
        }
        return Result.fail("添加失败");
    }

    @Override
    public Result updateCusDevPlans(CusDevPlan cusDevPlan) {

        cusDevPlan.setUpdateDate(new Date());
        long ste = cusDevPlanDao.updateSte(cusDevPlan);

        if (ste == 1) {
            return  Result.success("更新成功") ;
        }
        return Result.fail("更新失败");
    }

    @Override
    public Result delCusDevPlans(Integer cusDevPlanId) {

        CusDevPlan cusDevPlan = new CusDevPlan();
        cusDevPlan.setId(cusDevPlanId);
        cusDevPlan.setIsValid(0);

        long ste = cusDevPlanDao.updateSte(cusDevPlan);
        if (ste == 1) {
            return  Result.success("删除成功") ;
        }
        return Result.fail("删除失败");

    }


}
