package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.logs.Log;

public class XeroLoginPage extends BasePage {
    /**
     * Constructor
     */
    public XeroLoginPage(WebDriver driver) {
        super(driver);
    }
    /**
     * Variables
     */
    String loginURL = "https://login.xero.com/identity/user/login";

    /**
     * Web Elements
     */
    By userNameTextFieldElement = By.xpath("//input[@data-automationid=\"Username--input\"]");
    By passwordTextFieldElement = By.xpath("//input[@data-automationid=\"PassWord--input\"]");
    By loginButtonElement = By.xpath("//button[@data-automationid=\"LoginSubmit--button\"]");
    By getBackUpMethodLinkElement = By.xpath("//button[@data-automationid=\"auth-authsetupqa\"]");
    By securityQuestionsButtonElement = By.xpath("//button[@data-automationid=\"auth-authwithsecurityquestionsbutton\"]");
    By firstSecurityQuestionTextFieldElement = By.xpath("//input[@data-automationid=\"auth-firstanswer--input\"]");
    By secondSecurityQuestionTextFieldElement = By.xpath("//input[@data-automationid=\"auth-secondanswer--input\"]");
    By securityQuestionsConfirmationButtonElement = By.xpath("//button[@data-automationid=\"auth-submitanswersbutton\"]");

    /**
     * Page Methods
     */
    public XeroLoginPage loginIntoXeroTrialAccount(String username, String password) {
        Log.info("Trying to login to Xero");
        navigateToUrl(loginURL);
        writeText(userNameTextFieldElement, username);
        writeText(passwordTextFieldElement, password);
        click(loginButtonElement);
        click(getBackUpMethodLinkElement);
        click(securityQuestionsButtonElement);
        writeText(firstSecurityQuestionTextFieldElement, getFirstSecretQuestionValue());
        writeText(secondSecurityQuestionTextFieldElement, getSecondSecretQuestionValue());
        click(securityQuestionsConfirmationButtonElement);
        return this;
    }
    /**
    * since MFA is a mandatory thing in NZ, I've changed it to be using security queations to make it easier to login.
    * Answers to security questions are the last word of each question word used
     */
    private String getFirstSecretQuestionValue() {
        String secretQuestionValue = driver.findElement(By.xpath("//label[@data-automationid=\"auth-firstanswer--label\"]")).getText();
        String[] bits = secretQuestionValue.replaceAll("\\p{Punct}", "").split(" ");
        return bits[bits.length-1];
    }

    private String getSecondSecretQuestionValue() {
        String secretQuestionValue = driver.findElement(By.xpath("//label[@data-automationid=\"auth-secondanswer--label\"]")).getText();
        String[] bits = secretQuestionValue.replaceAll("\\p{Punct}", "").split(" ");
        return bits[bits.length-1];
    }
}
