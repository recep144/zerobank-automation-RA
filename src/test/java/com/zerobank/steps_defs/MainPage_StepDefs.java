package com.zerobank.steps_defs;

import com.zerobank.pages.BasePage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utulities.BrowserUtils;
import com.zerobank.utulities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage_StepDefs {

    LoginPage loginPage = new LoginPage();
    @Then("Verify that {string} is visible on the Main Page")
    public void verify_that_is_visible_on_the_Main_Page(String tabName) {

        String expectedTabName = tabName;
        String actualTabNames = loginPage.tabNames(tabName);
        Assert.assertEquals(expectedTabName,actualTabNames);

    }

    @Then("The user should be able to enter the {string} page")
    public void theUserShouldBeAbleToEnterThePage(String tabpageName) {
        loginPage.enterTabNames(tabpageName);
    }
}
