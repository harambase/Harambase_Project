package com.youedata.cd.harambase.pojo;

/**
 * Created by sky on 2017/7/5.
 */
public class ListOfBidders {
    private Integer itemid;
    private String bidderuname;
    private Integer status;
    private String  biddingtime;
    private Double maxbidlimit;
    private String winner;
    private Double soldprice;

    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }

    public String getBidderuname() {
        return bidderuname;
    }

    public void setBidderuname(String bidderuname) {
        this.bidderuname = bidderuname;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getBiddingtime() {
        return biddingtime;
    }

    public void setBiddingtime(String biddingtime) {
        this.biddingtime = biddingtime;
    }

    public Double getMaxbidlimit() {
        return maxbidlimit;
    }

    public void setMaxbidlimit(Double maxbidlimit) {
        this.maxbidlimit = maxbidlimit;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public Double getSoldprice() {
        return soldprice;
    }

    public void setSoldprice(Double soldprice) {
        this.soldprice = soldprice;
    }
}
