package veg1;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class InsertRecord {
	   
    /** Creates a new instance of InsertRecord */
    public InsertRecord() {
    }
    public Scanner sc = new Scanner(System.in);
    
    public void insert(Connection con){
    	ArrayList<String> columnNames = new ArrayList<String>();
    	ResultSet resultSet;
    	try{
		DatabaseMetaData dbmd = con.getMetaData();
//		resultSet = dbmd.getColumns(null, null, table, null);
//		while(resultSet.next()){
//			 String columnName = resultSet.getString("COLUMN_NAME");
//	      System.out.println("column name=" + columnName);
//		}
		
		System.out.println("Enter the record type: ");
		String type = sc.next();
		switch (type) {
		case "product":
			String prod = "product";
			resultSet = dbmd.getColumns(null, null, type, null);
			
			while(resultSet.next()){
				 String columnName = resultSet.getString("COLUMN_NAME");
				 columnNames.add(columnName);
		      System.out.println("column name=" + columnName);
			}
			insertRow(con, type, columnNames); 
			break;
		case "employee":
			String emp = "employee";
			resultSet = dbmd.getColumns(null, null, type, null);
			
			while(resultSet.next()){
				 String columnName = resultSet.getString("COLUMN_NAME");
				 columnNames.add(columnName);
		      System.out.println("column name=" + columnName);
			}
			insertRow(con, type, columnNames); 
			break;
		case "supplier":
			String sup = "supplier";
			resultSet = dbmd.getColumns(null, null, type, null);
			
			while(resultSet.next()){
				 String columnName = resultSet.getString("COLUMN_NAME");
				 columnNames.add(columnName);
		      System.out.println("column name=" + columnName);
			}
			insertRow(con, type, columnNames);
			break;
		case "customer":
			String cust = "customer";
			resultSet = dbmd.getColumns(null, null, type, null);
			
			while(resultSet.next()){
				 String columnName = resultSet.getString("COLUMN_NAME");
				 columnNames.add(columnName);
		      System.out.println("column name=" + columnName);
			}
			insertRow(con, type, columnNames);
			break;
		}
    	}
    	catch(Exception io){
    		System.out.println("error" + io);
    	}
    }
    private void insertRow(Connection con, String p, ArrayList<String> l){
    	ArrayList<String> columnValues = new ArrayList<String>();
    	
    	for(String column: l){
    		System.out.println("Enter " + column);
    		String value = "";
   	 		value = sc.next();
   	 		value += sc.nextLine();
   	 		columnValues.add(value);
    	}
    	try {
            // insert
    		String insertString = "('";
            Statement insertStmt = con.createStatement();
            for(int i = 0; i < columnValues.size() -1; i++)
            	insertString += columnValues.get(i) +"', '";
            insertString += columnValues.get(columnValues.size() -1) + "')";
            String insertSQL = "insert into " + p + " values " + insertString;
            System.out.println(insertSQL);
            //String insertSQL = " Insert into " + p +"('" + columnValues.get(1) + "', '" + columnValues.get(2) + "', '" + columnValues.get(1) + "', '" + contact + "', '" + phoneNum + "' " + ", 0)";
            int res = insertStmt.executeUpdate(insertSQL);
            System.out.println("New " + p + " added");
            // You May need to uncomment if Autocommit is not set
            //con.commit();
            insertStmt.close();
       }catch (Exception io) {
                System.out.println("error"+io);
       };   
    	
    }
    
//     public  void insertCustomer(Connection con) {
//    	 System.out.println("Enter customer name ");
//    	 String name = sc.next();
//    	 System.out.println("Enter customer id ");
//    	 String id = sc.next();
//    	 System.out.println("Enter customer address ");
//    	 String address = sc.next();
//    	 System.out.println("Enter customer contact person ");
//    	 String contact = sc.next();
//    	 System.out.println("Enter customer contact number ");
//    	 String phoneNum = sc.next();
//    	 
//        try {
//            // insert
//            Statement insertStmt = con.createStatement();
//            String insertSQL = " Insert into customer values ('" + id + "', '" + name + "', '" + address + "', '" + contact + "', '" + phoneNum + "' " + ", 0)";
//            int res = insertStmt.executeUpdate(insertSQL);
//            System.out.println("New customer added");
//            // You May need to uncomment if Autocommit is not set
//            //con.commit();
//            insertStmt.close();
//       }catch (Exception io) {
//                System.out.println("error"+io);
//       };   
//  
     }

