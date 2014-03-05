/**
 * Contact.java
 *
 *	
 */
package com.ghc.javaexample.jdbc.contact;

import java.io.Serializable;

/**
 * 
 */
public class Contact implements Serializable {
	private static final long serialVersionUID = -3616117479147775473L;
	private int mId;
	private String mFirstName;
	private String mLastName;
	private String mEmail;
	private String mPhoneNo;

	public int getId() {
		return mId;
	}

	public void setId(int id) {
		mId = id;
	}

	public String getFirstName() {
		return mFirstName;
	}

	public void setFirstName(String firstName) {
		mFirstName = firstName;
	}

	public String getLastName() {
		return mLastName;
	}

	public void setLastName(String lastName) {
		mLastName = lastName;
	}

	public String getEmail() {
		return mEmail;
	}

	public void setEmail(String email) {
		mEmail = email;
	}

	public String getPhoneNo() {
		return mPhoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		mPhoneNo = phoneNo;
	}

	@Override
	public String toString() {
		return String.format("%d %s %s %s %s", mId, mFirstName, mLastName, mEmail, mPhoneNo);
	}
}
