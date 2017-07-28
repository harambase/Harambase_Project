package com.youedata.cd.harambase.dao;

import com.youedata.cd.harambase.pojo.Admin;
import com.youedata.cd.harambase.pojo.Overall;
import com.youedata.cd.harambase.pojo.Sales;

import java.util.List;
import java.util.Map;

public interface AdminMapper {

    int insert(Admin record);

    Admin login(String uname, String pwd);

    List<Map<Integer, Overall>> overComm();

    List<Map<Integer, Sales>> sales();

    //Overall Commission Total
    Double total();

    //Sales Summary totals:
    Double subComm(String itemCategory);

    Double subTotal(String itemCategory);

    Double sumComm();

    Double sumTotal();

    List<String> sumItemCategory();

    Integer subCount(String curCate);

}