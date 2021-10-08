package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Item {
    private String type;
    private String price;
    private String quantity;
    private String position;
    private String name;

    public Item(String type, String price, String quantity, String position, String name){
        this.type = type;
        this.price = price;
        this.quantity = quantity;
        this.position = position;
        this.name = name;
    }

    //Methods
//    public List<String> placingItemPosition(){
//        File itemListFilePath = new File("vendingmachine.cvs");
//        List<String> itemPositionList = new ArrayList<>();
//        try {
//            Scanner itemList = new Scanner(itemListFilePath);
//            while (itemList.hasNextLine()){
//                String itemLine = itemList.nextLine();
//                String[] items = itemLine.split("\\|");
//                itemPositionList.add(items[0]);
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }return position = itemPositionList;
//    }

    public void itemsListed(){
        File itemListFilePath = new File("vendingmachine.cvs");
        try{
            Scanner itemList = new Scanner(itemListFilePath);

            while (itemList.hasNextLine()){
                String itemLine = itemList.nextLine();
                String[] items = itemLine.split("\\|");
                this.position = items[0];
                this.name = items[1];
                this.price = items[2];
                this.type = items[3];
            }
        } catch (FileNotFoundException e) {

        }
    }


    public String getType() {
        return type;
    }

    public String getPrice() {
        return price;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getPosition() {
//        File itemListFilePath = new File("vendingmachine.cvs");
//        List<String> itemPositionList = new ArrayList<>();
//        try {
//            Scanner itemList = new Scanner(itemListFilePath);
//            while (itemList.hasNextLine()){
//                String itemLine = itemList.nextLine();
//                String[] items = itemLine.split("\\|");
//                itemPositionList.add(items[0]);
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
        return position;
    }

    public String getName() {
        return name;
    }
}
