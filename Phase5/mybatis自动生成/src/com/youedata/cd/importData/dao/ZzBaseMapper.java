package com.youedata.cd.importData.dao;

import com.youedata.cd.importData.pojo.ZzBase;

public interface ZzBaseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ZzBase record);

    int insertSelective(ZzBase record);

    ZzBase selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ZzBase record);

    int updateByPrimaryKey(ZzBase record);
}