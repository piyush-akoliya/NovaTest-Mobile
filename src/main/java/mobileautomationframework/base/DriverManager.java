package mobileautomationframework.base;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class DriverManager {
    private static AndroidDriver driver;
    private static AppiumDriverLocalService appiumService;

    public static void startAppium() {
        appiumService = new AppiumServiceBuilder()
                .usingDriverExecutable(new File("/opt/homebrew/bin/node"))
                .withAppiumJS(new File("/opt/homebrew/lib/node_modules/appium/build/lib/main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .build();
        appiumService.start();
    }

    public static void initializeDriver() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("PiyushEmulator");
        options.setApp("/Users/piyushakoliya/testing-frameworks/Appium/src/main/java/resources/ApiDemos-debug.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public static AndroidDriver getDriver() throws MalformedURLException {
        if (driver == null) {
            startAppium();
            initializeDriver();
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) driver.quit();
        if (appiumService != null) appiumService.stop();
    }
}