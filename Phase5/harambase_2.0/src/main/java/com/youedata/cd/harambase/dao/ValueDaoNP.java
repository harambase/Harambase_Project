package com.youedata.cd.harambase.dao;
import com.youedata.cd.store.service.DatabaseService;

import java.sql.ResultSet;


public class ValueDaoNP extends BaseDao {

    public static Double total(){
        Double ret = -1.0;
        DatabaseService service = null;
        try{
            service = DataServiceFactory.createDatabaseService(null);
            String textsb = "SELECT SUM(COMMISSIONS) AS TOTAL FROM OVERALL_COMMISSION_VIEW";
            ResultSet rs = service.getResultSet(textsb);

            while (rs.next())
                ret = rs.getDouble("TOTAL");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (service != null)
                service.releaseConnection();
        }
        return ret;

    }

    public static Double sumComm(){
        Double ret = -1.0;
        DatabaseService service = null;
        try{
            service = DataServiceFactory.createDatabaseService(null);
            String textsb = "SELECT SUM(COMMISSION) AS SUMCOM FROM SALES_SUMMARY_REPORT";
            ResultSet rs = service.getResultSet(textsb);

            while (rs.next())
                ret = rs.getDouble("SUMCOM");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (service != null)
                service.releaseConnection();
        }
        return ret;
    }

    public static Double sumTotal(){
        Double ret = -1.0;
        DatabaseService service = null;
        try{
            service = DataServiceFactory.createDatabaseService(null);
            String textsb = "SELECT SUM(FINAL_SELLING_PRICE) AS SUMTOTAL FROM SALES_SUMMARY_REPORT";
            ResultSet rs = service.getResultSet(textsb);

            while (rs.next())
                ret = rs.getDouble("SUMTOTAL");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (service != null)
                service.releaseConnection();
        }
        return ret;
    }

}