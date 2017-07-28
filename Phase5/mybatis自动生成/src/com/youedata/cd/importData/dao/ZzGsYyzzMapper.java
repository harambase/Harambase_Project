package com.youedata.cd.importData.dao;

import com.youedata.cd.importData.pojo.ZzGsYyzz;

public interface ZzGsYyzzMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ZzGsYyzz record);

    int insertSelective(ZzGsYyzz record);

    ZzGsYyzz selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ZzGsYyzz record);

    int updateByPrimaryKey(ZzGsYyzz record);
}