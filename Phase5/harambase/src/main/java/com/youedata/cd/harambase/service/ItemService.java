package com.youedata.cd.harambase.service;

import com.youedata.cd.harambase.pojo.Item;
import com.youedata.cd.harambase.pojo.ListOfBidOn;
import com.youedata.cd.harambase.pojo.ListOfBought;
import com.youedata.cd.harambase.pojo.ListOfItems;

import java.util.List;
import java.util.Map;

/**
 * Created by sky on 2017/7/4.
 */
public interface ItemService {
    List<Map<Integer,ListOfBidOn>> bidonList(Integer userid);

    List<Map<Integer,ListOfBought>> boughtList(Integer userid);

    List<Map<Integer,ListOfItems>> itemList(Integer userid);

    Item selectByPrimaryKey(Integer itemid);

    ListOfItems itemListbyTid(Integer itemid);

    int insert(Item item);
}
