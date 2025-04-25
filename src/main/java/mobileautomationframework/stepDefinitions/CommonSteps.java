package mobileautomationframework.stepDefinitions;

import java.net.MalformedURLException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import mobileautomationframework.appiumBase.BaseTestClass;

public class CommonSteps extends BaseTestClass {
	
	@Given("I start the appium app")
	public void i_open_the_app() throws MalformedURLException {
		configureAppium();
	}

	@Then("I select the Views option")
	public void i_select_the_views_option() {
		System.out.println("SUXXEXXX");
	}

	@Then("I select the App option")
	public void i_select_the_app_option() throws InterruptedException {
		Thread.sleep(10000);
	}

}
