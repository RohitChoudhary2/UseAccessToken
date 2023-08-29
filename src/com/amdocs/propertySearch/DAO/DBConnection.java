package com.amdocs.propertySearch.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public Connection getConnection() {
		// TODO Auto-generated method stub
		Connection c=null;
 	   try {
 		   Class.forName("oracle.jdbc.driver.OracleDriver");
			c=DriverManager.getConnection("Jdbc:Oracle:thin:@localhost:1521:orcl","scott","tiger"); //connection

 	   }
 	   catch(Exception e){
 		   e.printStackTrace();
 	   }
 	   return c;
	}
}
