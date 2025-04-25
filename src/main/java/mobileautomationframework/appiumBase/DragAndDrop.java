package mobileautomationframework.appiumBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import io.appium.java_client.AppiumBy;

/**
 * Swipe Demo
 * 
 */
public class DragAndDrop extends BaseTestClass {

	@Test
	public void appiumTest() throws MalformedURLException, InterruptedException {

		driver.findElement(AppiumBy.accessibilityId("Views")).click();

		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();

		WebElement firstCircle = driver.findElement(By.xpath("(//android.view.View)[1]"));

		dragAndDrop(firstCircle,808, 678);
	}
}
