package com.youedata.cd.importData.dao;

import com.youedata.cd.test.pojo.BaseInfo;

public interface BaseInfoMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(BaseInfo record);

    int insertSelective(BaseInfo record);

    BaseInfo selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(BaseInfo record);

    int updateByPrimaryKey(BaseInfo record);
}