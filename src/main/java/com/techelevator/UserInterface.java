package com.techelevator;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class UserInterface {
    DateFormat dateFormat2 = new SimpleDateFormat(" dd/MM/yyyy hh:mm:ss aa ");
    String dateString2 = dateFormat2.format(new Date()).toString();
    Scanner userInput = new Scanner(System.in);
    DecimalFormat df = new DecimalFormat("0.00");
    VendingMachine vendingMachine1 = new VendingMachine();


    public void mainMenu() {
        vendingMachine1.getItemListSplit();

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
                purchaseMenu(vendingMachine1);
            }else {
                acceptableSelection = true;
            }


        }

    }
    public void purchaseMenu(VendingMachine vendingMachine1) {

        boolean acceptableSelection = false;
        double currentMoney = 0;
        int currentStock = 5;


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

                    File log = new File("log.txt");
                    try (PrintWriter writer = new PrintWriter(new FileWriter(log, true))) {
                        writer.println(dateString2 + " MONEY FED $" + df.format(currentMoney) + " $" + df.format(feedAmountAsDouble));
                    } catch (Exception e) {
                        System.out.println("The log was not written!");
                    }
                    currentMoney += feedAmountAsDouble;
                }else {
                    System.out.println("Please enter a valid whole number amount ($1,$2,$5,$10)");
                }
            } else if (selection.trim().equals("2")) {
                displayItems();
                System.out.println("Please make a selection");
                String slotSelection = userInput.nextLine();
                slotSelection = slotSelection.toLowerCase(Locale.ROOT);
                for (String key : vendingMachine1.getItemsInMap().keySet()){
                    if (key.equalsIgnoreCase(slotSelection)){
                        if(currentMoney < vendingMachine1.getItemsInMap().get(slotSelection).getPrice()){
                            System.out.println("Please feed in more money!");
                        }else{
//                        System.out.print(vendingMachine1.getItemsInMap().get(slotSelection).getName() + " ");
//                        System.out.print(vendingMachine1.getItemsInMap().get(slotSelection).getPrice() + " ");
//                        System.out.print(vendingMachine1.getItemsInMap().get(slotSelection).getType() + " ");
                        double previousMoney = currentMoney;
//                        currentMoney -= vendingMachine1.getItemsInMap().get(slotSelection).getPrice();
                        if (slotSelection.startsWith("a") && vendingMachine1.getItemsInMap().get(slotSelection).getStock() > 0){
                            File log = new File("log.txt");
                            try (PrintWriter writer = new PrintWriter(new FileWriter(log, true))) {
                                writer.println(dateString2 + vendingMachine1.getItemsInMap().get(slotSelection).getName() + " " + slotSelection  + " $" + df.format(previousMoney)+ " $" + df.format(currentMoney));
                            } catch (Exception e) {
                                System.out.println("The log was not written!");
                            }
                            System.out.print(vendingMachine1.getItemsInMap().get(slotSelection).getName() + " ");
                            System.out.print(vendingMachine1.getItemsInMap().get(slotSelection).getPrice() + " ");
                            System.out.print(vendingMachine1.getItemsInMap().get(slotSelection).getType() + " ");
                            currentMoney -= vendingMachine1.getItemsInMap().get(slotSelection).getPrice();
                            vendingMachine1.getItemsInMap().get(slotSelection).stockSubtraction();
                            System.out.println("Crunch Crunch, Yum! " + "Current stock of item is: " + vendingMachine1.getItemsInMap().get(slotSelection).getStock());
                        }else if (slotSelection.startsWith("b") && vendingMachine1.getItemsInMap().get(slotSelection).getStock() > 0){
                            File log = new File("log.txt");
                            try (PrintWriter writer = new PrintWriter(new FileWriter(log, true))) {
                                writer.println(dateString2 + vendingMachine1.getItemsInMap().get(slotSelection).getName() + " " + slotSelection  + " $" + df.format(previousMoney)+ " $" + df.format(currentMoney));
                            } catch (Exception e) {
                                System.out.println("The log was not written!");
                            }
                            System.out.print(vendingMachine1.getItemsInMap().get(slotSelection).getName() + " ");
                            System.out.print(vendingMachine1.getItemsInMap().get(slotSelection).getPrice() + " ");
                            System.out.print(vendingMachine1.getItemsInMap().get(slotSelection).getType() + " ");
                            currentMoney -= vendingMachine1.getItemsInMap().get(slotSelection).getPrice();
                            vendingMachine1.getItemsInMap().get(slotSelection).stockSubtraction();
                            System.out.println("Munch munch, Yum! " + "Current stock of item is: " + vendingMachine1.getItemsInMap().get(slotSelection).getStock());
                        }else if (slotSelection.startsWith("c") && vendingMachine1.getItemsInMap().get(slotSelection).getStock() > 0){
                            File log = new File("log.txt");
                            try (PrintWriter writer = new PrintWriter(new FileWriter(log, true))) {
                                writer.println(dateString2 + vendingMachine1.getItemsInMap().get(slotSelection).getName() + " " + slotSelection  + " $" + df.format(previousMoney)+ " $" + df.format(currentMoney));
                            } catch (Exception e) {
                                System.out.println("The log was not written!");
                            }
                            System.out.print(vendingMachine1.getItemsInMap().get(slotSelection).getName() + " ");
                            System.out.print(vendingMachine1.getItemsInMap().get(slotSelection).getPrice() + " ");
                            System.out.print(vendingMachine1.getItemsInMap().get(slotSelection).getType() + " ");
                            currentMoney -= vendingMachine1.getItemsInMap().get(slotSelection).getPrice();
                            vendingMachine1.getItemsInMap().get(slotSelection).stockSubtraction();
                            System.out.println("Glug glug, Yum! " + "Current stock of item is: " + vendingMachine1.getItemsInMap().get(slotSelection).getStock());
                        }else if (slotSelection.startsWith("d") && vendingMachine1.getItemsInMap().get(slotSelection).getStock() > 0){
                            File log = new File("log.txt");
                            try (PrintWriter writer = new PrintWriter(new FileWriter(log, true))) {
                                writer.println(dateString2 + vendingMachine1.getItemsInMap().get(slotSelection).getName() + " " + slotSelection  + " $" + df.format(previousMoney)+ " $" + df.format(currentMoney));
                            } catch (Exception e) {
                                System.out.println("The log was not written!");
                            }
                            System.out.print(vendingMachine1.getItemsInMap().get(slotSelection).getName() + " ");
                            System.out.print(vendingMachine1.getItemsInMap().get(slotSelection).getPrice() + " ");
                            System.out.print(vendingMachine1.getItemsInMap().get(slotSelection).getType() + " ");
                            currentMoney -= vendingMachine1.getItemsInMap().get(slotSelection).getPrice();
                            vendingMachine1.getItemsInMap().get(slotSelection).stockSubtraction();
                            System.out.println("Chew chew, Yum! " + "Current stock of item is: " + vendingMachine1.getItemsInMap().get(slotSelection).getStock());
                        } else{
                            System.out.println("Try again selection is empty.");

                        }
                    }
                    }

                }
            }else if (selection.trim().equals("3")){
                double currentCents = currentMoney * 100;
                int nickels = 0;
                int dimes = 0;
                int quarters = 0;
                if (currentCents < 1) {
                    System.out.println("Thank you, come again");
                } else {
                    while (currentCents >= 25) {
                        currentCents -= 25;
                        quarters++;
                    }

                    while (currentCents >= 10) {
                        currentCents -= 10;
                        dimes++;
                    }
                    while (currentCents >= 5) {
                        currentCents -= 5;
                       nickels++;
                    }

                }

                System.out.println("Your change is " + quarters + " Quarters " + dimes + " Dimes " + nickels + " Nickels");
                File log = new File("log.txt");
                try (PrintWriter writer = new PrintWriter(new FileWriter(log, true))) {
                    writer.println(dateString2 + "GIVE CHANGE: $" + df.format(currentMoney) + " $0.00");
                } catch (Exception e) {
                    System.out.println("The log was not written!");
                }
               acceptableSelection = true;
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


