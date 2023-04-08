package com.zerobank.steps_defs;

import com.zerobank.pages.LoginPage;
import com.zerobank.pages.ZeroAccountSummaryPage;
import com.zerobank.utulities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class ZeroAccountSummary_StepDefs {

    LoginPage loginPage = new LoginPage();
    ZeroAccountSummaryPage zeroAccountSummaryPage = new ZeroAccountSummaryPage();


    @Then("Validate all tabs are on the Account Summary Page")
    public void validate_all_tabs_are_on_the_page(List<String> tabNames) {
        List<String> expected = tabNames;
        List<String> actual = BrowserUtils.getElementsText(zeroAccountSummaryPage.menuList);
        System.out.println("expected = " + expected);
        System.out.println("actual = " + actual);
        Assert.assertEquals(expected,actual);
    }

    @Then("Validate all tabs are on the Credit Accounts Table")
    public void validateAllTabsAreOnTheCreditAccountsTable(List<String> menuNames) {
        List<String> expected = menuNames;
        List<String> actual = BrowserUtils.getElementsText(zeroAccountSummaryPage.menuList2);
        System.out.println("expected = " + expected);
        System.out.println("actual = " + actual);
        Assert.assertEquals(expected,actual);
    }

    @And("Go to {string} and {string}")
    public void goToAnd(String summary, String accountType) {
        loginPage.accountSummaryControl(summary, accountType);
    }

    @Then("Verify that {string} and {string} and {string}")
    public void verifyThatAndAnd(String title1, String title2, String title3) {
        String expected1=title1;
        String expected2=title2;
        String expected3 = title3;
        String actual1 = zeroAccountSummaryPage.titleControl(title1);
        String actual2 = zeroAccountSummaryPage.titleControl(title2);
        String actual3 = zeroAccountSummaryPage.titleControl(title3);
        Assert.assertEquals(expected1,actual1);
        Assert.assertEquals(expected2,actual2);
        Assert.assertEquals(expected3,actual3);
    }



}
