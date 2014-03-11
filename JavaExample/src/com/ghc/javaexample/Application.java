/**
 * Main.java
 *
 *	
 */
package com.ghc.javaexample;

import com.ghc.javaexample.concurrency.SumNumber;

/**
 * 
 */
public class Application {
	public static void main(String[] args) {
		IApplication application = getApplication();
		application.runApp(args);

	}

	private static IApplication getApplication() {
		return new SumNumber(1_000_000_000L);
	}
}
