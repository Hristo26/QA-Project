package base;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestUtil {
    public WebDriver driver;
    private String applicationUrl, browser;
    private int implicitWaitSeconds;

    @BeforeMethod
    public void setUp() {
       setupBrowserDriver();
       loadInitialPage();
    }

    private void loadInitialPage() {
        driver.get(applicationUrl);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    private void setupBrowserDriver() {
        try {
            FileInputStream configFile = new
                    FileInputStream("src/test/resources/config.properties");
            java.util.Properties config = new Properties();
            config.load(configFile);
            applicationUrl = config.getProperty("url");
            implicitWaitSeconds = Integer.parseInt(config.getProperty("implicitWait"));
            browser = config.getProperty("targetBrowser");

        } catch (IOException e) {
            System.out.println(e);
        }

        switch (browser) {
            case "chrome":
              driver = DriverFactory.getChromeDriver(implicitWaitSeconds);
              break;
            case "firefox":
             driver = DriverFactory.getFirefoxDriver(implicitWaitSeconds);
             break;
        }
    }

}

