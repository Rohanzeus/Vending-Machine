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





    public Item(String slot, String name, double price, String type) {
        this.name = name;
        this.price = price;
        this.slot = slot;
        this.type = type;
        this.stock = 5;

    }

    public int stockSubtraction(){
        this.stock -= 1;
        return this.stock;
    }



    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public int getStock() {
        return stock;
    }
}
