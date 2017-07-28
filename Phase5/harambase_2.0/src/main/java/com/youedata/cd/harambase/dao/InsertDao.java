package com.youedata.cd.harambase.dao;

import com.youedata.cd.harambase.pojo.Bid;
import com.youedata.cd.harambase.pojo.Item;
import com.youedata.cd.harambase.pojo.Member;
import com.youedata.cd.store.service.DatabaseService;

import java.sql.ResultSet;

/**
 * Created by sky on 2017/7/7.
 */
public class InsertDao {

    public static int insert(Bid record){
        Integer ret = -1;
        DatabaseService service = null;
        try{
            service = DataServiceFactory.createDatabaseService(null);
            String textsb ="INSERT INTO HARAMBASE_BID VALUES('"
                    + record.getUserid() + ","
                    +record.getItemid() + ","
                    +record.getBiddingtime()+ ","
                    +record.getMaxbidlimit()+ ","
                    +"')";

            ResultSet rs = service.getResultSet(textsb.toString());

            while (rs.next())
                ret = rs.getInt("COUNT");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (service != null)
                service.releaseConnection();
        }
        return ret;
    }

    public static int insert(Item record){
        Integer ret = -1;
        DatabaseService service = null;
        try{
            service = DataServiceFactory.createDatabaseService(null);
            String textsb ="INSERT INTO HARAMBASE_BID VALUES('"
                    + record.getUserid() + ","
                    +record.getItemid() + ","
                    +record.getBiddingtime()+ ","
                    +record.getMaxbidlimit()+ ","
                    +"')";

            ResultSet rs = service.getResultSet(textsb.toString());

            while (rs.next())
                ret = rs.getInt("COUNT");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (service != null)
                service.releaseConnection();
        }
        return ret;
    }

    public static int insert(Member record){
        Integer ret = -1;
        DatabaseService service = null;
        try{
            service = DataServiceFactory.createDatabaseService(null);
            String textsb ="INSERT INTO HARAMBASE_BID VALUES('"
                    + record.getUserid() + ","
                    +record.getItemid() + ","
                    +record.getBiddingtime()+ ","
                    +record.getMaxbidlimit()+ ","
                    +"')";

            ResultSet rs = service.getResultSet(textsb.toString());

            while (rs.next())
                ret = rs.getInt("COUNT");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (service != null)
                service.releaseConnection();
        }
        return ret;
    }
}
