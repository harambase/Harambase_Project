package com.youedata.cd.harambase.service.impl;

import com.youedata.cd.harambase.dao.InsertDao;
import com.youedata.cd.harambase.pojo.Bid;
import com.youedata.cd.harambase.pojo.Item;
import com.youedata.cd.harambase.pojo.Member;
import com.youedata.cd.harambase.service.InsertService;
import org.springframework.stereotype.Service;

/**
 * Created by sky on 2017/7/7.
 */
@Service
public class InsertServiceImpl implements InsertService {

    @Override
    public int insert(Item item) {
        return InsertDao.insert(item);
    }

    @Override
    public int insert(Member member) {
        return InsertDao.insert(member);
    }

    @Override
    public int insert(Bid bid) {
        return InsertDao.insert(bid);
    }
}
