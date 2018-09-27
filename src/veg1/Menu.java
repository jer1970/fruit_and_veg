package veg1;

import java.sql.Connection;
import java.util.Scanner;

public class Menu {
	public Query query;
	public UpdateRecord1 update;
	public InsertRecord insert;
	public DeleteRecord delete;
	
	public void displayMenu(Connection con){
	boolean goOn = true;
	int option;
	Scanner sc = new Scanner(System.in);
	do{
		System.out.println("\n\t\tInventory/Shopping App");
		System.out.println("\t\t\tMenu");
		System.out.println("\t\tPlease select an option.");
		System.out.println("\t\t1: Display a table");
		System.out.println("\t\t2: Update a record");
		System.out.println("\t\t3: Add a new record");
		System.out.println("\t\t4: Delete a record");
		System.out.println("\t\t5: Quit");
		option = sc.nextInt();
		switch(option){
		case (1): 
			query = new Query();
			query.selectAll(con);
			break;
		case(2):
			update = new UpdateRecord1();
			update.update(con);
			break;
		case(3):
			insert = new InsertRecord();
			insert.insert(con);
			break;
		case(4):
			delete = new DeleteRecord();
			delete.delete(con);
			break;
		case(5):
			goOn = false;
		break;
		}
	}while(goOn);
	System.out.println("\t\tGoodBye");
	}
}
