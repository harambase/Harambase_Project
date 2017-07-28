package com.youedata.cd.harambase.dao;

import com.youedata.cd.harambase.pojo.Item;
import com.youedata.cd.harambase.pojo.ListOfBidOn;
import com.youedata.cd.harambase.pojo.ListOfBought;
import com.youedata.cd.harambase.pojo.ListOfItems;

import java.util.List;
import java.util.Map;

public interface ItemMapper {
    int deleteByPrimaryKey(Integer itemid);

    int insert(Item record);

    int insertSelective(Item record);

    Item selectByPrimaryKey(Integer itemid);

    int updateByPrimaryKeySelective(Item record);

    int updateByPrimaryKey(Item record);

    List<Map<Integer,ListOfBidOn>> bidonList(Integer userid);

    List<Map<Integer,ListOfBought>> boughtList(Integer userid);

    List<Map<Integer,ListOfItems>> itemList(Integer userid);

    ListOfItems itemListbyTid(Integer itemid);
}