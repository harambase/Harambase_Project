package com.youedata.cd.harambase.service;
import com.youedata.cd.harambase.pojo.Admin;
import com.youedata.cd.harambase.pojo.Overall;
import com.youedata.cd.harambase.pojo.Sales;

import java.util.List;
import java.util.Map;

/**
 * Created by sky on 2017/6/28.
 */
public interface AdminService {
    Admin login(String uname, String pwd);

    List<Map<Integer, Overall>> overallComm();

    List<Map<Integer, Sales>> sales();

    Double total();

    Double subComm(String itemCategory);

    Double subTotal(String itemCategory);

    Double sumComm();

    Double sumTotal();

    List<String> sumItemCategory();

    Integer subCount(String curCate);


}
