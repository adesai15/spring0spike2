package com.srccodes.example;
import java.sql.*;  

public class ConnectDatabase {
 
	// JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost:3306/college?user=root";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "root";
	   
	   public static void main(String[] args) {
		   Connection conn = null;
		   Statement stmt = null;
		   
		   try {
			 //STEP 2: Register JDBC driver
			      Class.forName("com.mysql.jdbc.Driver");

			      //STEP 3: Open a connection
			      System.out.println("Connecting to database...");
			      conn = DriverManager.getConnection(DB_URL,USER,PASS);

			      //STEP 4: Execute a query
			      System.out.println("Creating statement...");
			      stmt = conn.createStatement();
			      String sql;
			      sql = "SELECT * FROM student";
			      ResultSet rs = stmt.executeQuery(sql);
			      
			      while(rs.next()){
			          //Retrieve by column name
			          int id  = rs.getInt("studentid");
			          String last = rs.getString("name");

			          //Display values
			          System.out.print("ID: " + id);
			          System.out.println(", name: " + last);
			       }
			       //STEP 6: Clean-up environment
			       rs.close();
			       stmt.close();
			       conn.close();
		   }catch(Exception se){
			      //Handle errors for JDBC
			      se.printStackTrace();
			   }
	   }
	   

}
