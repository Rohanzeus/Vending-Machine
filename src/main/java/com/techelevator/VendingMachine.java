package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class VendingMachine {
    File path = new File("vendingmachine.csv");
    Map<String, Item> itemsInMap = new HashMap<>();

    public Map<String, Item> getItemListSplit(){

        try {
            Scanner vendingInventory = new Scanner(path);
            while (vendingInventory.hasNextLine()){
                String[] itemDescription;
                itemDescription = vendingInventory.nextLine().split("\\|");
                String slot = itemDescription[0].toLowerCase(Locale.ROOT);
                String name = itemDescription[1];
                String type = itemDescription[3];
                Double price = Double.parseDouble(itemDescription[2]);
               Item newItem = new Item(slot,name,price,type);
               itemsInMap.put(slot, newItem);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }return itemsInMap;
    }

    public Map<String, Item> getItemsInMap() {
        return itemsInMap;
    }
}
