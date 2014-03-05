/**
 * DBManager.java
 *
 *	
 */
package com.ghc.javaexample.jdbc;

import static com.ghc.javaexample.jdbc.DBConstants.DATABASE_NAME;
import static com.ghc.javaexample.jdbc.DBConstants.PASSWORD;
import static com.ghc.javaexample.jdbc.DBConstants.URL;
import static com.ghc.javaexample.jdbc.DBConstants.USER_NAME;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.ghc.javaexample.Log;

/**
 * 
 */
public abstract class DBManager<T extends Serializable> implements
		IDBManager<T> {
	public DBManager() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ghc.javaexample.jdbc.IDBManager#getConnection()
	 */
	@Override
	public Connection getConnection() throws DBException {
		Connection connection = null;
		try {
			//Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(URL + DATABASE_NAME,
					USER_NAME, PASSWORD);
			Log.debug("Open Connection successfully to " + DATABASE_NAME);
		} catch (SQLException e) {
			throw new DBException(e);			
		}
		return connection;
	}
}
