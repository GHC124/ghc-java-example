/**
 * IDBManager.java
 *
 *	
 */
package com.ghc.javaexample.jdbc;

import java.io.Serializable;
import java.sql.Connection;
import java.util.List;

/**
 * 
 */
public interface IDBManager<T extends Serializable> {
	Connection getConnection() throws DBException;

	List<T> list() throws DBException;

	int insert(T t) throws DBException;

	int update(T t) throws DBException;

	void delete(T t) throws DBException;
}
