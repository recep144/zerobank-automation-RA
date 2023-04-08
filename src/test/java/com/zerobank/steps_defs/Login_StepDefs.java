package com.zerobank.steps_defs;

import com.zerobank.pages.LoginPage;
import com.zerobank.utulities.ConfigurationReader;
import com.zerobank.utulities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Login_StepDefs {

    LoginPage loginPage = new LoginPage();

    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
    }

    @When("The user should be click Signin button")
    public void the_user_should_be_click_Signin_button() {
        loginPage.signinButtonInLoginPage();
    }

    @Then("The user logs in using {string} and {string}")
    public void theUserLogsInUsingAnd(String userName, String password) {
        loginPage.signInButton(userName,password);
    }
    @Then("The user logs the main page with the other url")
    public void theUserLogsTheMainPageWithTheOtherUrl() {
        loginPage.enterTheMainPage();
    }

    @Then("The user should be able to login")
    public void theUserShouldBeAbleToLogin() {

    }

    @Then("Verify that {string} is visible on the login page")
    public void verifyThatIsVisibleOnTheLoginPage(String text) {
        String expectedName = text;
        String actualName = loginPage.wrongInfoMessage.getText();
        System.out.println("expectedName = " + expectedName);
        System.out.println("actualName = " + actualName);
        Assert.assertEquals(expectedName,actualName);

    }




}
