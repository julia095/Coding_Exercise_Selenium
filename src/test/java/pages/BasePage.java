package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public void navigateToUrl(String url) {
        driver.get(url);
    }

    public void click(By by) {
        waitVisibility(by).click();
    }
    public  By selectElementWithText(String text) {
        String xpathFromText = "//*[text()='"+text+"']";
        return By.xpath(xpathFromText);
    }

    public void writeText(By by, String text) {
        waitVisibility(by).sendKeys(text);
    }

    public String readText(By by) {
        return waitVisibility(by).getText().trim();
    }

    public WebElement waitVisibility(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}
