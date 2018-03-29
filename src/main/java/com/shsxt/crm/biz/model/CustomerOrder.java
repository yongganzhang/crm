package com.shsxt.crm.biz.model;

import com.shsxt.crm.core.framework.dao.BaseQuery;

import java.util.Date;

public class CustomerOrder extends BaseQuery {
    /**
     * id
     * 
     */
    private Integer id;

    /**
     * cus_id
     * 
     */
    private Integer cusId;

    /**
     * order_no
     * 
     */
    private String orderNo;

    /**
     * order_date
     * 
     */
    private Date orderDate;

    /**
     * address
     * 
     */
    private String address;

    /**
     * state
     * 
     */
    private Integer state;

    /**
     * create_date
     * 
     */
    private Date createDate;

    /**
     * update_date
     * 
     */
    private Date updateDate;

    /**
     * is_valid
     * 
     */
    private Integer isValid;

    /**
     * 订单总额
     */
    private  double total;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}