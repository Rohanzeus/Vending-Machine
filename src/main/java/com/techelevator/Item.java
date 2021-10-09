package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Item {
    private String name;
    private double price;
    private String slot;
    private String type;
    private int stock;
    private Map<String, Item> items;
    File path = new File("C:\\Users\\Student\\workspace\\capstone\\java-capstone-module-1-team-12\\vendingmachine.csv");

    public Item(String slot, String name, double price, String type, int stock) {
        this.name = name;
        this.price = price;
        this.slot = slot;
        this.type = type;
        this.stock = stock;
    }

    public Item(String name, double price, Map<String, Double> items) {
    }

    //    public List<String> getItemList() {
//        List<String> itemList = null;
//
//        try {
//            Scanner vendingFile = new Scanner(path);
//            while (vendingFile.hasNextLine()) {
//                String line = vendingFile.nextLine();
//                itemList.add(line);
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }return itemList;
//    }
//    public void returnA1 (){
//        return 1;
//    }
    public Map<String, Item> getItemList(){
        try {
            Scanner vendingInventory = new Scanner(path);
            while (vendingInventory.hasNextLine()){
                String itemLine = vendingInventory.nextLine();
                String[] itemDescription;
                itemDescription = vendingInventory.nextLine().split("\\|");
                double price = Double.parseDouble(itemDescription[2]);
                items.put(itemDescription[0], new Item(itemDescription[0],itemDescription[1], price, itemDescription[3], 5));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }return items;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Map<String, Item> getItems() {
        return items;
    }
}
