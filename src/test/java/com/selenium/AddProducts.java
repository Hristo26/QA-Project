package com.selenium;
import Page.*;
import base.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProducts extends TestUtil {

    @Test
    public void AddItemToTheCart(){
       LoginPage loginPage = new LoginPage(driver);
       ProductsPage productsPage = loginPage.login("standard_user", "secret_sauce");
       productsPage.addToCartByProductName("backpack");

        Assert.assertEquals(productsPage.getNumbersInTheCart(), 1, "Because we have one item in the cart.");
    }

}
