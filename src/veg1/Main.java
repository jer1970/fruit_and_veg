package veg1;

import java.sql.Connection;

public class Main {
	public static void main(String[] args) {
		Connect_db db = new Connect_db();
		
		Connection con = db.connect();
		Menu menu = new Menu();
		menu.displayMenu(con);
	}
}