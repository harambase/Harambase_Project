package com.youedata.cd.harambase.service;

import com.youedata.cd.harambase.pojo.Bid;
import com.youedata.cd.harambase.pojo.ListOfBidders;

import java.util.List;
import java.util.Map;

/**
 * Created by sky on 2017/7/5.
 */
public interface BidService {
    List<Map<Integer, ListOfBidders>> listofbidders(Integer itemid);

    int insert(Bid bid);

    Double maxBidOfItem(Integer itemid);
}
