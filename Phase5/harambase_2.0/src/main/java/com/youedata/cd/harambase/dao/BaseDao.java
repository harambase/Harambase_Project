package com.youedata.cd.harambase.dao;

/**
 * Created by pc on 2017/5/22.
 */

import com.youedata.cd.store.connection.DatabaseConnection;
import com.youedata.cd.store.service.DatabaseService;
import com.youedata.cd.store.sql.SQL;
import com.youedata.cd.store.sql.SqlCmd;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pc on 2017/5/24.
 */
public class BaseDao {
     public static<T> int insert(T t, DatabaseConnection conn){
          int ret = -1;
          DatabaseService service = null;
          try{
               service = DataServiceFactory.createDatabaseService(conn);
               SqlCmd sqlCmd = SQL.getInsertSqlCmd(t);
               ret = service.executeSql(sqlCmd.getCmdText(), sqlCmd.getParam());

          }catch (Exception e) {
               e.printStackTrace();
          }
          finally {
               if (service != null)
                    service.releaseConnection();
          }
          return ret;
     }
     public static<T> int delete(T t, DatabaseConnection conn){
          int ret = 0;
          DatabaseService service = null;
          try{
               service = DataServiceFactory.createDatabaseService(conn);
               SqlCmd sqlCmd = SQL.getDeleteSqlCmd(t);
               ret = service.executeSql(sqlCmd.getCmdText(), sqlCmd.getParam());
          }catch (Exception e) {
               e.printStackTrace();
          }
          finally {
               if (service != null)
                    service.releaseConnection();
          }
          return ret;
     }
     public static<T> int update(T t, DatabaseConnection conn){
          int ret = -1;
          DatabaseService service = null;
          try{
               service = DataServiceFactory.createDatabaseService(conn);
               SqlCmd sqlCmd = SQL.getUpdateSqlCmd(t);
               ret = service.executeSql(sqlCmd.getCmdText(), sqlCmd.getParam());

          }catch (Exception e) {
               e.printStackTrace();
          }
          finally {
               if (service != null)
                    service.releaseConnection();
          }
          return ret;
     }
     public static<T> int selectCount(T t, DatabaseConnection conn){
          int ret = 0;
          DatabaseService service = null;
          try{
               service = DataServiceFactory.createDatabaseService(conn);
               SqlCmd sqlCmd = SQL.getSelectCountWhere(t);
               ResultSet rs= service.getResultSet(sqlCmd.getCmdText(), sqlCmd.getParam());
               if (rs.next())
                    ret = rs.getInt("count");
          }catch (Exception e) {
               e.printStackTrace();
          }
          finally {
               if (service != null)
                    service.releaseConnection();
          }
          return ret;
     }
     public static<T> List<T> selectByMap(T t, DatabaseConnection conn){
          List<T> list = new ArrayList<T>() ;
          DatabaseService service = null;
          try{
               service = DataServiceFactory.createDatabaseService(conn);
               SqlCmd sqlCmd = SQL.getSelectWhere(t);
               ResultSet rs= service.getResultSet(sqlCmd.getCmdText(), sqlCmd.getParam());
               list = SQL.getObjectFor(rs, (Class<T>)t.getClass());
          }catch (Exception e) {
               e.printStackTrace();
          }
          finally {
               if (service != null)
                    service.releaseConnection();
          }
          return list;
     }
     public static<T> List<T> selectByMap(T t, int start, int limit, DatabaseConnection conn){
          List<T> list = new ArrayList<T>() ;
          DatabaseService service = null;
          try{
               service = DataServiceFactory.createDatabaseService(conn);
               SqlCmd sqlCmd = SQL.getSelectWhere(t);
               sqlCmd.addCmdText(" limit "+ start +", "+limit);
               ResultSet rs= service.getResultSet(sqlCmd.getCmdText(), sqlCmd.getParam());
               list = SQL.getObjectFor(rs, (Class<T>)t.getClass());
          }catch (Exception e) {
               e.printStackTrace();
          }
          finally {
               if (service != null)
                    service.releaseConnection();
          }
          return list;
     }
     public static<T> List<T> selectByMapOrdered(T t, String orderCol, String orderDir, int start, int limit, DatabaseConnection conn) throws Exception{
               List<T> list = new ArrayList<T>() ;
               DatabaseService service = null;
               try{
               service = DataServiceFactory.createDatabaseService(conn);
               SqlCmd sqlCmd = SQL.getSelectWhere(t);
               sqlCmd.addCmdText("order by "+ orderCol +" "+ orderDir);
               sqlCmd.addCmdText(" limit "+start+", "+limit);
               ResultSet rs = service.getResultSet(sqlCmd.getCmdText(), sqlCmd.getParam());
               list = SQL.getObjectFor(rs, (Class<T>)t.getClass());
          }catch (Exception e) {
               e.printStackTrace();
          }
          finally {
               if (service != null)
                    service.releaseConnection();
          }
          return list;
     }
}
