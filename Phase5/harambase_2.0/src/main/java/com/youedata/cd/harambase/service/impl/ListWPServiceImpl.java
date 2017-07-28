package com.youedata.cd.harambase.service.impl;

import com.youedata.cd.harambase.dao.ListDaoWP;
import com.youedata.cd.harambase.dao.ValueDaoNP;
import com.youedata.cd.harambase.pojo.*;
import com.youedata.cd.harambase.service.ListWPService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sky on 2017/6/29.
 */
@Service
public class ListWPServiceImpl implements ListWPService {

    @Override
    public List<ListOfBidders> listofbidders(Integer itemid) {
        return ListDaoWP.listofbidders(itemid);
    }

    @Override
    public List<ListOfBidOn> bidonList(Integer userid) {
        return ListDaoWP.bidonList(userid);
    }

    @Override
    public List<ListOfBought> boughtList(Integer userid) {
        return ListDaoWP.boughtList(userid);
    }

    @Override
    public List<ListOfItems> itemList(Integer userid) {
        return ListDaoWP.itemList(userid);
    }

    @Override
    public List<SearchResult> search_item(Search search) {
        return ListDaoWP.search_item(search);
    }

    @Override
    public List<Feedback> feedbackList(Integer userid) {
        return ListDaoWP.feedbackList(userid);
    }

}
