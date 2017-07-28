package com.youedata.cd.harambase.dao;

import com.youedata.cd.store.service.DatabaseService;

import java.sql.ResultSet;

/**
 * Created by sky on 2017/7/7.
 */
public class ValueDaoWP extends BaseDao{

    public static Integer subCount(String curCate){
        Integer ret = -1;
        DatabaseService service = null;
        try{
            service = DataServiceFactory.createDatabaseService(null);
            StringBuilder textsb = new StringBuilder();
            textsb.append("SELECT COUNT(*) AS COUNT FROM SALES_SUMMARY_REPORT WHERE ITEMCATEGORY = '");
            textsb.append(curCate);
            textsb.append("'");

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

    public static Integer numOfRec(Integer userid){
        Integer ret = -1;
        DatabaseService service = null;
        try{
            service = DataServiceFactory.createDatabaseService(null);
            StringBuilder textsb = new StringBuilder();
            textsb.append("SELECT COUNT(*) FROM HARAMBASE_FEEDBACK F, HARAMBASE_ITEM I WHERE F.ITEMID = I.ITEMID AND I.SELLERID = '");
            textsb.append(userid);
            textsb.append("'");

            ResultSet rs = service.getResultSet(textsb.toString());

            while (rs.next())
                ret = rs.getInt(0);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (service != null)
                service.releaseConnection();
        }
        return ret;
    }

    public static Double subComm(String itemCategory){
        Double ret = -1.0;
        DatabaseService service = null;
        try{
            service = DataServiceFactory.createDatabaseService(null);
            StringBuilder textsb = new StringBuilder();
            textsb.append("SELECT SUM(COMMISSION) AS SUBCOM FROM SALES_SUMMARY_REPORT WHERE ITEMCATEGORY = '");
            textsb.append(itemCategory);
            textsb.append("'");

            ResultSet rs = service.getResultSet(textsb.toString());

            while (rs.next())
                ret = rs.getDouble("SUBCOM");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (service != null)
                service.releaseConnection();
        }
        return ret;
    }

    public static Double subTotal(String itemCategory){
        Double ret = -1.0;
        DatabaseService service = null;
        try{
            service = DataServiceFactory.createDatabaseService(null);
            StringBuilder textsb = new StringBuilder();
            textsb.append("SELECT SUM(FINAL_SELLING_PRICE) AS SUBTOTAL FROM SALES_SUMMARY_REPORT WHERE ITEMCATEGORY = '");
            textsb.append(itemCategory);
            textsb.append("'");

            ResultSet rs = service.getResultSet(textsb.toString());

            while (rs.next())
                ret = rs.getDouble("SUBTOTAL");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (service != null)
                service.releaseConnection();
        }
        return ret;
    }

    public static Double maxBidOfItem(Integer itemid){
        Double ret = -1.0;
        DatabaseService service = null;
        try{
            service = DataServiceFactory.createDatabaseService(null);
            StringBuilder textsb = new StringBuilder();
            textsb.append("SELECT  MAX(MAXBIDLIMIT) FROM HARAMBASE_BID WHERE ITEMID = '");
            textsb.append(itemid);
            textsb.append("'");

            ResultSet rs = service.getResultSet(textsb.toString());

            while (rs.next())
                ret = rs.getDouble(0);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (service != null)
                service.releaseConnection();
        }
        return ret;
    }

    public static Double totalRate(Integer userid){

        Double ret = -1.0;
        DatabaseService service = null;
        try{
            service = DataServiceFactory.createDatabaseService(null);
            StringBuilder textsb = new StringBuilder();
            textsb.append("SELECT SUM(F.OVERALLRATING) FROM HARAMBASE_FEEDBACK F, HARAMBASE_ITEM I WHERE F.ITEMID = I.ITEMID AND I.SELLERID = '");
            textsb.append(userid);
            textsb.append("'");

            ResultSet rs = service.getResultSet(textsb.toString());

            while (rs.next())
                ret = rs.getDouble(0);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (service != null)
                service.releaseConnection();
        }
        return ret;
    }
}
