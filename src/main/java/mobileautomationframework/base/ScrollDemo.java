package mobileautomationframework.base;

import org.testng.annotations.Test;
import java.net.MalformedURLException;
import io.appium.java_client.AppiumBy;

/**
 * Scroll Demo 
 * Here we are using the UiScrollable class and also the Google Engine as we are using androidUIAutomator
 */
public class ScrollDemo extends BaseTestClass {

	@Test
	public void appiumTest() throws MalformedURLException, InterruptedException {

		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		//If you know where to scroll, then use this.
//		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))"));
		
		// Else use the exact pixel point value to where you want to scroll
		// Java
//		while((Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
//		    "left", 100, "top", 100, "width", 200, "height", 200,
//		    "direction", "down",
//		    "percent", 1.0
//		))){
//			
//		};
	}
}
