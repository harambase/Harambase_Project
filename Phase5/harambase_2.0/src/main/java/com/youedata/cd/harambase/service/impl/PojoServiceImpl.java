package com.youedata.cd.harambase.service.impl;

import com.youedata.cd.harambase.dao.PojoDao;
import com.youedata.cd.harambase.pojo.*;
import com.youedata.cd.harambase.service.PojoService;
import org.springframework.stereotype.Service;

/**
 * Created by sky on 2017/7/4.
 */
@Service
public class PojoServiceImpl implements PojoService {

    @Override
    public User login(String uname, String pwd) {
        return PojoDao.login(uname,pwd);
    }

    @Override
    public Item selectByPrimaryKey(Integer itemid) {
        return PojoDao.selectByPrimaryKey(itemid);
    }

    @Override
    public ListOfItems itemListbyTid(Integer itemid) {return PojoDao.itemListbyTid(itemid);
    }
}
