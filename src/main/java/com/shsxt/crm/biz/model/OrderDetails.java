package com.shsxt.crm.biz.model;

import java.util.Date;

public class OrderDetails {
    /**
     * id
     * 
     */
    private Integer id;

    /**
     * order_id
     * 
     */
    private Integer orderId;

    /**
     * goods_name
     * 
     */
    private String goodsName;

    /**
     * goods_num
     * 
     */
    private Integer goodsNum;

    /**
     * unit
     * 
     */
    private String unit;

    /**
     * price
     * 
     */
    private Float price;

    /**
     * sum
     * 
     */
    private Float sum;

    /**
     * is_valid
     * 
     */
    private Integer isValid;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getSum() {
        return sum;
    }

    public void setSum(Float sum) {
        this.sum = sum;
    }

    public Integer getIsValid() {
        return isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
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
}