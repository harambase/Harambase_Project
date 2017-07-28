package com.youedata.cd.harambase.service.impl;

import com.youedata.cd.harambase.dao.MemberMapper;
import com.youedata.cd.harambase.pojo.Member;
import com.youedata.cd.harambase.pojo.Search;
import com.youedata.cd.harambase.pojo.SearchResult;
import com.youedata.cd.harambase.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Map;

/**
 * Created by sky on 2017/6/29.
 */
@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberMapper memberMapper;

    @Override
    public Member login(String uname, String pwd) {
        return memberMapper.login(uname,pwd);
    }

    @Override
    public List<Map<Integer, Member>>memberMap() {
        return memberMapper.memberMap();
    }

    @Override
    public int updateByPrimaryKeySelective(Member member) {
        return memberMapper.updateByPrimaryKey(member);
    }

    @Override
    public List<Map<Integer, SearchResult>> search_item(Search search) {
        return memberMapper.search_item(search);
    }

    @Override
    public int insert(Member member) {
        return memberMapper.insert(member);
    }
}
