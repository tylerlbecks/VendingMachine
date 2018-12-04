package com.TylerEvan;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Program {

	
	public static void main(String[] args) throws FileNotFoundException {
		Menu menu = new Menu();
		menu.printApplicationBanner();
		menu.runMainMenu();
	}



	
//	public void display() throws FileNotFoundException {
//		VendingMachine main = new VendingMachine();
//		SalesReport logFile = new SalesReport();
//		
//		while(true) {
//			String choice = (String)
//		}
//	}
	
	public List<Items> currentItems(Items purchaseItem) {
		List<Items> currentItems = new ArrayList<Items>();
		currentItems.add(purchaseItem);
		return currentItems;
}
	
	
}
