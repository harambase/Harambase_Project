package com.youedata.cd.harambase.service.impl;

import com.youedata.cd.harambase.dao.ValueDaoNP;
import com.youedata.cd.harambase.service.ValueNPService;
import org.springframework.stereotype.Service;


/**
 * Created by sky on 2017/7/5.
 */
@Service
public class ValueNPServiceImpl implements ValueNPService {

    @Override
    public Double total() {
        return ValueDaoNP.total();
    }

    @Override
    public Double sumComm() {
        return ValueDaoNP.sumComm();
    }

    @Override
    public Double sumTotal() {
        return ValueDaoNP.sumTotal();
    }
}
