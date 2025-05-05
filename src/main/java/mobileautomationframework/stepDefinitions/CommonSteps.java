package mobileautomationframework.stepDefinitions;

import java.net.MalformedURLException;

import io.cucumber.java.en.Given;
import mobileautomationframework.base.BaseTestClass;
import mobileautomationframework.pages.HomePage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class CommonSteps extends BaseTestClass {

    @Given("I start the appium app")
    public void i_open_the_app() throws MalformedURLException {
        configureAppium();
        Assert.assertTrue(isElementDisplayed(By.xpath(HomePage.API_DEMOS_TITLE)));
    }
}
