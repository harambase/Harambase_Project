package com.youedata.cd.harambase.service;

import com.youedata.cd.harambase.pojo.Member;
import com.youedata.cd.harambase.pojo.Search;
import com.youedata.cd.harambase.pojo.SearchResult;


import java.util.List;
import java.util.Map;


/**
 * Created by sky on 2017/6/29.
 */
public interface MemberService {
    Member login(String uname, String pwd);

    List<Map<Integer, Member>> memberMap();

    int updateByPrimaryKeySelective(Member member);

    List<Map<Integer, SearchResult>> search_item(Search search);

    int insert(Member member);

}
