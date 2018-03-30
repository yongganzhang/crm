package com.shsxt.crm.biz.dao;

import com.shsxt.crm.biz.model.ReportCustomerGC;
import com.shsxt.crm.biz.model.ReportServer;
import com.shsxt.crm.core.common.util.Result;

import java.util.List;

public interface ReportDao {

    public List<ReportCustomerGC> queryCustomersGc();

    List<ReportServer>  queryCustomersServerAnalysis();


}
