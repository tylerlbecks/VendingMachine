package com.TylerEvan;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;


//SUPER CLASS
//Menu functionality!
/*
 * -Display
	-Get Input
	-Validate Input
	-Add a quit option, vending machine will restock
	-Multiple people should be able to use the machine in one iteration of the program

	-Responsible for asking the user for money

 */
public class Menu {

	boolean exit;
	boolean done = false;
	VendingMachine machine;
	
	public Menu() throws FileNotFoundException {
		this.machine = new VendingMachine();
	}
	
	public void printApplicationBanner() {
		System.out.println("**********************");
		System.out.println("***VENDO-MATIC 5000***");
		System.out.println("***by Umbrella Corp***");
		System.out.println("**********************");
	}
	
	private void printMainMenu() {
		logln("");
		logln("");
		logln("");
		logln("*   MAIN MENU   *");
		logln("");
		logln("1) Display Vending Machine Items");
		logln("2) Purchase An Item");
		logln("Q) Quit");
		logln("");
	}
	
	public void runMainMenu() {
		while(!exit) {
			printMainMenu();
			getInputMainMenu();
		}
	}
	
	@SuppressWarnings("resource")
	private String getInputMainMenu() {
		Scanner mainMenuInput = new Scanner(System.in);
		String choice = null;
		while(!done) {
			try {
				log("Enter your selection >>> ");
				choice = mainMenuInput.nextLine();
				logln("___________________________");
				logln("");
			if(choice.toLowerCase().equals("q")) {
				logln("");
				logln("Thank you for shopping with us!  Have a good day!");		//TODO If there is a balance, display message of amount given back.
				logln("");														//Vending Machine is 're-stocked'
				done = true;
				exit = true;
			}if(choice.equals("1")) {
				runVendingMachineItems();
			}if(choice.equals("2")) {
				runPurchasingProcessMenu();
			}else if(!choice.equals("1") && !choice.equals("2") && !choice.toLowerCase().equals("q")) {
				logln("Selection not valid. Please enter a valid selection.");
				logln("");
			}
			} catch (Exception ex) {
				
			}
		}
		
		logln("");
		return choice;
	}
	
	public void runVendingMachineItems() throws FileNotFoundException {
		while(!exit) {
			printVendingMachineItems();
			getInputVendingMachineItems();
		}
	}
	
	private void printVendingMachineItems() {
		logln("");
		logln("");
		logln("");
		logln("*   VENDING MACHINE ITEMS   *");
		logln("");		
		printItemsList();
		logln("");
		logln("1) Purchase An Item");
		logln("B) Back to Program");
		logln("");
	}
	
	 public String printItemsList() {
 		String itemList = "";
 		File file = new File("vendingmachine.csv");
 		try(Scanner input = new Scanner(file)){
 		while(input.hasNextLine()) {
 			String line = input.nextLine();
 			
 			itemList = line;
 			logln(itemList);
 		}
 		
 		} catch(Exception ex){
 	
 		}
 		return itemList;
	 }
	
	@SuppressWarnings("resource")
	private String getInputVendingMachineItems() {
		Scanner input = new Scanner(System.in);
		String choice = null;
		while(!done) {
			try {
				log("Enter your selection >>> ");
				choice = input.nextLine();
				logln("___________________________");
				logln("");
			if(choice.equals("1")) {
				runPurchasingProcessMenu();
			}if(choice.toLowerCase().equals("b")) {
				runMainMenu();
				logln("");
				logln("");
				logln("");
				done = true;
			}else if(!choice.equals("1") && !choice.toLowerCase().equals("b")) {
				logln("Selection not valid. Please enter a valid selection.");
				logln("");
			}
			} catch (Exception ex) {
				
			}
		}
		
		logln("");
		return choice;
}
	
	public void runPurchasingProcessMenu() {
		while(!exit) {
			printPurchasingProcessMenu();
			getPurchasingProcessMenu();
		}
	}
	
	private void printPurchasingProcessMenu() {
		logln("");
		logln("");
		logln("");
		logln("*   PURCHASING PROCESS MENU   *");
		logln("");									
		logln("1) Feed Money");
		logln("2) Select Product");
		logln("3) Finish Transaction");
		logln("B) Back to Main");
		logln("");
		
	}
	
	@SuppressWarnings("resource")
	private String getPurchasingProcessMenu() {
		Scanner input = new Scanner(System.in);
		String choice = null;
		while(!done) {
			try {
				log("Enter your selection >>> ");
				choice = input.nextLine();
				logln("___________________________");
				logln("");
			if(choice.equals("1")) {
				runFeedMoney();
			}if(choice.equals("2")) {
				runSelectProduct();
			}if(choice.equals("3")) {
				runFinishTransaction();
			}if(choice.toLowerCase().equals("b")) {
				runMainMenu();
				logln("");
				logln("");
				logln("");
				done = true;
			}else if(!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.toLowerCase().equals("b")) {
				logln("Selection not valid. Please enter a valid selection.");
				logln("");
			}
			} catch (Exception ex) {
				
			}
		}
		
		logln("");
		return choice;
}
	
	public void runFeedMoney() throws FileNotFoundException {
		while(!exit) {
			printFeedMoney();
			getFeedMoney();
		}
	}
	
	private void printFeedMoney() throws FileNotFoundException {
		logln("");
		logln("");
		logln("");
		logln("*   FEED MONEY   *");
		logln("");
		logln("Total Cost: " + machine.getTotalCost());
		logln("Current Balance: " + machine.getBalance());		
		logln("How much would you like to add?");
		logln("");
		
	}
	
	@SuppressWarnings("resource")
	private String getFeedMoney() throws FileNotFoundException {
		Scanner input = new Scanner(System.in);
		String choice = null;
			try {
				log("Enter dollar amount to add >>> ");
				choice = input.nextLine();
				logln("____________________________________");
				logln("");
				BigDecimal choiceBigDec = new BigDecimal(choice);
				machine.addToBalance(choiceBigDec);
				logln("");
				logln("Amount added to current balance.");
				logln("New current balance: " + machine.getBalance());
				logln("");
				runOptions();
			} catch (Exception ex) {
		}
		logln("");
		return choice;
}
	
	public void runOptions() throws FileNotFoundException {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		log("Would you like to add more? 'Y/N' ");
		String inputString = input.nextLine();
		logln("____________________________________");
		logln("");
		if(inputString.toLowerCase().equals("y")) {
			runFeedMoney();
		}else if(inputString.toLowerCase().equals("n")) {
			runPurchasingProcessMenu();
		}
	}
	
	public void runSelectProduct() throws Exception {
		while(!exit) {
			printSelectProduct();
			getSelectProduct();
		}
	}
	
	private void printSelectProduct() throws FileNotFoundException {
		logln("");
		logln("");
		logln("");
		logln("*   SELECT PRODUCT   *");
		logln("");
		printItemsList();
		logln("");
		//TODO DISPLAY LIST OF PURCHASABLE ITEMS, ARRAYLIST OF items! INCLUDE the quantity left in machine
		logln("Total Cost: " + machine.getTotalCost());			//TODO Display total cost of items added to transaction
		logln("Current Balance: " + machine.getBalance());
		logln("Which item would you like to purchase?");
		logln("B) Back to Purchasing Process Menu");
		logln("");
		
	}
	
	@SuppressWarnings({ "resource" })
	private String getSelectProduct() throws Exception {
		Scanner input = new Scanner(System.in);
		String choice = null;
		while(!done) {
				log("Enter the code of the item or 'B' to go back >>> ");
				choice = input.nextLine();
				logln("____________________________________________________");
				logln("");
			if(choice.toLowerCase().equals("b")) {
				runPurchasingProcessMenu();
				logln("");
				logln("");
				logln("");
				done = true;
			}if(choice.equals("a1") || choice.equals("A1")) {
				machine.addToStringList("Potato Crisps");
				machine.addToTotalCost(new BigDecimal("3.05"));
				runAskAgain();
				done = true;
			}if(choice.equals("a2") || choice.equals("A2")) {
				machine.addToStringList("Stackers");
				machine.addToTotalCost(new BigDecimal("1.45"));
				runAskAgain();
				done = true;
			}if(choice.equals("a3") || choice.equals("A3")) {
				machine.addToStringList("Grain Waves");
				machine.addToTotalCost(new BigDecimal("2.75"));
				runAskAgain();
				done = true;
			}if(choice.equals("a4") || choice.equals("A4")) {
				machine.addToStringList("Cloud Popcorn");
				machine.addToTotalCost(new BigDecimal("3.65"));
				runAskAgain();
				done = true;
			}if(choice.equals("b1") || choice.equals("B1")) {
				machine.addToStringList("Moonpie");
				machine.addToTotalCost(new BigDecimal("1.80"));
				runAskAgain();
				done = true;
			}if(choice.equals("b2") || choice.equals("B2")) {
				machine.addToStringList("Cowtales");
				machine.addToTotalCost(new BigDecimal("1.50"));
				runAskAgain();
				done = true;
			}if(choice.equals("b3") || choice.equals("B3")) {
				machine.addToStringList("Wonka Bar");
				machine.addToTotalCost(new BigDecimal("1.50"));
				runAskAgain();
				done = true;
			}if(choice.equals("b4") || choice.equals("B4")) {
				machine.addToStringList("Crunchie");
				machine.addToTotalCost(new BigDecimal("1.75"));
				runAskAgain();
				done = true;
			}if(choice.equals("c1") || choice.equals("C1")) {
				machine.addToStringList("Cola");
				machine.addToTotalCost(new BigDecimal("1.25"));
				runAskAgain();
				done = true;
			}if(choice.equals("c2") || choice.equals("C2")) {
				machine.addToStringList("Dr. Salt");
				machine.addToTotalCost(new BigDecimal("1.50"));
				runAskAgain();
				done = true;
			}if(choice.equals("c3") || choice.equals("C3")) {
				machine.addToStringList("Mountain Melter");
				machine.addToTotalCost(new BigDecimal("1.50"));
				runAskAgain();
				done = true;
			}if(choice.equals("c4") || choice.equals("C4")) {
				machine.addToStringList("Heavy");
				machine.addToTotalCost(new BigDecimal("1.50"));
				runAskAgain();
				done = true;
			}if(choice.equals("d1") || choice.equals("D1")) {
				machine.addToStringList("U-Chews");
				machine.addToTotalCost(new BigDecimal("0.85"));
				runAskAgain();
				done = true;
			}if(choice.equals("d2") || choice.equals("D2")) {
				machine.addToStringList("Little League Chew");
				machine.addToTotalCost(new BigDecimal("0.95"));
				runAskAgain();
				done = true;
			}if(choice.equals("d3") || choice.equals("D3")) {
				machine.addToStringList("Chiclets");
				machine.addToTotalCost(new BigDecimal("0.75"));
				runAskAgain();
				done = true;
			}if(choice.equals("d4") || choice.equals("D4")) {
				machine.addToStringList("Triplemint");
				machine.addToTotalCost(new BigDecimal("0.75"));
				runAskAgain();
				done = true;
			}else{
				logln("");
				logln("Invalid selection.  Please try again.");
				getSelectProduct();
				done = true;
			}
			
		}
		
		logln("");
		return choice;
}
	public void runAskAgain() throws Exception {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		logln("");
		logln("Item added to your transaction!");//TODO Add the ITEM TO THE TRANSACTION, in vending?
		logln("Your items: " + machine.getItemString());
		logln("New Total Cost: " + machine.getTotalCost());
		logln("Current balance: " + machine.getBalance());			
		logln("");
		log("Would you like to purchase another? 'Y/N' ");
		String inputString = input.nextLine();
		logln("____________________________________________");
		logln("");
		if(inputString.toLowerCase().equals("y")) {
			runSelectProduct();
		}if(inputString.toLowerCase().equals("n")) {
			runPurchasingProcessMenu();
		}else if(!inputString.toLowerCase().equals("y") && !inputString.toLowerCase().equals("n")) {
			logln("Invalid selection.  Please try again.");
			runAskAgain();
		}
	}
	
	public void runFinishTransaction() {
		while(!exit) {
			printFinishTransaction();
			getFinishTransaction();
		}
	}
	
	private void printFinishTransaction() {
		logln("");
		logln("");
		logln("");
		logln("*   FINISH TRANSACTION   *");
		logln("");	
		logln("Your Items: " + machine.getItemString());
		logln("Total Cost: " + machine.getTotalCost());
		logln("Current balance: " + machine.getBalance());			
		logln("");
		logln("Would you like to finish your transaction?");
		logln("B) Back to Purchasing Process Menu");
		logln("");
	}
	
	@SuppressWarnings("resource")
	private String getFinishTransaction() {
		Scanner input = new Scanner(System.in);
		String choice = null;
		while(!done) {
			try {
				log("Enter 'Y/N' or 'B' to go back >>> ");
				choice = input.nextLine();
				logln("_____________________________________");
				logln("");
			if(choice.toLowerCase().equals("b")) {
				runPurchasingProcessMenu();
				logln("");
				logln("");
				logln("");
				done = true;
			}if(choice.toLowerCase().equals("y")) {
				if(machine.getBalance().doubleValue() >= machine.getTotalCost().doubleValue()) {
					double amountReturned = machine.getBalance().doubleValue() - machine.getTotalCost().doubleValue();
					logln("");
					logln("Thank you for shopping with us!  Have a good day!");
					logln("");
					logln("Please take your change!" + "$" + amountReturned);		//If there is a balance, display message of amount given back.
					logln("Enjoy your items: " + machine.getItemString());
					machine.getBalance().equals(BigDecimal.ZERO);
					machine.getTotalCost().equals(BigDecimal.ZERO);
					logln("");
					logln("------------>>>");
					logln("");
					logln("");
					logln("");
					logln("");
					printApplicationBanner();
					runMainMenu();
					done = true;
					
				} else if(machine.getBalance().doubleValue() < machine.getTotalCost().doubleValue()){
					logln("");
					logln("You do not have enough money!  Please insert more funds.");
					runFeedMoney();
					//If the user selects yes, program will need to do the following:
					/*
					 * 	i. The customer’s money is returned using nickels, dimes, and quarters
							(using the smallest amount of coins possible).
						ii. The machine’s current balance should be updated to $0 remaining.
						iii. The item(s) will be “consumed” and a message printed depending on the item type:
							1. All chip items will return “Crunch Crunch, Yum!”
							2. All candy items will return “Munch Munch, Yum!”
							3. All drink items will return “Glug Glug, Yum!”
							4. All gum items will return “Chew Chew, Yum!”
					 */
				}
				}else if(choice.toLowerCase().equals("n")) {
					runPurchasingProcessMenu();						//Still keep the TRANSACTION ITEMS and BALANCE stored.
				}
			} catch (Exception ex) {
				
			}
		}
		
		logln("");
		return choice;
}
	
	public static void logln(String message) {
		System.out.println(message);
	}

	public static void log(String message) {
		System.out.print(message);
	}

}
