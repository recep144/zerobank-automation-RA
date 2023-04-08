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
    public void theUserEnterValidCredentialsWith(Map<String, String> map) {

        zeroPayBillsPage.paymentProcess(map.get("Payee"), map.get("Account"),
                map.get("Amount"), map.get("Date"), map.get("Description"));
    }

    @And("Verify that {string} message is visible on the Pay Bills page")
    public void verifyThatMessageIsVisibleOnThePayBillsPage(String message) {
        String expectedMessage = message;
        String actualMessage = zeroPayBillsPage.succesfullPayText.getText();
        System.out.println("expectedMessage = " + expectedMessage);
        System.out.println("actualMessage = " + actualMessage);
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @And("The user should be able to pay using {string}, {string} and {string}")
    public void theUserShouldBeAbleToPayUsingAnd(String amount, String date, String text) {
        zeroPayBillsPage.enterTheWrongMessage(amount, date, text);
    }


}
