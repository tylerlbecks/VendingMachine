package com.TylerEvan;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;

public class VendingMachine {

    private BigDecimal balance = new BigDecimal("0.00");
    private BigDecimal totalCost = new BigDecimal("0.00");
    public Map<String, Stack<Items>> inventory;
    public List<String> itemStringList = new ArrayList<String>();

//    public VendingMachine() throws FileNotFoundException {
//        InventorySlot inventoryFun = new InventorySlot();
//    }

    public String returnChange() {					//RETURNING CHANGE AT END
        int quarterCount = 0;
        int dimeCount = 0;
        int nickelCount = 0;
        String changeReturned = "";

        while (balance.compareTo(new BigDecimal("0")) > 0) {
            if (balance.compareTo(new BigDecimal("0.25")) >= 0) {
                balance = balance.subtract(new BigDecimal("0.25"));
                quarterCount++;
            } else if (balance.compareTo(new BigDecimal("0.10")) >= 0) {
                balance = balance.subtract(new BigDecimal("0.10"));
                dimeCount++;
            } else if (balance.compareTo(balance.subtract(new BigDecimal("0.05"))) >= 0) {
                balance = balance.subtract(new BigDecimal("0.05"));
                nickelCount++;

            }

        }
        changeReturned = ("\nYour change is: " + quarterCount + " Quarter(s), " + dimeCount + " Dime(s), " + nickelCount
                + " Nickel(s) \n" + "Your new balance is: $" + balance);
        // balance = new BigDecimal(0);
        return changeReturned;
    }
    
    public static Map<String, Stack<Items>> inventoryMap = new TreeMap<>();


    
	public void inventorySorter(Map<String, Stack<Items>> inventoryMap) throws FileNotFoundException {

        File inventoryFile = new File("vendingmachine.csv");

        int counter = 0;

        @SuppressWarnings("resource")
		Scanner reader = new Scanner(inventoryFile);

            while(reader.hasNextLine()) {
                String currentLine = reader.nextLine();
                String[] splitArray = currentLine.split("\\|");
                Stack<Items> itemsStack = new Stack<>();

                counter = counter + 1;

                if(splitArray[0].contains("A")) {
                    for(int i = 0; i < 5; i++) {
                        itemsStack.push(new Items(splitArray[1], new BigDecimal(splitArray[2])));
                    }
                }else if(splitArray[0].contains("B")) {
                    for (int i = 0; i < 5; i++) {
                        itemsStack.push(new Items(splitArray[1], new BigDecimal(splitArray[2])));
                    }
                }else if(splitArray[0].contains("C")) {
                    for (int i = 0; i < 5; i++) {
                        itemsStack.push(new Items(splitArray[1], new BigDecimal(splitArray[2])));
                    }
                }else if(splitArray[0].contains("D")) {
                    for (int i = 0; i < 5; i++) {
                        itemsStack.push(new Items(splitArray[1], new BigDecimal(splitArray[2])));
                    }
                }
                inventoryMap.put(splitArray[0], itemsStack);
            }
        inventory =  inventoryMap;
    }
	
	public String consumeMessage() {
		String message = "";
		if (inventoryMap.keySet().contains("A")) {
			message.equals("Crunch Crunch, Yum!");
		} else if (inventoryMap.keySet().contains("B")) {
			message.equals("Munch Munch, Yum!");
		} else if (inventoryMap.keySet().contains("C")) {
			message.equals("Glug Glug, Yum!");
		} else {
			message.equals("Chew Chew, Yum!");
		}
		return message;
	}

    public Map<String, Stack<Items>> getInventory() {
        return inventory;
    }
    
    public BigDecimal getTotalCost() {
    	return totalCost;
    }
    
    public void addToTotalCost(BigDecimal itemCost) {
    	totalCost = totalCost.add(itemCost);
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void addToBalance(BigDecimal amountSubmitted) {
        balance = balance.add(amountSubmitted);
    }
    
    public void addToStringList(String newItem) {
    	itemStringList.add(newItem);
    }
    
    public String getItemString(){
    	String itemsCommaSeparated = String.join(", ", itemStringList);
    	return itemsCommaSeparated;
    }

}