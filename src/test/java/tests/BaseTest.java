package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import pages.XeroLoginPage;
import utils.logs.Log;

public class BaseTest {
    public WebDriver driver;
    public HomePage homePage;
    public XeroLoginPage loginPage;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public void classLevelSetup() {
        Log.info("Tests is starting!");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void methodLevelSetup() {
        loginPage = new XeroLoginPage(driver);
        homePage = new HomePage(driver);
        Log.info(driver.getCurrentUrl());
        if(!driver.getCurrentUrl().contains("go.xero.com")) {
            /* logging into Xero if not logged in already */
            loginPage.loginIntoXeroTrialAccount("julia095+test@gmail.com", "password1");
        }
    }

    @AfterClass
    public void teardown() {
        Log.info("Tests are ending!");
        driver.quit();
    }
}