package mobileautomationframework.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public abstract class WebDriverBase {

    protected WebDriverWait wait;

    /* ------------- Core Utility Methods ------------- */

    protected WebElement find(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return getDriver().findElement(locator);
    }

    protected List<WebElement> findElements(By locator) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        return getDriver().findElements(locator);
    }

    protected void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /* ------------- Public Generic Actions ------------- */

    public void click(By locator) {
        find(locator).click();
    }

    public void click(WebElement element) {
        waitForVisibility(element);
        element.click();
    }

    public void sendKeys(By locator, String text) {
        WebElement element = find(locator);
        element.clear();
        element.sendKeys(text);
    }

    public void sendKeys(WebElement element, String text) {
        waitForVisibility(element);
        element.clear();
        element.sendKeys(text);
    }

    public String getText(By locator) {
        return find(locator).getText();
    }

    public String getText(WebElement element) {
        waitForVisibility(element);
        return element.getText();
    }

    public boolean isElementDisplayed(By locator) {
        try {
            return find(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementDisplayed(WebElement element) {
        try {
            waitForVisibility(element);
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public List<WebElement> getElements(By locator) {
        return findElements(locator);
    }

    public int getElementCount(By locator) {
        return findElements(locator).size();
    }

    // Abstract method to be implemented by subclasses to provide a driver
    protected abstract org.openqa.selenium.WebDriver getDriver();
}

