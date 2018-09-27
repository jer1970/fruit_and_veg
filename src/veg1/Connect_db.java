package veg1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class Connect_db {
	public Connection con = null; // manages connection
	public Statement statement = null; // query statement
	public ResultSet resultSet = null; // manages results
	public ResultSetMetaData metaData = null;
	public Connection connect(){
	 try {          
	        try {
				Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/veg?user=root&password=password&useSSL=true&serverTimezone=GMT" );
	        System.out.println ("Database connection established");
	        
	        
	        //maybe change sqlException to exception and get rid of all the try catches up above
	 }catch (SQLException ex) {
         System.out.println("SQLException: " + ex.getMessage());
         
     }
	 return con;
	}
}
