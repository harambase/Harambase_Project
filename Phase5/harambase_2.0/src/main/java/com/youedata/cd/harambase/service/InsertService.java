package com.youedata.cd.harambase.service;
import com.youedata.cd.harambase.dao.InsertDao;
import com.youedata.cd.harambase.pojo.*;

import java.util.List;
import java.util.Map;

/**
 * Created by sky on 2017/6/28.
 */
public interface InsertService {

    int insert(Item item);

    int insert(Member member);

    int insert(Bid bid);
}
