package com.youedata.cd.importData.dao;

import com.youedata.cd.importData.pojo.ZzTjjTjgldjz;

public interface ZzTjjTjgldjzMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ZzTjjTjgldjz record);

    int insertSelective(ZzTjjTjgldjz record);

    ZzTjjTjgldjz selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ZzTjjTjgldjz record);

    int updateByPrimaryKey(ZzTjjTjgldjz record);
}