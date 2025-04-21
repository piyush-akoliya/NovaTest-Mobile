package mobileautomationframework.Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTestClass {

	public AndroidDriver driver;
	public AppiumDriverLocalService appiumBuilderService;

	@BeforeClass
	public void configureAppium() throws MalformedURLException {
		// code to start the server programmatically

		appiumBuilderService = new AppiumServiceBuilder().usingDriverExecutable(new File("/opt/homebrew/bin/node"))
				.withAppiumJS(new File("/opt/homebrew/lib/node_modules/appium/build/lib/main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();

		appiumBuilderService.start();
		// providing a list of capabilities/metadata of the android device where we want
		// to run our automation scripts on
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("PiyushEmulator");
		options.setApp("/Users/piyushakoliya/testing-frameworks/Appium/src/test/java/resources/ApiDemos-debug.apk");

		// Below AndroidDriver expects a Appium Server URL
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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

	@AfterClass
	public void tearDown() {
		driver.quit();
		appiumBuilderService.stop();
	}
}
