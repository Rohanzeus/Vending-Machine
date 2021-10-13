package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserInterfaceTest {
    UserInterface sut;

    @Before
    public void setup(){
        sut = new UserInterface();
    }

    @Test
    public void mainMenu_entering_a_number_that_is_not_a_selction(){
        //Arrange

        Assert.assertEquals("Please make a selection from 1-3", sut);
    }
}