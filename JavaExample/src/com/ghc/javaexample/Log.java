/**
 * Logger.java
 *
 *	
 */
package com.ghc.javaexample;

import org.apache.log4j.Logger;

/**
 * 
 */
public class Log {
	static Logger sLog = Logger.getLogger(Log.class.getName());

	public static void debug(String message) {
		sLog.debug(message);
	}

	public static void debug(String message, Object... args) {
		sLog.debug(String.format(message, args));
	}

	public static void error(String message) {
		sLog.error(message);
	}
	
	public static void error(String message, Object... args) {
		sLog.error(String.format(message, args));
	}
}
