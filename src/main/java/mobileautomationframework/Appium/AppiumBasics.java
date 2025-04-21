package mobileautomationframework.Appium;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import io.appium.java_client.AppiumBy;

/**
 * Hello world!
 */
public class AppiumBasics extends BaseTestClass {
   
	@Test
	public void appiumTest() throws MalformedURLException {

		checkAndroidEnvVariables();
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		String alertTitle= driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alertTitle, "WiFi settings");
		driver.findElement(By.id("android:id/edit")).sendKeys("Testing Wifi");
		driver.findElement(By.id("android:id/button1")).click();
	
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
