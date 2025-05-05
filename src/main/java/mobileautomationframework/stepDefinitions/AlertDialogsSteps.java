package mobileautomationframework.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import mobileautomationframework.pages.AlertDialogs;
import org.junit.Assert;
import org.openqa.selenium.By;

public class AlertDialogsSteps {

    private AlertDialogs alertDialogs = new AlertDialogs();

    @And("I select the (.*) dialog")
    public void iSelectTheShortMessageDialog(String dialogType) {

        switch(dialogType){
            case "short message":
                    alertDialogs.click(By.xpath(AlertDialogs.OK_CANCEL_DIALOG_MESSAGE));
                break;
        }
    }

    @Then("I validate the message displayed {string}")
    public void iValidateTheMessageDisplayed(String message) {
        Assert.assertEquals(alertDialogs.getText(AlertDialogs.SHORT_MESSAGE), message);
    }
}
