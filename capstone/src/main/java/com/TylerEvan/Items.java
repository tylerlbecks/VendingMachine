package com.TylerEvan;


import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*Properties:
	-Name
	(-Price)?
	-Category/Type
	-Sound
*/
public class Items {

    private String itemName;
    private BigDecimal price;

    public Items(String itemName, BigDecimal price) {
        this.itemName = itemName;
        this.price = price;
    }

    public String getItemName() {
        return itemName;
    }                           //Getters & Setters

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }               //Getters & Setters

    public String toString() {
        return itemName + " , " + price;
    }


    public String makeSound() {
        return null;
    }
    
}
