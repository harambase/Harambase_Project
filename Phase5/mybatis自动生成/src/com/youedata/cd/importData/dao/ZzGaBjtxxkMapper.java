package com.youedata.cd.importData.dao;

import com.youedata.cd.importData.pojo.ZzGaBjtxxk;

public interface ZzGaBjtxxkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ZzGaBjtxxk record);

    int insertSelective(ZzGaBjtxxk record);

    ZzGaBjtxxk selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ZzGaBjtxxk record);

    int updateByPrimaryKey(ZzGaBjtxxk record);
}