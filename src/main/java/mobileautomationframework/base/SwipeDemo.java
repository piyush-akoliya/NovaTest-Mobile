package mobileautomationframework.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


import java.net.MalformedURLException;
import io.appium.java_client.AppiumBy;

/**
 * Swipe Demo
 * 
 */
public class SwipeDemo extends BaseTestClass {

	@Test
	public void appiumTest() throws MalformedURLException, InterruptedException {

		driver.findElement(AppiumBy.accessibilityId("Views")).click();

		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();

		driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();

		WebElement firstImage = driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
		
		swipeElement(firstImage,"left",(float) 0.75);

	}
}
