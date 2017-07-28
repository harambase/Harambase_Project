package com.youedata.cd.harambase.dao;

import com.youedata.cd.harambase.pojo.Feedback;

import java.util.List;
import java.util.Map;

public interface FeedbackMapper {
    int deleteByPrimaryKey(Integer itemid);

    int insert(Feedback record);

    int insertSelective(Feedback record);

    Feedback selectByPrimaryKey(Integer itemid);

    int updateByPrimaryKeySelective(Feedback record);

    int updateByPrimaryKey(Feedback record);

    Integer numOfRec(Integer userid);

    List<Map<Integer,Feedback>> feedbackList(Integer userid);

    Double totalRate(Integer userid);
}