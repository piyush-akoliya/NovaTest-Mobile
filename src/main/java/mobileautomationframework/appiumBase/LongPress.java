package mobileautomationframework.appiumBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.net.MalformedURLException;

import io.appium.java_client.AppiumBy;

/**
 * Hello world!
 */
public class LongPress extends BaseTestClass {

	@Test
	public void appiumTest() throws MalformedURLException, InterruptedException {

		checkAndroidEnvVariables();

		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		WebElement element = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		
		longPressItem(element);
		
		String menuText= driver.findElement(By.id("android:id/title")).getText();
		Assert.assertEquals(menuText,"Sample menu");
		Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());

	}

	public static void checkAndroidEnvVariables() {
		String androidHome = System.getenv("ANDROID_HOME");
		String androidSdkRoot = System.getenv("ANDROID_SDK_ROOT");

		if (androidHome == null || androidHome.isEmpty()) {
			System.out.println("❌ ANDROID_HOME is not set.");
		} else {
			System.out.println("✅ ANDROID_HOME: " + androidHome);
		}

		if (androidSdkRoot == null || androidSdkRoot.isEmpty()) {
			System.out.println("❌ ANDROID_SDK_ROOT is not set.");
		} else {
			System.out.println("✅ ANDROID_SDK_ROOT: " + androidSdkRoot);
		}
	}
}
