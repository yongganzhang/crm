package com.shsxt.crm.biz.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.shsxt.crm.core.framework.constant.CrmConstant;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class CusDevPlan {
    /**
     * id
     * 
     */
    private Integer id;

    /**
     * sale_chance_id
     * 
     */
    private Integer saleChanceId;

    /**
     * plan_item
     * 
     */
    private String planItem;

    /**
     * plan_date
     * 
     */
    @DateTimeFormat(pattern = CrmConstant.DATE_FORMATE_YMD)
    @JsonFormat(pattern = CrmConstant.DATE_FORMATE_YMD, timezone = "GMT+8")
    private Date planDate;

    /**
     * exe_affect
     * 
     */
    private String exeAffect;

    /**
     * create_date
     * 
     */
    @DateTimeFormat(pattern = CrmConstant.DATE_FORMATE_YMD)
    @JsonFormat(pattern = CrmConstant.DATE_FORMATE_YMD, timezone = "GMT+8")
    private Date createDate;

    /**
     * update_date
     * 
     */
    @DateTimeFormat(pattern = CrmConstant.DATE_FORMATE_YMD)
    @JsonFormat(pattern = CrmConstant.DATE_FORMATE_YMD, timezone = "GMT+8")
    private Date updateDate;

    /**
     * is_valid
     * 
     */
    private Integer isValid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSaleChanceId() {
        return saleChanceId;
    }

    public void setSaleChanceId(Integer saleChanceId) {
        this.saleChanceId = saleChanceId;
    }

    public String getPlanItem() {
        return planItem;
    }

    public void setPlanItem(String planItem) {
        this.planItem = planItem;
    }

    public Date getPlanDate() {
        return planDate;
    }

    public void setPlanDate(Date planDate) {
        this.planDate = planDate;
    }

    public String getExeAffect() {
        return exeAffect;
    }

    public void setExeAffect(String exeAffect) {
        this.exeAffect = exeAffect;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getIsValid() {
        return isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }
}