package com.youedata.cd.harambase.pojo;

/**
 * Created by sky on 2017/7/4.
 */
public class ListOfBidOn {
    private Integer itemid;
    private String itemname;
    private String itemcategory;
    private String auctionstarttime;
    private String auctionendtime;
    private Double currentPrice;
    private Double currenBid;
    private String winner;
    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getItemcategory() {
        return itemcategory;
    }

    public void setItemcategory(String itemcategory) {
        this.itemcategory = itemcategory;
    }

    public String getAuctionstarttime() {
        return auctionstarttime;
    }

    public void setAuctionstarttime(String auctionstarttime) {
        this.auctionstarttime = auctionstarttime;
    }

    public String getAuctionendtime() {
        return auctionendtime;
    }

    public void setAuctionendtime(String auctionendtime) {
        this.auctionendtime = auctionendtime;
    }

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public Double getCurrenBid() {
        return currenBid;
    }

    public void setCurrenBid(Double currenBid) {
        this.currenBid = currenBid;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }
}
