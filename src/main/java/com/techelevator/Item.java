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
    File path = new File("vendingmachine.csv");

    public Item(String slot, String name, double price, String type, int stock) {
        this.name = name;
        this.price = price;
        this.slot = slot;
        this.type = type;
        this.stock = stock;
    }

    public Item(String name, double price, Map<String, Double> items) {
    }

        public List<String> displayFullList() {
            List<String> itemsAsList = new ArrayList<>();
            try {
                Scanner inputFile = new Scanner(path);
                while (inputFile.hasNextLine()) {
                    String fileLine = inputFile.nextLine();
                    itemsAsList.add(fileLine);
                }
            } catch (Exception e) {
                System.out.println("woops");
            }return itemsAsList;
        }
    public Map<String, Item> getItemList(){
        try {
            Scanner vendingInventory = new Scanner(path);
            while (vendingInventory.hasNextLine()){
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
