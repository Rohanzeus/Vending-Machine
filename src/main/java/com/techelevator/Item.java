package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Item {
    private String name;
    private double price;
    private Map<String, Double> items = new HashMap<>();
    File path = new File("vendingmachine.csv");

    public Item(String name, double price, Map<String, Double> items){
        this.name = name;
        this.price = price;
        this.items = items;
    }

    public Map<String, Double> getItemList(){
        try {
            Scanner vendingInventory = new Scanner(path);
            while (vendingInventory.hasNextLine()){
                String itemLine = vendingInventory.nextLine();
                String[] item = itemLine.split("\\|");
                items.put(item[0], Double.valueOf(item[2]));
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

    public Map<String, Double> getItems() {
        return items;
    }
}
