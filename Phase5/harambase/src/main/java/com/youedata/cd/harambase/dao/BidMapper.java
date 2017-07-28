package com.youedata.cd.harambase.dao;

import com.youedata.cd.harambase.pojo.Bid;
import com.youedata.cd.harambase.pojo.BidKey;
import com.youedata.cd.harambase.pojo.ListOfBidders;

import java.util.List;
import java.util.Map;

public interface BidMapper {
    int deleteByPrimaryKey(BidKey key);

    int insert(Bid record);

    int insertSelective(Bid record);

    Bid selectByPrimaryKey(BidKey key);

    int updateByPrimaryKeySelective(Bid record);

    int updateByPrimaryKey(Bid record);

    List<Map<Integer, ListOfBidders>> listofbidders(Integer itemid);

    Double maxBidOfItem(Integer itemid);
}