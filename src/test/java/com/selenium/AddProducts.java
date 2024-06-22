package com.selenium;
import Page.*;
import base.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProducts extends TestUtil {

    @Test
    public void AddItemToTheCart(){
       LoginPage loginPage = new LoginPage(driver);
       ProductsPage addProducts = loginPage.login("standard_user", "secret_sauce");
       addProducts.addToCartByProductName("backpack");

        Assert.assertEquals(addProducts.getNumbersInTheCart(), 1, "Because we have one item in the cart.");
    }
}
