package mobileautomationframework.base;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTestClass {

    public AndroidDriver driver;
    public WebDriverWait wait;
    public AppiumDriverLocalService appiumBuilderService;

    public BaseTestClass() {
        // Start Appium Server
        appiumBuilderService = new AppiumServiceBuilder()
                .withAppiumJS(new File("C:\\Users\\piyush.akoliya\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();

        appiumBuilderService.start();

        // Setup Android Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("AndroidEmulator");

        options.setPlatformName("Android");
//        options.setCapability("browserName", "Chrome");
        options.setApp("C:\\POC\\Project\\NovaTest-Mobile\\src\\main\\java\\resources\\ApiDemos-debug.apk");

        // Initialize AndroidDriver
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        // Initialize PageFactory & Wait
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(15)), this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void longPressItem(WebElement element) throws InterruptedException {

        // Java
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "duration", 2000));
        Thread.sleep(2000);
    }

    public void scrollToTheEnd() {
        while ((Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of("left",
                100, "top", 100, "width", 200, "height", 200, "direction", "down", "percent", 1.0))) {

        }
        ;
    }

    public void swipeElement(WebElement element, String direction, float percentage) {

        // Java
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",
                ((RemoteWebElement) element).getId(), "direction", direction, "percent", percentage));

    }

    public void dragAndDrop(WebElement element, int xcordinate, int ycordinate) {
        // Java
        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of("elementId",
                ((RemoteWebElement) element).getId(), "endX", xcordinate, "endY", ycordinate));

        Assert.assertEquals(driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText(),
                "Dropped!");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        appiumBuilderService.stop();
    }

    /* ------------- Core Private Methods ------------- */

    public WebElement find(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator);
    }

    public List<WebElement> findElements(By locator) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        return driver.findElements(locator);
    }

    public void waitForVisibility(WebElement element) {
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
			System.out.println("Exception::"+e.getMessage());
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
}