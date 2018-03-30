package com.shsxt.crm.biz.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shsxt.crm.biz.dao.CustomerDao;
import com.shsxt.crm.biz.dao.CustomerServeDao;
import com.shsxt.crm.biz.model.CustomerServe;
import com.shsxt.crm.biz.model.SaleChance;
import com.shsxt.crm.biz.model.User;
import com.shsxt.crm.biz.service.ICustomerServeService;
import com.shsxt.crm.core.common.util.Result;
import com.shsxt.crm.core.common.util.VerificationLoginUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomerServeServiceImpl implements ICustomerServeService {

    @Autowired
    private CustomerServeDao customerServeDao;


    @Autowired(required = false)
    private HttpServletRequest req;

    @Override
    public Result insertServerInfo(CustomerServe customerServe) {
        customerServe.setCreateDate( new Date());
        customerServe.setUpdateDate(new Date());
        customerServe.setIsValid(1);
        customerServe.setState("1");

        // 获取 创建人
        User user = VerificationLoginUtil.getUserInfoFromSession(req);
        customerServe.setCreatePeople(user.getTrueName());

        long l = customerServeDao.saveSte(customerServe);
        if (l == 1) {
           return  Result.success("服务创建成功");
        }
        return Result.fail("创建失败");
    }

    @Override
    public Result updateServerInfo(CustomerServe customerServe) {
        customerServe.setUpdateDate(new Date ());

        //设置分配时间  处理时间  etc
        switch (customerServe.getState()) {
            case "2":
                customerServe.setAssignTime(new Date());
                break;

            case "3":
                customerServe.setServiceProceTime(new Date());
                User user = VerificationLoginUtil.getUserInfoFromSession(req);
                customerServe.setServiceProcePeople(user.getTrueName());// 设置处理人
                break;
            case "4":
//                customerServe.set(new Date());
                break;
        }

        long ste = customerServeDao.updateSte(customerServe);
        if (ste == 1) {
            return  Result.success("更新成功");
        }
        return Result.fail("更新失败");
    }

    /**
     * 查询服务
     * @param state 不同的服务处理状态
     * @param page
     * @param rows
     * @return
     */
    @Override
    public Map<String, Object> queryCustomerServesByParams(Integer state,Integer page, Integer rows) {

        Map<String, Object> params = new HashMap<>();
        params.put("state",state);
        params.put("isValid",1);
        List<CustomerServe> customerServes = customerServeDao.find(params);

        PageHelper.startPage(page,rows);
        // 分页对象
        PageInfo<CustomerServe> pageInfo = new PageInfo<>(customerServes);

        Map<String, Object> map = new HashMap<>();
        map.put("total", pageInfo.getTotal());
        map.put("rows", pageInfo.getList());
        return map;
    }
}
