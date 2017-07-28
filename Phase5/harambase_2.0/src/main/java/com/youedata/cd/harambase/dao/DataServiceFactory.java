package com.youedata.cd.harambase.dao;

import com.youedata.cd.store.connection.DatabaseConnection;
import com.youedata.cd.store.service.DatabaseService;
import com.youedata.cd.store.service.impl.DatabaseServiceImpl;

/**
 * Created by pc on 2017/5/24.
 */
public class DataServiceFactory {

    public static  DatabaseService createDatabaseService(DatabaseConnection databaseConnection){
        if (databaseConnection ==null){
            databaseConnection = DataPool.getDBConnection();
        }
        return new DatabaseServiceImpl(databaseConnection);
    }

}
