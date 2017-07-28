package com.youedata.cd.importData.dao;

import com.youedata.cd.importData.pojo.ZzGaJdcjsz;

public interface ZzGaJdcjszMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ZzGaJdcjsz record);

    int insertSelective(ZzGaJdcjsz record);

    ZzGaJdcjsz selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ZzGaJdcjsz record);

    int updateByPrimaryKey(ZzGaJdcjsz record);
}