package com.shsxt.crm.core.framework.model;

import com.shsxt.crm.core.framework.constant.CrmConstant;

public class BaseQuery {

    // 当前页
    private Integer page = CrmConstant.CRM_PAGE_NUM;;

    // size
    private Integer rows = CrmConstant.CRM_PAGE_SIZE;


    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
}
