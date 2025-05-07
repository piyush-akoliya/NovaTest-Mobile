package mobileautomationframework.base;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class MobileDriverBase extends WebDriverBase {

    protected AndroidDriver driver;
    protected AppiumDriverLocalService appiumBuilderService;

    @BeforeClass
    public void setupAppium() throws MalformedURLException {
        appiumBuilderService = new AppiumServiceBuilder()
                .withAppiumJS(new File("C:\\Users\\piyush.akoliya\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .build();

        appiumBuilderService.start();

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("AndroidEmulator");
        options.setPlatformName("Android");
        options.setApp("C:\\POC\\Project\\NovaTest-Mobile\\src\\main\\java\\resources\\ApiDemos-debug.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(15)), this);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) driver.quit();
        if (appiumBuilderService != null) appiumBuilderService.stop();
    }

    /* ------------- Mobile-Specific Gestures ------------- */

    public void longPressItem(WebElement element) throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "duration", 2000));
        Thread.sleep(2000);
    }

    public void scrollToTheEnd() {
        while ((Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                "left", 100, "top", 100, "width", 200, "height", 200, "direction", "down", "percent", 1.0))) {
            // keep scrolling
        }
    }

    public void swipeElement(WebElement element, String direction, float percentage) {
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", direction,
                "percent", percentage));
    }

    public void dragAndDrop(WebElement element, int x, int y) {
        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "endX", x,
                "endY", y));
    }

    @Override
    protected AndroidDriver getDriver() {
        return driver;
    }
}

