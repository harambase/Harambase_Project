package com.youedata.cd.harambase.dao;


import com.youedata.cd.harambase.pojo.*;
import com.youedata.cd.store.service.DatabaseService;
import com.youedata.cd.store.sql.SQL;

import java.sql.ResultSet;
import java.util.List;

/**
 * Created by sky on 2017/7/7.
 */
public class PojoDao extends BaseDao {

    public static User login(String uname, String pwd){
        List<Admin> ret = null;
        DatabaseService service = null;
        try {
            service = DataServiceFactory.createDatabaseService(null);
            StringBuilder textsb = new StringBuilder();
            textsb.append("SELECT * AS COUNT FROM HARAMBASE_ADMIN WHERE UNAME = '");
            textsb.append(uname);
            textsb.append("' AND PASSWORD = '");
            textsb.append(pwd);
            textsb.append("'");

            ResultSet rs = service.getResultSet(textsb.toString());

            if(rs.next())
                ret = SQL.getObjectFor(rs, Admin.class);

            if (ret.size()>0)
                return ret.get(0);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (service != null)
                service.releaseConnection();
        }
        return null;
    }

    public static ListOfItems itemListbyTid(Integer itemid){
        List<Admin> ret = null;
        DatabaseService service = null;
        try {
            service = DataServiceFactory.createDatabaseService(null);
            StringBuilder textsb = new StringBuilder();
            textsb.append("SELECT * FROM LIST_OF_ITEMS WHERE ITEMID = '");
            textsb.append(itemid);
            textsb.append("'");

            ResultSet rs = service.getResultSet(textsb.toString());

            if(rs.next())
                ret = SQL.getObjectFor(rs, Admin.class);

            if (ret.size()>0)
                return ret.get(0);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (service != null)
                service.releaseConnection();
        }
        return null;

    }

    public static Item selectByPrimaryKey(Integer itemid) {

    }

}
