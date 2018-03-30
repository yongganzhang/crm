package com.shsxt.crm.biz.model;

public class ReportServer {

    // 服务类型
    private  String name;

    // 统计总数
    private Integer value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
