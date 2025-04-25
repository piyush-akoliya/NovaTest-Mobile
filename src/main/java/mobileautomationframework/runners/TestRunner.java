package mobileautomationframework.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/main/java/resources/features", glue = {
		"mobileautomationframework.stepDefinitions" }, plugin = { "pretty",
				"html:target/cucumber-reports.html" }, monochrome = true)
public class TestRunner extends AbstractTestNGCucumberTests {
}
