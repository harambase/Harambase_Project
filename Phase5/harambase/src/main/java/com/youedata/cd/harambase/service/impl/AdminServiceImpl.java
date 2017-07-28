package com.youedata.cd.harambase.service.impl;

import com.youedata.cd.harambase.dao.AdminMapper;
import com.youedata.cd.harambase.pojo.Overall;
import com.youedata.cd.harambase.pojo.Sales;
import com.youedata.cd.harambase.service.AdminService;
import com.youedata.cd.harambase.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by sky on 2017/6/28.
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin login(String uname, String pwd) {
        return adminMapper.login(uname,pwd);
    }

    @Override
    public List<Map<Integer, Overall>> overallComm() {
        return adminMapper.overComm();
    }

    @Override
    public List<Map<Integer, Sales>> sales() {
        return adminMapper.sales();
    }

    @Override
    public Double total() {
        return adminMapper.total();
    }

    @Override
    public Double subComm(String itemCategory) {
        return adminMapper.subComm(itemCategory);
    }

    @Override
    public Double subTotal(String itemCategory) {
        return adminMapper.subTotal(itemCategory);
    }

    @Override
    public Double sumComm() {
        return adminMapper.sumComm();
    }

    @Override
    public Double sumTotal() {
        return adminMapper.sumTotal();
    }

    @Override
    public List<String> sumItemCategory() {
        return adminMapper.sumItemCategory();
    }

    @Override
    public Integer subCount(String curCate) {
        return adminMapper.subCount(curCate);
    }
}

