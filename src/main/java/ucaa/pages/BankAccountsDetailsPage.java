package ucaa.pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ucaa.services.Services;


public class BankAccountsDetailsPage extends BasePage {
    public BankAccountsDetailsPage(WebDriver driver) {
        super(driver);
    }

    private String shortId = RandomStringUtils.randomNumeric(8);
    private Services services = new Services(driver);
    public String uniqueAccountName = "test" + shortId;

    public boolean isLoaded() {
        return services.waitForElement(By.xpath("//*[@id=\"formheader-1029\"]/h1"));
    }

    public void fillAccountDetails() {
        driver.findElement(By.id("accountname-1037-inputEl")).sendKeys(uniqueAccountName);
        driver.findElement(By.id("accounttype-1039-inputEl")).click();
        driver.findElement(By.xpath("//*[text()='Everyday (day-to-day)']")).click();
        driver.findElement(By.id("accountnumber-1068-inputEl")).sendKeys("8374 4646 3737 4646");
        driver.findElement(By.id("common-button-submit-1015")).click();
    }
}
