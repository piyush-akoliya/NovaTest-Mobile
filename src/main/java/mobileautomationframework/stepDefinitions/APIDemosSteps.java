package mobileautomationframework.stepDefinitions;

import io.appium.java_client.AppiumBy;
import io.cucumber.java.en.Then;
import mobileautomationframework.pages.AppPage;
import mobileautomationframework.pages.HomePage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class APIDemosSteps {

    private HomePage apisDemoHomePage = new HomePage();
    private AppPage appPage = new AppPage();
    @Then("^I select the (.*) option$")
    public void i_select_the_app_option(String apiDemoOption) throws InterruptedException {

        Assert.assertTrue(apisDemoHomePage.isElementDisplayed(By.xpath(HomePage.API_DEMOS_TITLE)));

        switch (apiDemoOption){
            case "App":
                apisDemoHomePage.click(AppiumBy.accessibilityId("App"));
                break;
            case "Alert Dialogs":
                appPage.click(appPage.alertDialogsOption);
                break;
        }


    }
}
