package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Vending Machine Command Line Interface application
public class VendingMachineCLI {

	public static void main(String[] args) {
		// Make some objects here!
		UserInterface ui = new UserInterface();
		ui.mainMenu();
		System.exit(1);
	}
}
