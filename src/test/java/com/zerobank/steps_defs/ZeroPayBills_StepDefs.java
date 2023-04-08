package com.zerobank.steps_defs;

import com.zerobank.pages.ZeroPayBillsPage;
import com.zerobank.utulities.BrowserUtils;
import com.zerobank.utulities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;

import java.util.Map;

public class ZeroPayBills_StepDefs {

    ZeroPayBillsPage zeroPayBillsPage = new ZeroPayBillsPage();

    @Then("The user enter valid credentials with:")
    public void theUserEnterValidCredentialsWith(Map<String,String> map) {

        zeroPayBillsPage.paymentProcess(map.get("Payee"), map.get("Account"),
                map.get("Amount"), map.get("Date"), map.get("Description"));

    }

    @And("Verify that {string} message is visible on the Pay Bills page")
    public void verifyThatMessageIsVisibleOnThePayBillsPage(String message) {
        String expectedMessage = message;
        String actualMessage = zeroPayBillsPage.succesfullPayText.getText();
        System.out.println("expectedMessage = " + expectedMessage);
        System.out.println("actualMessage = " + actualMessage);
        Assert.assertEquals(expectedMessage,actualMessage);
    }

    @When("The user should be able to pay using {string} and {string}")
    public void theUserShouldBeAbleToPayUsingAnd(String amount, String date) {
        zeroPayBillsPage.enterTheWrongMessage(amount,date);
    }
    @And("Verify that {string} is visible on the Pay Bills page")
    public void verifyThatIsVisibleOnThePayBillsPage(String message) {
        Alert alert = Driver.get().switchTo().alert();
        System.out.println(alert.getText());
        Assert.assertTrue(alert.getText().contains("Please fill in this field."));


    }


}
