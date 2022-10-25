package com.mty.shop.model;

//gou wu che
public class Cart{

    private Integer id;//dingdan
    private String gid;//shang pin id
    private String num;//shangpin shuliang
    private String uid;//yonghu
    private java.util.Date createTime;

    private String gname;
    private String uname;
    private Goods goods;
    private String total;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
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
    public void setUid(String value) {
        this.uid = value;
    }
    public String getUid() {
       return this.uid;
    }
    public void setCreateTime(java.util.Date value) {
        this.createTime = value;
    }
    public java.util.Date getCreateTime() {
       return this.createTime;
    }
}
