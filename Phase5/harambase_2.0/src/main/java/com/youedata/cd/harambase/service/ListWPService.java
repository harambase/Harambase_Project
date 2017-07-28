package com.youedata.cd.harambase.service;

import com.youedata.cd.harambase.dao.ListDaoWP;
import com.youedata.cd.harambase.pojo.*;

import java.util.List;
import java.util.Map;


/**
 * Created by sky on 2017/6/29.
 */
public interface ListWPService {
    
     List<ListOfBidders> listofbidders(Integer itemid);

     List<ListOfBidOn> bidonList(Integer userid);

     List<ListOfBought> boughtList(Integer userid);

     List<ListOfItems> itemList(Integer userid);

     List<SearchResult> search_item(Search search);

     List<Feedback> feedbackList(Integer userid);
}
