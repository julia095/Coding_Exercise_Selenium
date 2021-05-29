package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {
    protected WebDriver driver;

    public Utils(WebDriver driver) {
        this.driver = driver;
    }

    public boolean waitForElement(By element) {
        return new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(element)).isDisplayed();
    }
}
