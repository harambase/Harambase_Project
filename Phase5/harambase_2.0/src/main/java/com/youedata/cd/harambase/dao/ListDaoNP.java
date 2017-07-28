package com.youedata.cd.harambase.dao;

import com.youedata.cd.harambase.pojo.Member;
import com.youedata.cd.harambase.pojo.Overall;
import com.youedata.cd.harambase.pojo.Sales;
import com.youedata.cd.store.service.DatabaseService;
import com.youedata.cd.store.sql.SQL;

import java.sql.ResultSet;
import java.util.List;

/**
 * Created by sky on 2017/7/7.
 */
public class ListDaoNP extends BaseDao{

    public static List<Overall> overComm(){
        List<Overall> ret = null;
        DatabaseService service = null;
        try{
            service = DataServiceFactory.createDatabaseService(null);
            String textsb = "SELECT * FROM OVERALL_COMMISSION_VIEW ";
            ResultSet rs = service.getResultSet(textsb);

            while (rs.next())
                ret = SQL.getObjectFor(rs, Overall.class);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (service != null)
                service.releaseConnection();
        }
        return ret;
    }

    public static List<Sales> sales(){
        List<Sales> ret = null;
        DatabaseService service = null;
        try{
            service = DataServiceFactory.createDatabaseService(null);
            String textsb = "SELECT * FROM SALES_SUMMARY_REPORT ";
            ResultSet rs = service.getResultSet(textsb);

            while (rs.next())
                ret = SQL.getObjectFor(rs, Sales.class);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (service != null)
                service.releaseConnection();
        }
        return ret;
    }

    public static List<String> sumItemCategory(){
        List<String> ret = null;
        DatabaseService service = null;
        try{
            service = DataServiceFactory.createDatabaseService(null);
            String textsb = "SELECT DISTINCT ITEMCATEGORY  FROM SALES_SUMMARY_REPORT ";
            ResultSet rs = service.getResultSet(textsb);

            while (rs.next())
                ret = SQL.getObjectFor(rs, String.class);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (service != null)
                service.releaseConnection();
        }
        return ret;
    }

    public static List<Member> memberMap(){

    }

}
