/**
 * DBApplication.java
 *
 *	
 */
package com.ghc.javaexample.jdbc;

import java.util.List;

import com.ghc.javaexample.IApplication;
import com.ghc.javaexample.jdbc.contact.Contact;
import com.ghc.javaexample.jdbc.contact.ContactDao;

/**
 * 
 */
public class DBApplication implements IApplication {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ghc.javaexample.IApplication#runApp(java.lang.String[])
	 */
	@Override
	public void runApp(String[] args) {
		list();
	}
	
	private void list() {
		ContactDao contactDao = new ContactDao();
		try {
			List<Contact> contacts = contactDao.list();
			for(Contact contact:contacts){
				System.out.println(contact);
			}			
		} catch (DBException e) {
			e.printStackTrace();
		}
	}
	
	private void testACID() {		
		System.out.println("Transaction ACID");
		ContactDao contactDao = new ContactDao();
		try {
			contactDao.insert(new Contact());
			list();			
		} catch (DBException e) {
			e.printStackTrace();
		}
	}
}
