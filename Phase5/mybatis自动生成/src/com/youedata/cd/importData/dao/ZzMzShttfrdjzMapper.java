package com.youedata.cd.importData.dao;

import com.youedata.cd.importData.pojo.ZzMzShttfrdjz;

public interface ZzMzShttfrdjzMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ZzMzShttfrdjz record);

    int insertSelective(ZzMzShttfrdjz record);

    ZzMzShttfrdjz selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ZzMzShttfrdjz record);

    int updateByPrimaryKey(ZzMzShttfrdjz record);
}