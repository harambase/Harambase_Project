package com.youedata.cd.harambase.dao;

import com.youedata.cd.harambase.pojo.Member;
import com.youedata.cd.harambase.pojo.Search;
import com.youedata.cd.harambase.pojo.SearchResult;

import java.util.List;
import java.util.Map;

public interface MemberMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(Member record);

    int insertSelective(Member record);

    Member selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(Member record);

    int updateByPrimaryKey(Member record);

    Member login(String uname, String pwd);

    List<Map<Integer, Member>> memberMap();

    List<Map<Integer, SearchResult>> search_item(Search search);
}