package com.youedata.cd.harambase.pojo;

import java.util.Date;

/**
 * Created by sky on 2017/7/6.
 */
public class Search {
    private Integer tid;
    private String keyword;
    private String tcategory;
    private Date   tauctionstarttime;
    private Date   tauctionendtime;
    private Double curbidmin;
    private Double curbidmax;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getTcategory() {
        return tcategory;
    }

    public void setTcategory(String tcategory) {
        this.tcategory = tcategory;
    }

    public Date getTauctionstarttime() {
        return tauctionstarttime;
    }

    public void setTauctionstarttime(Date tauctionstarttime) {
        this.tauctionstarttime = tauctionstarttime;
    }

    public Date getTauctionendtime() {
        return tauctionendtime;
    }

    public void setTauctionendtime(Date tauctionendtime) {
        this.tauctionendtime = tauctionendtime;
    }

    public Double getCurbidmin() {
        return curbidmin;
    }

    public void setCurbidmin(Double curbidmin) {
        this.curbidmin = curbidmin;
    }

    public Double getCurbidmax() {
        return curbidmax;
    }

    public void setCurbidmax(Double curbidmax) {
        this.curbidmax = curbidmax;
    }
}
