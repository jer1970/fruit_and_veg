package veg1;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteRecord {
	public Scanner sc = new Scanner(System.in);
	
	public  void delete(Connection con){
		ResultSet resultSet;
    	try{
		DatabaseMetaData dbmd = con.getMetaData();

		
		System.out.println("Enter the record type: ");
		String type = sc.next();
		
			System.out.println("Enter " + type + "id/num: ");
			String id = sc.next();
			 Statement deleteStmt = con.createStatement();
			 String deleteSQL = "";
			 if(type.equals("product"))
	            deleteSQL = " Delete from " + type + " where " + type+"num = '" + id + "'" ;
			 else 
				 deleteSQL = " Delete from " + type + " where " + type+"id = '" + id + "'" ;
	            
			 int res = deleteStmt.executeUpdate(deleteSQL);
			 if(res == 1)
				 System.out.println("Record deleted");
    	}
    	catch(Exception io){
    		System.out.println("error"+io);
    	}
	}
}
