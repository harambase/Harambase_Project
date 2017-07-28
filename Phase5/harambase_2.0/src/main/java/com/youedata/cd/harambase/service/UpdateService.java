package com.youedata.cd.harambase.service;

import com.youedata.cd.harambase.pojo.Member;

/**
 * Created by sky on 2017/7/7.
 */
public interface UpdateService {

    int updateByPrimaryKeySelective(Member member);

}
