package com.youedata.cd.harambase.service.impl;

import com.youedata.cd.harambase.dao.FeedbackMapper;
import com.youedata.cd.harambase.pojo.Feedback;
import com.youedata.cd.harambase.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by sky on 2017/7/4.
 */
@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
    FeedbackMapper feedbackMapper;

    @Override
    public Integer numOfRec(Integer userid) {
        return feedbackMapper.numOfRec(userid);
    }

    @Override
    public List<Map<Integer, Feedback>> feedbackList(Integer userid) {
        return feedbackMapper.feedbackList(userid);
    }

    @Override
    public Double totalRate(Integer userid) {
        return feedbackMapper.totalRate(userid);
    }
}
