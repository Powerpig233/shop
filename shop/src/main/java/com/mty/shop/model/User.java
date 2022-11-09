package com.mty.shop.model;


public class User{

    private Integer id;
    private String phone;
    private String password;
    private String passwords;
    private String realname;
    private String sex;
    private String address;
    private java.util.Date createTime;

    public String getPasswords() {
        return passwords;
    }

    public void setPasswords(String passwords) {
        this.passwords = passwords;
    }

    public void setId(Integer value) {
        this.id = value;
    }
    public Integer getId() {
       return this.id;
    }
    public void setPhone(String value) {
        this.phone = value;
    }
    public String getPhone() {
       return this.phone;
    }
    public void setPassword(String value) {
        this.password = value;
    }
    public String getPassword() {
       return this.password;
    }
    public void setRealname(String value) {
        this.realname = value;
    }
    public String getRealname() {
       return this.realname;
    }
    public void setSex(String value) {
        this.sex = value;
    }
    public String getSex() {
       return this.sex;
    }
    public void setAddress(String value) {
        this.address = value;
    }
    public String getAddress() {
       return this.address;
    }
    public void setCreateTime(java.util.Date value) {
        this.createTime = value;
    }
    public java.util.Date getCreateTime() {
       return this.createTime;
    }
}
