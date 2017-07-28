package com.youedata.cd.harambase.dao;


import com.youedata.cd.harambase.pojo.*;
import com.youedata.cd.store.service.DatabaseService;
import com.youedata.cd.store.sql.SQL;

import java.sql.ResultSet;
import java.util.List;

/**
 * Created by sky on 2017/7/7.
 */
public class ListDaoWP extends BaseDao {

    public static List<ListOfBidders> listofbidders(Integer itemid){
        List<ListOfBidders> ret = null;
        DatabaseService service = null;
        try{
            service = DataServiceFactory.createDatabaseService(null);
            String textsb = "SELECT * FROM LIST_OF_BIDDERS WHERE ITEMID = '" + itemid + "'";
            ResultSet rs = service.getResultSet(textsb);

            while (rs.next())
                ret = SQL.getObjectFor(rs, ListOfBidders.class);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (service != null)
                service.releaseConnection();
        }
        return ret;
    }

    public static List<Feedback> feedbackList(Integer userid){
        List<Feedback> ret = null;
        DatabaseService service = null;
        try{
            service = DataServiceFactory.createDatabaseService(null);
            String textsb = " SELECT * FROM HARAMBASE_FEEDBACK F, HARAMBASE_ITEM I WHERE F.ITEMID = I.ITEMID AND I.SELLERID = '" + userid + "'";
            ResultSet rs = service.getResultSet(textsb);

            while (rs.next())
                ret = SQL.getObjectFor(rs, Feedback.class);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (service != null)
                service.releaseConnection();
        }
        return ret;
    }

    public static List<ListOfBidOn> bidonList(Integer userid){

    }

    public static List<ListOfBought> boughtList(Integer userid){

    }

    public static List<ListOfItems> itemList(Integer userid){
  <select  id="itemList" parameterType="Integer" resultType="com.youedata.cd.harambase.pojo.ListOfItems">
                SELECT * FROM LIST_OF_ITEMS WHERE SELLERID = #{arg0};
  </select>
    }

    public static List<SearchResult> search_item(Search search){

    }

}
