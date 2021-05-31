package pages;


import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.logs.Log;

import static org.testng.AssertJUnit.assertEquals;

public class HomePage extends BasePage {
    /**
     * Constructor
     */
    public HomePage(WebDriver driver) {
        super(driver);
    }

     /**
     * Web Elements
     */
    By accountingTabElement = By.xpath("//button[@data-name=\"navigation-menu/accounting\"]");
    By bankAccountsMenuLinkElement = By.xpath("//a[@data-name=\"navigation-menu/accounting/bank-accounts\"]");
    By addBankAccountButtonElement = By.xpath("//span[@data-automationid=\"Add Bank Account-button\"]");
    By anzBankListElement = By.xpath("//li[text()='ANZ (NZ)']");
    By accountTypeSelectorElement = By.id("accounttype-1039-inputEl");
    By continueButtonElement = By.id("common-button-submit-1015-btnInnerEl");
    By accountNameElement = By.id("accountname-1037-inputEl");
    By accountNumberElement = By.id("accountnumber-1068-inputEl");
    By infoMessageElement = By.id("notify01");
    By bankAccountPanelElements = By.className("dashboard-box-inner");
    By bankAccountTextFieldPanelElements = By.className("ba-accountdetail");
    //*[@id="accountDetail-1031-innerCt"]
    By addAnotherAnzAcccountElement = By.id("button-1075-btnInnerEl");


    /**
     * Page Methods
     */

    public HomePage goToBankAccountsPage() {
        Log.info("Going to Bank accounts page");
        click(accountingTabElement);
        click(bankAccountsMenuLinkElement);
        return this;
    }

    public HomePage goToAddBankAccountPage() {
        Log.info("Going to add bank accounts page");
        click(addBankAccountButtonElement);
        return this;
    }

    public HomePage pickAnzBankFromFavorites() {
        Log.info("Picking ANZ bank from favorites");
        click(anzBankListElement);
        return this;
    }

    public HomePage fillInBankDetails(String accountName, String accountType, String account_number) {
        Log.info("Filling in bank details");
        click(accountTypeSelectorElement);
        click(selectElementWithText(accountType));
        writeText(accountNameElement, accountName);
        writeText(accountNumberElement, account_number);
        return this;
    }

    public HomePage clickContinue() {
        Log.info("Click continue to add a bank account");
        click(continueButtonElement);
        return this;
    }

    public String  getTestAccountNumber() {
        return  "test"+ RandomStringUtils.randomNumeric(4);
    }

    public HomePage verifyStatusInfoMessageContains(String expectedText) {
        Log.info("Verifying status info message");
        waitVisibility(infoMessageElement);
        assertEquals(expectedText, readText(infoMessageElement));
        return this;
    }

    public int getBankAccountPanelNumber() {
        waitVisibility(bankAccountPanelElements);
        return driver.findElements(bankAccountPanelElements).size();
    }

    public HomePage verifyNumberOfPanelsIncreasedByNumber(int panelsCountBefore, int panelsCountAfter, int expectedDifference) {
        Log.info("Verifying number of panels is increased by number");
        int actualBankAccountPanelsCountDifference = panelsCountAfter - panelsCountBefore;
        assertEquals(expectedDifference, actualBankAccountPanelsCountDifference);
        return this;
    }

    public HomePage clickAddAnotherAnzAccount() {
        click(addAnotherAnzAcccountElement);
        return this;
    }

    public int getBankAccountTextFieldPanelNumber() {
        waitVisibility(bankAccountTextFieldPanelElements);
        return driver.findElements(bankAccountTextFieldPanelElements).size();
    }
}