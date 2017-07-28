package com.youedata.cd.harambase.service;

import com.youedata.cd.harambase.dao.ListDaoNP;
import com.youedata.cd.harambase.pojo.*;

import java.util.List;
import java.util.Map;

/**
 * Created by sky on 2017/7/4.
 */
 public interface ListNPService {
    
     List<Member>memberMap();
    
     List<String> sumItemCategory();
    
     List<Overall> overallComm();

     List<Sales> sales();
}
