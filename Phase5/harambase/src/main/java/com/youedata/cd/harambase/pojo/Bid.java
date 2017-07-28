package com.youedata.cd.harambase.pojo;

import java.util.Date;

public class Bid extends BidKey {
    private Date biddingtime;

    private Double maxbidlimit;

    public Date getBiddingtime() {
        return biddingtime;
    }

    public void setBiddingtime(Date biddingtime) {
        this.biddingtime = biddingtime;
    }

    public Double getMaxbidlimit() {
        return maxbidlimit;
    }

    public void setMaxbidlimit(Double maxbidlimit) {
        this.maxbidlimit = maxbidlimit;
    }
}