package com.techelevator;

import java.util.Scanner;

public class UserInterface {
    Scanner userInput = new Scanner(System.in);
    private int nextMenu = 0;
    private Item item;



    public void mainMenu(){

        boolean accaptableSelection = false;
        try {
            while (!accaptableSelection) {
                System.out.println("(1) Display Vending Machine Items.");
                System.out.println("(2) Purchase.");
                System.out.println("(3) Exit.");
                System.out.println("What is your selection");
                String selection = userInput.nextLine();
                int selectionInteger = Integer.parseInt(selection);
                nextMenu = selectionInteger;
                if (selectionInteger > 3 || selectionInteger <= 0) {
                    System.out.println("Please enter a selection from 1-3");
                } else {
                    accaptableSelection = true;
                }
                if (selectionInteger == 1){
                    nextMenu = 1;
                }else if (selectionInteger == 2){
                    nextMenu = 2;
                }else if (selectionInteger == 3){
                    nextMenu = 3;
                }else {
                    nextMenu = 0;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void vendingItemsDisplayed(){
        System.out.println(item.getItemList());
    }
}
