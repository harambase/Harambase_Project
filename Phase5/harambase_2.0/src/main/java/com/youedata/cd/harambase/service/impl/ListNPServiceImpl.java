package com.youedata.cd.harambase.service.impl;

import com.youedata.cd.harambase.dao.ListDaoNP;
import com.youedata.cd.harambase.dao.ValueDaoNP;
import com.youedata.cd.harambase.pojo.*;
import com.youedata.cd.harambase.service.ListNPService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sky on 2017/7/4.
 */
@Service
public class ListNPServiceImpl implements ListNPService {

    @Override
    public List<Member>memberMap() {
        return ListDaoNP.memberMap();
    }

    @Override
    public List<String> sumItemCategory() {
        return ListDaoNP.sumItemCategory();
    }

    @Override
    public List<Overall> overallComm() {
        return ListDaoNP.overComm();
    }

    @Override
    public List<Sales> sales() {
        return ListDaoNP.sales();
    }

}
