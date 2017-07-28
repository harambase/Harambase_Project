package com.youedata.cd.importData.dao;

import com.youedata.cd.importData.pojo.ZzMzMbfqy;

public interface ZzMzMbfqyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ZzMzMbfqy record);

    int insertSelective(ZzMzMbfqy record);

    ZzMzMbfqy selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ZzMzMbfqy record);

    int updateByPrimaryKey(ZzMzMbfqy record);
}