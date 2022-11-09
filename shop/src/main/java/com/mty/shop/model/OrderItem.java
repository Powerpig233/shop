package com.mty.shop.model;


public class OrderItem{

    private Integer id;
    private String oid;
    private String gid;
    private String num;
    private String money;
    private java.util.Date createTime;
    private String gname;
    private String image;

    private String oname;
    private String uid;
    private String uname;
    private String no;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getOname() {
        return oname;
    }

    public void setOname(String oname) {
        this.oname = oname;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public void setId(Integer value) {
        this.id = value;
    }
    public Integer getId() {
       return this.id;
    }
    public void setOid(String value) {
        this.oid = value;
    }
    public String getOid() {
       return this.oid;
    }
    public void setGid(String value) {
        this.gid = value;
    }
    public String getGid() {
       return this.gid;
    }
    public void setNum(String value) {
        this.num = value;
    }
    public String getNum() {
       return this.num;
    }
    public void setMoney(String value) {
        this.money = value;
    }
    public String getMoney() {
       return this.money;
    }
    public void setCreateTime(java.util.Date value) {
        this.createTime = value;
    }
    public java.util.Date getCreateTime() {
       return this.createTime;
    }
}
