package com.selenium;

import base.TestUtil;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class TestLoginFail extends TestUtil {

    @DataProvider
    public static Object[][] usersList_csv() {
        return new Object[][]{};
    }

        @DataProvider(name = "users_csv")
                public Object[][] readWrongUsersFromCsv() throws IOException, CsvException {
            try (CSVReader scvReader = new CSVReader(new FileReader("src/test/resources/userList.csv"))) {
                List<String[]> scvData = scvReader.readAll();
                Object[][] csvDataObject = new Object[scvData.size()][2];
                for (int i = 0; i < scvData.size(); i++) {
                    csvDataObject[i] = scvData.get(i);
                }
                return csvDataObject;


            }
        }
    @Test(dataProvider = "users_csv")
    public void LoginFail(String userName, String password) {


        WebElement userNameInput = driver.findElement(By.id("user-name"));
        userNameInput.clear();
        userNameInput.sendKeys(userName);




        WebElement passwordInput = driver.findElement(By.cssSelector("[placeholder=Password]"));
        userNameInput.clear();
        passwordInput.sendKeys(password);

        WebElement loginBtn = driver.findElement(By.name("login-button"));
        loginBtn.click();

        WebElement wrongUserBtn = driver.findElement(By.cssSelector(".error-button"));

        Assert.assertTrue(wrongUserBtn.isDisplayed());
    }
}
