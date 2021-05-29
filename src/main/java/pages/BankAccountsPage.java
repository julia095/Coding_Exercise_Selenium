package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Utils;

public class BankAccountsPage extends BasePage {

    public BankAccountsPage(WebDriver driver) {
        super(driver);
    }

    private Utils utils = new Utils(driver);

    public void open() {
        utils.waitForElement(getAccountingButtonLocator());
        driver.findElement(getAccountingButtonLocator()).click();
        driver.findElement(getBankAccountsButtonLocator()).click();
    }

    private By getBankAccountsButtonLocator() {
        return By.xpath("//a[@data-name=\"navigation-menu/accounting/bank-accounts\"]");
    }

    private By getAccountingButtonLocator() {
        return By.xpath("//button[@data-name=\"navigation-menu/accounting\"]");
    }

    public boolean isLoaded() {
        return utils.waitForElement(getAddBankAccountButtonLocator());
    }

    public void addANZBankAccountFromPopularBankLists() {
        driver.findElement(getAddBankAccountButtonLocator()).click();
        utils.waitForElement(getAnzBankLocator());
        driver.findElement(getAnzBankLocator()).click();

    }

    private By getAnzBankLocator() {
        return By.xpath("//*[text()='ANZ (NZ)']");
    }

    private By getAddBankAccountButtonLocator() {
        return By.xpath("//span[@data-automationid=\"Add Bank Account-button\"]");
    }

    public String getAddAccountStatusMessage() {
        return driver.findElement(By.id("notify01")).getText().trim();
    }
}
