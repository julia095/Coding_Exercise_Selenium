package ucaa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ucaa.services.Services;

public class BankAccountsPage extends BasePage {

    public BankAccountsPage(WebDriver driver) {
        super(driver);
    }

    private Services services = new Services(driver);

    public void open() {
        services.waitForElement(getAccountingButtonLocator());
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
        return services.waitForElement(getAddBankAccountButtonLocator());
    }

    public void addANZBankAccountFromPopularBankLists() {
        driver.findElement(getAddBankAccountButtonLocator()).click();
        services.waitForElement(getAnzBankLocator());
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
