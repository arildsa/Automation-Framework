package util;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomCommands {

    private RemoteWebDriver driver;

    public WebElement waitForElementToBeVisible(WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public boolean isElementPresent(WebElement element)
    {
        return element.isDisplayed();
    }
}
