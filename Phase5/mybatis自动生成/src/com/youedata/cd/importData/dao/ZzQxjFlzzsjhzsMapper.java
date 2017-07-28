package com.youedata.cd.importData.dao;

import com.youedata.cd.importData.pojo.ZzQxjFlzzsjhzs;

public interface ZzQxjFlzzsjhzsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ZzQxjFlzzsjhzs record);

    int insertSelective(ZzQxjFlzzsjhzs record);

    ZzQxjFlzzsjhzs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ZzQxjFlzzsjhzs record);

    int updateByPrimaryKey(ZzQxjFlzzsjhzs record);
}