package com.youedata.cd.harambase.pojo;

import java.io.Serializable;

public class Member implements Serializable {
    private Integer userid;

    private String uname;

    private String email;

    private String fname;

    private String lname;

    private String password;

    private Integer creatorid;

    private Integer isbuyer;

    private Integer iseller;

    public Member(String uname, String fname, String lname, String email,
                  String pass) {
        this.uname = uname;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.password = pass;
    }

    public Member(Integer userid, String uname, String fname, String lname,
                  String email, String password, Integer creatorid, Integer isbuyer,
                  Integer iseller) {
        this.uname = uname;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.password = password;
        this.userid = userid;
        this.creatorid = creatorid;
        this.isbuyer = isbuyer;
        this.iseller = iseller;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname == null ? null : fname.trim();
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname == null ? null : lname.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getCreatorid() {
        return creatorid;
    }

    public void setCreatorid(Integer creatorid) {
        this.creatorid = creatorid;
    }

    public Integer getIsbuyer() {
        return isbuyer;
    }

    public void setIsbuyer(Integer isbuyer) {
        this.isbuyer = isbuyer;
    }

    public Integer getIseller() {
        return iseller;
    }

    public void setIseller(Integer iseller) {
        this.iseller = iseller;
    }
}