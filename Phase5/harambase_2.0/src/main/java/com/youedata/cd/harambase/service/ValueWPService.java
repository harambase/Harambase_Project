package com.youedata.cd.harambase.service;

/**
 * Created by sky on 2017/7/7.
 */
public interface ValueWPService{

    Double subComm(String itemCategory);

    Double subTotal(String itemCategory);

    Double maxBidOfItem(Integer itemid);

    Double totalRate(Integer userid);

    Integer subCount(String curCate);

    Integer numOfRec(Integer userid);
}
