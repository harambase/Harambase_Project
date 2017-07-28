package com.youedata.cd.harambase.pojo;

import java.util.Date;

/**
 * Created by sky on 2017/7/6.
 */
public class SearchResult {
    private Integer itemid;
    private String itemname;
    private String itemCategory;
    private Date   auctionstarttime;
    private Date   auctionendtime;
    private Double currentbid;
    private Integer status;

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

    public String getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    public Date getAuctionstarttime() {
        return auctionstarttime;
    }

    public void setAuctionstarttime(Date auctionstarttime) {
        this.auctionstarttime = auctionstarttime;
    }

    public Date getAuctionendtime() {
        return auctionendtime;
    }

    public void setAuctionendtime(Date auctionendtime) {
        this.auctionendtime = auctionendtime;
    }

    public Double getCurrentbid() {
        return currentbid;
    }

    public void setCurrentbid(Double currentbid) {
        this.currentbid = currentbid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
