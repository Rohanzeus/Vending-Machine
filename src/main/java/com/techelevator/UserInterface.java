package com.techelevator;

import java.io.File;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;

public class UserInterface {
    Scanner userInput = new Scanner(System.in);
    private Item item;
    DecimalFormat df = new DecimalFormat("0.00");


    public void mainMenu() {

        boolean acceptableSelection = false;

        while (!acceptableSelection) {
            System.out.println("(1) Display Vending Machine Items.");
            System.out.println("(2) Purchase.");
            System.out.println("(3) Exit.");
            System.out.println("What is your selection");
            String selection = userInput.nextLine();
            if (selection.trim().equals("1")) {
                displayItems();

            } else if (selection.trim().equals("2")) {
                purchaseMenu();
            }


        }

    }
    public void purchaseMenu() {

        boolean acceptableSelection = false;
        double currentMoney = 0;


        while (!acceptableSelection) {
            System.out.println("(1) Feed Money: ");
            System.out.println("(2) Select product");
            System.out.println("(3) Finish transaction");
            System.out.println("");
            System.out.println("Current Money Provided: $" + df.format(currentMoney));
            System.out.println("What is your selection");
            String selection = userInput.nextLine();
            if (selection.trim().equals("1")) {
                System.out.println("How much do you want to put in ($1,$2,$5,$10 as whole number)");
                String feedAmount =userInput.nextLine();
                if (feedAmount.equals("1") || feedAmount.equals("2") || feedAmount.equals("5") || feedAmount.equals("10")) {
                    double feedAmountAsDouble = Double.parseDouble(feedAmount);
                    currentMoney += feedAmountAsDouble;
                }else {
                    System.out.println("Please enter a valid whole number amount ($1,$2,$5,$10)");
                }
            } else if (selection.trim().equals("2")) {
                displayItems();
                System.out.println("Please make a selection");
                String slotSelection = userInput.nextLine();
                if (slotSelection.startsWith("A") && item.getItemListSplit().keySet().equals(slotSelection)){

                }




            }


        }

    }

    public void displayItems() {
        File path = new File("vendingmachine.csv");
        try {
            Scanner inputFile = new Scanner(path);
            while (inputFile.hasNextLine()) {
                String fileLine = inputFile.nextLine();
                System.out.println(fileLine);
            }

        } catch (Exception e) {
            System.out.println("woops");
        }
    }

    }


