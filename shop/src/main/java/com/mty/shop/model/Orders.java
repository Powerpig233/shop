package com.mty.shop.model;


import java.util.List;

public class Orders{

    private Integer id;
    private String no;
    private String num;
    private String total;
    private String uid;
    private String remark;
    private String status;
    private java.util.Date createTime;

    private String uname;
    private List<OrderItem> orderItems;

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public void setId(Integer value) {
        this.id = value;
    }
    public Integer getId() {
       return this.id;
    }
    public void setNo(String value) {
        this.no = value;
    }
    public String getNo() {
       return this.no;
    }
    public void setNum(String value) {
        this.num = value;
    }
    public String getNum() {
       return this.num;
    }
    public void setTotal(String value) {
        this.total = value;
    }
    public String getTotal() {
       return this.total;
    }
    public void setUid(String value) {
        this.uid = value;
    }
    public String getUid() {
       return this.uid;
    }
    public void setRemark(String value) {
        this.remark = value;
    }
    public String getRemark() {
       return this.remark;
    }
    public void setStatus(String value) {
        this.status = value;
    }
    public String getStatus() {
       return this.status;
    }
    public void setCreateTime(java.util.Date value) {
        this.createTime = value;
    }
    public java.util.Date getCreateTime() {
       return this.createTime;
    }
}
