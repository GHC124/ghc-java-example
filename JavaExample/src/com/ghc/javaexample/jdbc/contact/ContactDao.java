/**
 * ContactDao.java
 *
 *	
 */
package com.ghc.javaexample.jdbc.contact;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ghc.javaexample.jdbc.DBException;
import com.ghc.javaexample.jdbc.DBManager;

/**
 * 
 */
public class ContactDao extends DBManager<Contact> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ghc.javaexample.jdbc.IDBManager#list()
	 */
	@Override
	public List<Contact> list() throws DBException {
		List<Contact> contacts = new ArrayList<>();
		
		try (Connection connection = getConnection()){
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from contact");
			while(resultSet.next()) {
				Contact contact = new Contact();
				contact.setId(resultSet.getInt("id"));
				contact.setFirstName(resultSet.getString("firstName"));
				contact.setLastName(resultSet.getString("lastName"));
				contact.setEmail(resultSet.getString("email"));
				contact.setPhoneNo(resultSet.getString("phoneNo"));
				contacts.add(contact);
			}
			
		} catch (SQLException e) {
			throw new DBException(e);
		}
		
		return contacts;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ghc.javaexample.jdbc.IDBManager#insert(java.io.Serializable)
	 */
	@Override
	public int insert(Contact t) throws DBException{
		Connection connection = null;
		ResultSet resultSet1 = null, resultSet2 = null;
		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			resultSet1 = statement.executeQuery("select * from familyGroup");
			resultSet1.moveToInsertRow();
			resultSet1.updateString("nickName", "testNickName1");
			resultSet1.insertRow();
			
			resultSet2 = statement.executeQuery("select * from contact");
			resultSet2.moveToInsertRow();
			resultSet2.updateString("firstName", "This is just a test to get SQLException ....");
			resultSet2.updateString("lastName", "Pham Van");
			resultSet2.insertRow();
			
			connection.commit();			
		} catch (SQLException e) {
			if(connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					throw new DBException(e);
				}
			}
			throw new DBException(e);
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					throw new DBException(e);
				}
			}
			if(resultSet1 != null) {
				try {
					resultSet1.close();
				} catch (SQLException e) {
					throw new DBException(e);
				}
			}
			if(resultSet2 != null) {
				try {
					resultSet2.close();
				} catch (SQLException e) {
					throw new DBException(e);
				}
			}
		}
		
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ghc.javaexample.jdbc.IDBManager#update(java.io.Serializable)
	 */
	@Override
	public int update(Contact t) throws DBException{
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ghc.javaexample.jdbc.IDBManager#delete(java.io.Serializable)
	 */
	@Override
	public void delete(Contact t) throws DBException{
		// TODO Auto-generated method stub

	}
}
