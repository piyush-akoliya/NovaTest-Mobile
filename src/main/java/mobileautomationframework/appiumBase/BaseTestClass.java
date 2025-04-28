package mobileautomationframework.appiumBase;

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
	protected WebDriverWait wait;
    public AppiumDriverLocalService appiumBuilderService;

	@BeforeClass
	public void configureAppium() throws MalformedURLException {
		// Start Appium Server
		appiumBuilderService = new AppiumServiceBuilder()
				.usingDriverExecutable(new File("/opt/homebrew/bin/node"))
				.withAppiumJS(new File("/opt/homebrew/lib/node_modules/appium/build/lib/main.js"))
				.withIPAddress("127.0.0.1")
				.usingPort(4723)
				.build();
		appiumBuilderService.start();

		// Setup Android Capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("PiyushEmulator");
		options.setApp("/Users/piyushakoliya/testing-frameworks/Appium/src/main/java/resources/ApiDemos-debug.apk");

		// Initialize AndroidDriver
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

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

	private WebElement find(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return driver.findElement(locator);
	}

	private List<WebElement> findElements(By locator) {
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		return driver.findElements(locator);
	}

	private void waitForVisibility(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/* ------------- Public Generic Actions ------------- */

	protected void click(By locator) {
		find(locator).click();
	}

	protected void click(WebElement element) {
		waitForVisibility(element);
		element.click();
	}

	protected void sendKeys(By locator, String text) {
		WebElement element = find(locator);
		element.clear();
		element.sendKeys(text);
	}

	protected void sendKeys(WebElement element, String text) {
		waitForVisibility(element);
		element.clear();
		element.sendKeys(text);
	}

	protected String getText(By locator) {
		return find(locator).getText();
	}

	protected String getText(WebElement element) {
		waitForVisibility(element);
		return element.getText();
	}

	protected boolean isElementDisplayed(By locator) {
		try {
			return find(locator).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	protected boolean isElementDisplayed(WebElement element) {
		try {
			waitForVisibility(element);
			return element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	protected List<WebElement> getElements(By locator) {
		return findElements(locator);
	}

	protected int getElementCount(By locator) {
		return findElements(locator).size();
	}
}