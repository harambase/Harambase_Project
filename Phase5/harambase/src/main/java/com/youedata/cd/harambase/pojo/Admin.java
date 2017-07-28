package com.youedata.cd.harambase.pojo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Admin implements Serializable {
    private Integer userid;

    private String uname;

    private String email;

    private String fname;

    private String lname;

    private String password;

    private Integer creatorid;

    private Map overComm;

    private Map sales;

    private Double total;

    private Double subTotoal;

    private Double subComm;

    private Double sumComm;

    private Double sumTotal;

    private List<String> sumItemCategory;

    private Integer subCount;

    public Integer getSubCount() {
        return subCount;
    }

    public void setSubCount(Integer subCount) {
        this.subCount = subCount;
    }

    public List<String> getSumItemCategory() {
        return sumItemCategory;
    }

    public void setSumItemCategory(List<String> sumItemCategory) {
        this.sumItemCategory = sumItemCategory;
    }

    public Double getSubTotoal() {
        return subTotoal;
    }

    public void setSubTotoal(Double subTotoal) {
        this.subTotoal = subTotoal;
    }

    public Double getSubComm() {
        return subComm;
    }

    public void setSubComm(Double subComm) {
        this.subComm = subComm;
    }

    public Double getSumComm() {
        return sumComm;
    }

    public void setSumComm(Double sumComm) {
        this.sumComm = sumComm;
    }

    public Double getSumTotal() {
        return sumTotal;
    }

    public void setSumTotal(Double sumTotal) {
        this.sumTotal = sumTotal;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Map getOverComm() {
        return overComm;
    }

    public void setOverComm(Map overComm) {
        this.overComm = overComm;
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

    public Map getSales() {
        return sales;
    }

    public void setSales(Map sales) {
        this.sales = sales;
    }
}