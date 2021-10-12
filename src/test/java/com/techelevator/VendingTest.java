package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class VendingTest {
    VendingMachine sut;

    @Before
    public void setup(){
        sut = new VendingMachine();
    }

    @Test
    public void getItemList_list_does_not_exist() throws FileNotFoundException {
        Scanner testVendingInventory = new Scanner((File) null);

        Scanner vendingInventory = new Scanner((File) null);

        Assert.assertEquals(vendingInventory, testVendingInventory);
    }


}
