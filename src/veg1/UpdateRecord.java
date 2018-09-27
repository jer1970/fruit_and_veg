package veg1;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateRecord {
	/** Creates a new instance of UpdateRecord */
	public UpdateRecord() {
	}

	public Scanner sc = new Scanner(System.in);

	public void update(Connection con) {
		System.out.println("Enter the record type: ");
		String type = sc.next();
		switch (type) {
		case "product":
			String table = "product";
			updateProduct(con, table);
			break;
		case "employee":
			String table1 = "employee";
			updateEmployee(con, table1);
			break;
		case "supplier":
			updateSupplier(con);
			break;
		case "customer":
			//updateCustomer(con);
			break;
		}
	}

	private void updateProduct(Connection con, String t) {
		System.out.println("Enter product id: ");
		String id = sc.next();
		System.out.println("Enter new price: ");
		String price = sc.next();
		try {
			// update
			Statement updateStmt = con.createStatement();
			String updateSQL = " Update product set UnitPrice = '" + price + "' where ProductNum = '" + id + "'";
			updateStmt.executeUpdate(updateSQL);
			System.out.println("product updated");
			// You May need to uncomment if Autocommit is not set
			// con.commit();
			updateStmt.close();
		} catch (Exception io) {
			System.out.println("error" + io);
		}
		;
	}// updateProduct

	private void updateEmployee(Connection con, String t) {
		char choice;
		try {
			// update
			Statement updateStmt = con.createStatement();
			System.out.println("Enter employee id: ");
			String id = sc.next();
			System.out.println("Update name? y/n: ");
			choice = sc.next().charAt(0);
			if (choice == 'y') {
				System.out.println("Enter new name:");
				String name = "";
				name = sc.nextLine();
				name += sc.nextLine();
				String updateSQL = " Update employee set employeeName = '" + name + "' where employeeID = " + id + "";
				updateStmt.executeUpdate(updateSQL);
				System.out.println("name updated");
			}
			System.out.println("Update address? y/n: ");
			choice = sc.next().charAt(0);
			if (choice == 'y') {
				System.out.println("Enter new address:");
				String address = "";
				address = sc.nextLine();
				address += sc.nextLine();
				String updateSQL = " Update employee set employeeAddress = '" + address + "' where employeeID = '" + id
						+ "'";
				updateStmt.executeUpdate(updateSQL);
				System.out.println("address updated");
			}
			System.out.println("Update role? y/n: ");
			choice = sc.next().charAt(0);
			if (choice == 'y') {
				System.out.println("Enter new role:");
				String role = sc.next();
				String updateSQL = " Update employee set employeeRole = '" + role + "' where employeeID = '" + id + "'";
				updateStmt.executeUpdate(updateSQL);
				System.out.println("role updated");
			}
			System.out.println("Update department? y/n: ");
			choice = sc.next().charAt(0);
			if (choice == 'y') {
				System.out.println("Enter new department:");
				String department = sc.next();
				String updateSQL = " Update employee set departmentName = '" + department + "' where employeeID = '" + id + "'";
				updateStmt.executeUpdate(updateSQL);
				System.out.println("name updated");
			}
			// You May need to uncomment if Autocommit is not set
			// con.commit();
			updateStmt.close();
		} catch (Exception io) {
			System.out.println("error" + io);
		}
		;
	}
	private void updateSupplier(Connection con) {
		char choice;
		try {
			// update
			Statement updateStmt = con.createStatement();
			System.out.println("Enter supplier id: ");
			String id = sc.next();
			System.out.println("Update name? y/n: ");
			choice = sc.next().charAt(0);
			if (choice == 'y') {
				System.out.println("Enter new name:");
				String name = "";
				name = sc.nextLine();
				name += sc.nextLine();
				String updateSQL = " Update supplier set supplierName = \"" + name + "\" where supplierID = '" + id + "'";
				updateStmt.executeUpdate(updateSQL);
				System.out.println("name updated");
			}
			System.out.println("Update address? y/n: ");
			choice = sc.next().charAt(0);
			if (choice == 'y') {
				System.out.println("Enter new address:");
				String address = "";
				address = sc.nextLine();
				address += sc.nextLine();
				String updateSQL = " Update supplier set supplierAddress = '" + address + "' where supplierID = '" + id	+ "'";
				updateStmt.executeUpdate(updateSQL);
				System.out.println("address updated");
			}
			System.out.println("Update contact person? y/n: ");
			choice = sc.next().charAt(0);
			if (choice == 'y') {
				System.out.println("Enter new contact person:");
				String contact = "";
				contact = sc.nextLine();
				contact += sc.nextLine();
				String updateSQL = " Update supplier set SupplierContactPerson = '" + contact + "' where supplierID = '" + id + "'";
				updateStmt.executeUpdate(updateSQL);
				System.out.println("contact updated");
			}
			System.out.println("Update contact number? y/n: ");
			choice = sc.next().charAt(0);
			if (choice == 'y') {
				System.out.println("Enter new contact number:");
				String contactNumber = sc.next();
				String updateSQL = " Update supplier set supplierContactNumber = '" + contactNumber + "' where supplierID = '" + id + "'";
				updateStmt.executeUpdate(updateSQL);
				System.out.println("contact number updated");
			}
			System.out.println("Update current balance? y/n: ");
			choice = sc.next().charAt(0);
			if (choice == 'y') {
				System.out.println("Enter new balance:");
				String balance = sc.next();
				String updateSQL = " Update supplier set supplierCurrentBalance = '" + balance + "' where supplierID = '" + id + "'";
				updateStmt.executeUpdate(updateSQL);
				System.out.println("balance updated");
			}
			// You May need to uncomment if Autocommit is not set
			// con.commit();
			updateStmt.close();
		} catch (Exception io) {
			System.out.println("error" + io);
		}
		;
	}
}
