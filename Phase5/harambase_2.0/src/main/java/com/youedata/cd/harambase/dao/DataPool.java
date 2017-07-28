package com.youedata.cd.harambase.dao;

import com.youedata.cd.store.connection.DatabaseConnection;
import com.youedata.cd.store.connection.DatabaseConnectionPool;
import com.zaxxer.hikari.HikariConfig;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Author: Jiang Pingchuan, 2016/10/19
 */
public class DataPool {
	private static DatabaseConnectionPool dbpool;

	public static boolean initPool() {
		boolean ret = false;
		/**
		 * init db pool
		 */
		Properties properties = new Properties();
		try {
			InputStream is = DataPool.class.getResourceAsStream("/dbpool/db.properties");
			properties.load(is);
		} catch (IOException e) {
			// e.printStackTrace();
			return ret;
		}
		HikariConfig configdb = new HikariConfig(properties);
		dbpool = new DatabaseConnectionPool(configdb);

		ret = true;
		return ret;
	}
	public static boolean initPool(String confUri) {
		boolean ret = false;
		/**
		 * init db pool
		 */
		Properties properties = new Properties();
		try {
			File e = new File(confUri);
			FileInputStream is = new FileInputStream(e);
			properties.load(is);
		} catch (IOException e) {
			// e.printStackTrace();
			return ret;
		}
		HikariConfig configdb = new HikariConfig(properties);
		dbpool = new DatabaseConnectionPool(configdb);

		ret = true;
		return ret;
	}
	public static DatabaseConnection getDBConnection() {

		if (dbpool != null) {
			return dbpool.getConnection();
		} else {
			DataPool.initPool();
			return dbpool.getConnection();
		}
	}
}
