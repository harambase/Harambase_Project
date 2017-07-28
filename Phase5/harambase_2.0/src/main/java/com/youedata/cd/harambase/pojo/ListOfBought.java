package com.youedata.cd.harambase.pojo;

/**
 * Created by sky on 2017/7/4.
 */
public class ListOfBought {
    private Integer itemid;
    private String itemname;
    private String itemcategory;
    private String auctionstarttime;
    private String auctionendtime;
    private Double startPrice;
    private Double soldPrice;
    private String sellername;
    private String sellerEmail;
    private String feedback;

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
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

    public Double getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(Double startPrice) {
        this.startPrice = startPrice;
    }

    public Double getSoldPrice() {
        return soldPrice;
    }

    public void setSoldPrice(Double soldPrice) {
        this.soldPrice = soldPrice;
    }

    public String getSellername() {
        return sellername;
    }

    public void setSellername(String sellername) {
        this.sellername = sellername;
    }

    public String getSellerEmail() {
        return sellerEmail;
    }

    public void setSellerEmail(String sellerEmail) {
        this.sellerEmail = sellerEmail;
    }
}
