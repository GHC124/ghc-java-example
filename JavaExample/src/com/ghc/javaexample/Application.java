/**
 * Main.java
 *
 *	
 */
package com.ghc.javaexample;

import com.ghc.javaexample.localization.LocalizationApplication;

/**
 * 
 */
public class Application {
	public static void main(String[] args) {
		IApplication application = getApplication();
		application.runApp(args);

	}

	private static IApplication getApplication() {
		return new LocalizationApplication();
	}
}
