package com.youedata.cd.harambase.pojo;

/**
 * Created by sky on 2017/7/3.
 */
public class Sales {
    private String itemCategory;
    private int itemID;
    private String itemName;
    private double final_selling_price;
    private double commission;

    public String getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getFinal_selling_price() {
        return final_selling_price;
    }

    public void setFinal_selling_price(double final_selling_price) {
        this.final_selling_price = final_selling_price;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }
}
