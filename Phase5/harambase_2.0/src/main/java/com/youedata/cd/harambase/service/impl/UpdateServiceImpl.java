package com.youedata.cd.harambase.service.impl;

import com.youedata.cd.harambase.dao.UpdateDao;
import com.youedata.cd.harambase.pojo.Member;
import com.youedata.cd.harambase.service.UpdateService;
import org.springframework.stereotype.Service;

/**
 * Created by sky on 2017/7/7.
 */
@Service
public class UpdateServiceImpl implements UpdateService {

    @Override
    public int updateByPrimaryKeySelective(Member member) {
        return UpdateDao.updateByPrimaryKey(member);
    }
}
