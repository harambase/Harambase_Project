package com.youedata.cd.importData.dao;

import com.youedata.cd.importData.pojo.ZzQxjFlzzyshgz;

public interface ZzQxjFlzzyshgzMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ZzQxjFlzzyshgz record);

    int insertSelective(ZzQxjFlzzyshgz record);

    ZzQxjFlzzyshgz selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ZzQxjFlzzyshgz record);

    int updateByPrimaryKey(ZzQxjFlzzyshgz record);
}