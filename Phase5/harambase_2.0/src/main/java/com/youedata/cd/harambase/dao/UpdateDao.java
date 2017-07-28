package com.youedata.cd.harambase.dao;

import com.youedata.cd.harambase.pojo.Member;
import com.youedata.cd.store.service.DatabaseService;

import java.sql.ResultSet;

/**
 * Created by sky on 2017/7/7.
 */
public class UpdateDao extends BaseDao {

    public static int updateByPrimaryKey(Member record){
        Integer ret = -1;
        DatabaseService service = null;
        try{
            service = DataServiceFactory.createDatabaseService(null);
            StringBuilder textsb = new StringBuilder();

            textsb.append("UPDATE harambase_member SET UNAME = '");
            textsb.append(record.getUname());
            textsb.append("',EMAIL = '");
            textsb.append(record.getEmail());
            textsb.append("',FNAME = '");
            textsb.append(record.getFname());
            textsb.append("',LNAME = '");
            textsb.append(record.getLname());
            textsb.append("',PASSWORD = '");
            textsb.append(record.getPassword());
            textsb.append("' WHERE USERID = '");
            textsb.append(record.getUserid());
            textsb.append("'");

            ret = 1;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (service != null)
                service.releaseConnection();
        }
        return ret;
    }

}
