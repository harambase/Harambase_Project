package com.youedata.cd.harambase.service;

import com.youedata.cd.harambase.dao.PojoDao;
import com.youedata.cd.harambase.pojo.Feedback;
import com.youedata.cd.harambase.pojo.Item;
import com.youedata.cd.harambase.pojo.ListOfItems;
import com.youedata.cd.harambase.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * Created by sky on 2017/7/4.
 */
public interface PojoService {

    User login(String uname, String pwd);

    Item selectByPrimaryKey(Integer itemid);

    ListOfItems itemListbyTid(Integer itemid);


}
