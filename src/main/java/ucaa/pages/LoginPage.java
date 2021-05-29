package ucaa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public By getUserNameLocator() {
        return By.xpath("//input[@data-automationid=\"Username--input\"]");
    }

    public By getPasswordLocator() {
        return By.xpath("//input[@data-automationid=\"PassWord--input\"]");
    }

    public By getLoginButtonLocator() {
        return By.xpath("//button[@data-automationid=\"LoginSubmit--button\"]");
    }

    public By getBackUpMethod() {
        return By.xpath("//button[@data-automationid=\"auth-authsetupqa\"]");
    }

    public By getSecurityQuestions() {
        return By.xpath("//button[@data-automationid=\"auth-authwithsecurityquestionsbutton\"]");
    }

    public By getFirstSecurityQuestionField() {
        return By.xpath("//input[@data-automationid=\"auth-firstanswer--input\"]");
    }

    public By getSecondSecurityQuestionField() {
        return By.xpath("//input[@data-automationid=\"auth-secondanswer--input\"]");
    }

    public By getSecurityQuestionsConfirmationButton() {
        return By.xpath("//button[@data-automationid=\"auth-submitanswersbutton\"]");
    }

    public void open() {
        driver.get("https://login.xero.com/identity/user/login");
    }

    public boolean isLoaded() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(getUserNameLocator())).isDisplayed();
    }

    public void login(String username, String password) {
        driver.findElement(getUserNameLocator()).sendKeys(username);
        driver.findElement(getPasswordLocator()).sendKeys(password);
        driver.findElement(getLoginButtonLocator()).click();
        driver.findElement(getBackUpMethod()).click();
        driver.findElement(getSecurityQuestions()).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(getFirstSecurityQuestionField())).isDisplayed();
        driver.findElement(getFirstSecurityQuestionField()).sendKeys(getFirstSecretQuestionValue());
        driver.findElement(getSecondSecurityQuestionField()).sendKeys(getSecondSecretQuestionValue());
        driver.findElement(getSecurityQuestionsConfirmationButton()).click();
    }

    // since MFA is a mandatory thing in NZ, I've changed it to be using security queations to make it easier to login.
    // Answers to security questions are the last word of each question word used
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
