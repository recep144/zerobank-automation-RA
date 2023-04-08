package com.zerobank.steps_defs;

import com.zerobank.pages.ZeroAccountActivityPage;
import com.zerobank.utulities.BrowserUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ZeroAccountActivity_StepDefs {

    ZeroAccountActivityPage zeroAccountActivityPage = new ZeroAccountActivityPage();
    @Then("Verify that {string} is visible on the Account Activity page")
    public void verifyThatIsVisibleOnTheAccountActivityPage(String accountName) {
        String expectedAccountName = accountName;
        String actualAccountName = zeroAccountActivityPage.selectAccount.getText();
        Assert.assertEquals(expectedAccountName, actualAccountName);
        System.out.println("expectedAccountName = " + expectedAccountName);
        System.out.println("actualAccountName = " + actualAccountName);
    }

    @Then("Verify that account menu should be include the following options")
    public void verifyThatAccountMenuShouldBeIncludeTheFollowingOptions(List<String> accountNames) {
        List<String> expectedAccountNames = accountNames;
        List<String> actualAccountNames = BrowserUtils.getElementsText(zeroAccountActivityPage.accountOptions());
        Assert.assertEquals(expectedAccountNames,actualAccountNames);
        System.out.println("expectedAccountNames = " + expectedAccountNames);
        System.out.println("actualAccountNames = " + actualAccountNames);

    }

    @Then("Verify that Transactions table should be include the following options")
    public void verifyThatTransactionsTableShouldBeIncludeTheFollowingOptions(List<String> menuNames) {
        List<String> expectedTransactionsMenu = menuNames;
        List<String> actualTransactionsMenu = BrowserUtils.getElementsText(zeroAccountActivityPage.menu);
        System.out.println("expectedTransactionsMenu = " + expectedTransactionsMenu);
        System.out.println("actualTransactionsMenu = " + actualTransactionsMenu);
        Assert.assertEquals(expectedTransactionsMenu,actualTransactionsMenu);

    }


}
