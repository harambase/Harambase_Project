package com.youedata.cd.harambase.service.impl;

import com.youedata.cd.harambase.dao.ValueDaoNP;
import com.youedata.cd.harambase.dao.ValueDaoWP;
import com.youedata.cd.harambase.pojo.Admin;
import com.youedata.cd.harambase.pojo.Feedback;
import com.youedata.cd.harambase.pojo.Overall;
import com.youedata.cd.harambase.pojo.Sales;
import com.youedata.cd.harambase.service.InsertService;
import com.youedata.cd.harambase.service.ValueWPService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sky on 2017/6/28.
 */
@Service
public class ValueWPServiceImpl implements ValueWPService{

    @Override
    public Double subComm(String itemCategory) {
        return ValueDaoWP.subComm(itemCategory);
    }

    @Override
    public Double subTotal(String itemCategory) {
        return ValueDaoWP.subTotal(itemCategory);
    }

    @Override
    public Double maxBidOfItem(Integer itemid) {
        return ValueDaoWP.maxBidOfItem(itemid);
    }

    @Override
    public Double totalRate(Integer userid) {
        return ValueDaoWP.totalRate(userid);
    }

    @Override
    public Integer subCount(String curCate) {
        return ValueDaoWP.subCount(curCate);
    }

    @Override
    public Integer numOfRec(Integer userid) {
        return ValueDaoWP.numOfRec(userid);
    }


}

