package com.youedata.cd.harambase.service.impl;

import com.youedata.cd.harambase.dao.ItemMapper;
import com.youedata.cd.harambase.pojo.Item;
import com.youedata.cd.harambase.pojo.ListOfBidOn;
import com.youedata.cd.harambase.pojo.ListOfBought;
import com.youedata.cd.harambase.pojo.ListOfItems;
import com.youedata.cd.harambase.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by sky on 2017/7/4.
 */
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    ItemMapper itemMapper;

    @Override
    public List<Map<Integer, ListOfBidOn>> bidonList(Integer userid) {
        return itemMapper.bidonList(userid);
    }

    @Override
    public List<Map<Integer, ListOfBought>> boughtList(Integer userid) {
        return itemMapper.boughtList(userid);
    }

    @Override
    public List<Map<Integer, ListOfItems>> itemList(Integer userid) {
        return itemMapper.itemList(userid);
    }

    @Override
    public Item selectByPrimaryKey(Integer itemid) {
        return itemMapper.selectByPrimaryKey(itemid);
    }

    @Override
    public ListOfItems itemListbyTid(Integer itemid) {
        return itemMapper.itemListbyTid(itemid);
    }

    @Override
    public int insert(Item item) {
        return itemMapper.insert(item);
    }


}
