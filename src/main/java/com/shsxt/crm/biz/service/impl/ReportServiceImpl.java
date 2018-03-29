package com.shsxt.crm.biz.service.impl;

import com.shsxt.crm.biz.dao.ReportDao;
import com.shsxt.crm.biz.model.ReportCustomerGC;
import com.shsxt.crm.biz.service.IReportService;
import com.shsxt.crm.core.common.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements IReportService {


    @Autowired
    private ReportDao reportDao;


    @Override
    public Result queryCustomersGc() {
        List<ReportCustomerGC> reportCustomerGCS = reportDao.queryCustomersGc();
        List<String> level = new ArrayList<>();
        List<Integer> count = new ArrayList<>();

        for (ReportCustomerGC rep:reportCustomerGCS ) {
            level.add(rep.getLevel());
            count.add(rep.getCount());
        }
        //
        Map<String,Object> map = new HashMap<>();
        map.put("level",level);
        map.put("count",count);
        return Result.success("查询成功",map);
    }
}
