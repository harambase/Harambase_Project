package com.youedata.cd.harambase.service;

import com.youedata.cd.harambase.pojo.Feedback;

import java.util.List;
import java.util.Map;

/**
 * Created by sky on 2017/7/4.
 */
public interface FeedbackService {
    Integer numOfRec(Integer userid);

    List<Map<Integer,Feedback>> feedbackList(Integer userid);

    Double totalRate(Integer userid);
}
