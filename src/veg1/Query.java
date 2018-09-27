package veg1;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.util.Scanner;

public class Query {
	public Statement statement = null;
	public ResultSet resultSet;
	public ResultSetMetaData metaData = null;
	public Scanner sc = new Scanner(System.in);
	
	public void selectAll(Connection con) {
		System.out.println("Enter table name: ");
   	 String table = sc.next();
		try {
			statement = con.createStatement();
			try{
			resultSet = statement.executeQuery("SELECT * FROM " + table );
			metaData = resultSet.getMetaData();
			int numberOfColumns = metaData.getColumnCount();
			System.out.println(table + " List:\n");

			for (int i = 1; i <= numberOfColumns; i++)
				System.out.print(metaData.getColumnName(i) + " \t");
			System.out.println();

			while (resultSet.next()) {
				for (int i = 1; i <= numberOfColumns; i++)
					System.out.print(resultSet.getObject(i) + " \t\t");
				System.out.println();
			}
			}catch(SQLSyntaxErrorException e){
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
