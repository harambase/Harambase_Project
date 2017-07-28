package com.youedata.cd.harambase.service;

import com.youedata.cd.harambase.dao.ValueDaoNP;
import com.youedata.cd.harambase.pojo.Bid;
import com.youedata.cd.harambase.pojo.ListOfBidders;

import java.util.List;
import java.util.Map;

/**
 * Created by sky on 2017/7/5.
 */
public interface ValueNPService {

    Double total();

    Double sumComm();

    Double sumTotal();

}
