/**
 * LocalizationApplication.java
 *
 *	
 */
package com.ghc.javaexample.localization;

import java.util.Locale;
import java.util.ResourceBundle;

import com.ghc.javaexample.IApplication;
import com.ghc.javaexample.Log;

/**
 * 
 */
public class LocalizationApplication implements IApplication {

	/* (non-Javadoc)
	 * @see com.ghc.javaexample.IApplication#runApp(java.lang.String[])
	 */
	@Override
	public void runApp(String[] args) {
		ResourceBundle bundle = ResourceBundle.getBundle("resource", new Locale("vi"));
		String message = bundle.getString("message");
		Log.debug(message);
	}

}
