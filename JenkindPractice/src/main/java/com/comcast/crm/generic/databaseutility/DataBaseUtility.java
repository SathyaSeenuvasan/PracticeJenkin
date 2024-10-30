package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.protocol.Resultset;

public class DataBaseUtility {
	
	Connection con;
	
	public void getDbconnection()
	{
		try{
			Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		}
		catch(Exception e)
		{
		}
		}
		
		public void closeDbconnection() throws Throwable {
		try {
			con.close();
		}catch(Exception e) {}
		}
		
		
		public ResultSet executesSelectQurey(String query) {
		ResultSet result=null;
		
		try {
			Statement stat = con.createStatement();
			result=stat.executeQuery(query);
		}catch(Exception e)
		{}
		return result;
		
				
		}
		
		public int executeNonSelectQuery(String query) {
			
			int result =0;
			try {
				Statement stat=con.createStatement();
			result	= stat.executeUpdate(query);
				
				
				
				
			}catch(Exception e) {}
			
			return result;
			
		}


		
				
				
		
		


}
