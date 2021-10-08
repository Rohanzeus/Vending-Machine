package com.techelevator;

public class Item {
    private String type;
    private double price;
    private int quantity;

    public Item(String type, double price, int quantity){
        this.type = type;
        this.price = price;
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}
