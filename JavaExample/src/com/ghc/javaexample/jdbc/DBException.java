/**
 * DBException.java
 *
 *	
 */
package com.ghc.javaexample.jdbc;

/**
 * 
 */
public class DBException extends Exception {
	private static final long serialVersionUID = 5948911535175263544L;	
	
	public DBException(Exception e) {
		super(e);
	}
}
