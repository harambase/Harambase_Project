package com.youedata.cd.importData.dao;

import com.youedata.cd.importData.pojo.ZzGaSfz;

public interface ZzGaSfzMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ZzGaSfz record);

    int insertSelective(ZzGaSfz record);

    ZzGaSfz selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ZzGaSfz record);

    int updateByPrimaryKey(ZzGaSfz record);
}