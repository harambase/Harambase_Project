package com.youedata.cd.importData.dao;

import com.youedata.cd.importData.pojo.ZzYjjYlqxjyqyxkz;

public interface ZzYjjYlqxjyqyxkzMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ZzYjjYlqxjyqyxkz record);

    int insertSelective(ZzYjjYlqxjyqyxkz record);

    ZzYjjYlqxjyqyxkz selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ZzYjjYlqxjyqyxkz record);

    int updateByPrimaryKey(ZzYjjYlqxjyqyxkz record);
}