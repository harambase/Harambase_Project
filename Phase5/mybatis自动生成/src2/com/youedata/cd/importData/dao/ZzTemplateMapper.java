package com.youedata.cd.importData.dao;

import com.youedata.cd.importData.pojo.ZzTemplate;

public interface ZzTemplateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ZzTemplate record);

    int insertSelective(ZzTemplate record);

    ZzTemplate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ZzTemplate record);

    int updateByPrimaryKey(ZzTemplate record);
}