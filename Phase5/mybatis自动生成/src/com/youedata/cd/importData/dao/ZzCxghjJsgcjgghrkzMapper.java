package com.youedata.cd.importData.dao;

import com.youedata.cd.importData.pojo.ZzCxghjJsgcjgghrkz;

public interface ZzCxghjJsgcjgghrkzMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ZzCxghjJsgcjgghrkz record);

    int insertSelective(ZzCxghjJsgcjgghrkz record);

    ZzCxghjJsgcjgghrkz selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ZzCxghjJsgcjgghrkz record);

    int updateByPrimaryKey(ZzCxghjJsgcjgghrkz record);
}