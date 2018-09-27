package veg1;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateRecord1 {
	public Scanner sc = new Scanner(System.in);

	public void update(Connection con) {
		// ResultSet resultSet;
		// DatabaseMetaData dbmd = con.getMetaData();
		// resultSet = dbmd.getColumns(null, null, table, null);
		// while(resultSet.next()){
		// String columnName = resultSet.getString("COLUMN_NAME");
		// System.out.println("column name=" + columnName);
		// }

		String[] product = { "ProductNum", "ProductName", "ProductQuantity", "UnitPrice", "SupplierId" };
		String[] employee = { "EmployeeId", "EmployeePPSN", "EmployeeName", "EmployeeAddress", "EmployeeRole",
				"DepartmentName" };
		String[] supplier = { "SupplierId", "SupplierName", "SupplierAddress", "SupplierContactperson",
				"SupplierContactNumber", "SupplierCurrentBalance" };
		String[] customer = { "CustomerId", "CustomerName", "CustomerAddress", "CustomerContactPerson",
				"CustomerContactNum", "CustomerBalance" };

		System.out.println("Enter the record type: ");
		String type = sc.next();
		switch (type) {
		case "product":
			String prod = "product";
			updateTable(con, prod, product);
			break;
		case "employee":
			String emp = "employee";
			updateTable(con, emp, employee);
			break;
		case "supplier":
			String sup = "supplier";
			updateTable(con, sup, supplier);
			break;
		case "customer":
			String cust = "customer";
			updateTable(con, cust, customer);
			break;
		}
	}

	private void updateTable(Connection con, String p, String[] t) {
		char choice;
		System.out.println("Enter " + t[0]);
		String id = sc.next();
		for (int i = 1; i < t.length; i++) {
			System.out.println("Update " + t[i] + "? y/n: ");
			choice = sc.next().charAt(0);
			if (choice == 'y') {
				System.out.println("Enter " + t[i]);
				String var = "";
				var = sc.nextLine();
				var += sc.nextLine();
				try {
					// update
					Statement updateStmt = con.createStatement();
					String updateSQL = " Update " + p + " set " + t[i] + " = '" + var + "' where " + t[0] + " = '" + id
							+ "'";
					updateStmt.executeUpdate(updateSQL);
					System.out.println(t[i] + " updated");
					// You May need to uncomment if Autocommit is not set
					// con.commit();
					updateStmt.close();
				} catch (Exception io) {
					System.out.println("error" + io);
				}
			}
		}
	}// updateProduct
}
