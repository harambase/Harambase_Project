package com.youedata.cd.harambase.service.impl;

import com.youedata.cd.harambase.dao.BidMapper;
import com.youedata.cd.harambase.pojo.Bid;
import com.youedata.cd.harambase.pojo.ListOfBidders;
import com.youedata.cd.harambase.service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by sky on 2017/7/5.
 */
@Service
public class BidServiceImpl implements BidService {

    @Autowired
    BidMapper bidMapper;

    @Override
    public List<Map<Integer, ListOfBidders>> listofbidders(Integer itemid) {
        return bidMapper.listofbidders(itemid);
    }

    @Override
    public int insert(Bid bid) {
        return bidMapper.insert(bid);
    }

    @Override
    public Double maxBidOfItem(Integer itemid) {
        return bidMapper.maxBidOfItem(itemid);
    }
}
