package com.youedata.cd.importData.dao;

import com.youedata.cd.importData.pojo.ZzCxghjJsgcghrkz;

public interface ZzCxghjJsgcghrkzMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ZzCxghjJsgcghrkz record);

    int insertSelective(ZzCxghjJsgcghrkz record);

    ZzCxghjJsgcghrkz selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ZzCxghjJsgcghrkz record);

    int updateByPrimaryKey(ZzCxghjJsgcghrkz record);
}