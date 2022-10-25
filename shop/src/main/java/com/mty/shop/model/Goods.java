package com.mty.shop.model;


public class Goods{

    private Integer id;
    private String image;
    private String name;
    private String cid;
    private String money;
    private String content;
    private java.util.Date createTime;

    private String cname;


    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public void setId(Integer value) {
        this.id = value;
    }
    public Integer getId() {
       return this.id;
    }
    public void setImage(String value) {
        this.image = value;
    }
    public String getImage() {
       return this.image;
    }
    public void setName(String value) {
        this.name = value;
    }
    public String getName() {
       return this.name;
    }
    public void setCid(String value) {
        this.cid = value;
    }
    public String getCid() {
       return this.cid;
    }
    public void setMoney(String value) {
        this.money = value;
    }
    public String getMoney() {
       return this.money;
    }
    public void setContent(String value) {
        this.content = value;
    }
    public String getContent() {
       return this.content;
    }
    public void setCreateTime(java.util.Date value) {
        this.createTime = value;
    }
    public java.util.Date getCreateTime() {
       return this.createTime;
    }
}
