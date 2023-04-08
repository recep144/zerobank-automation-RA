package com.zerobank.pages;

import com.zerobank.utulities.BrowserUtils;
import com.zerobank.utulities.ConfigurationReader;
import com.zerobank.utulities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{




    @FindBy(xpath = "//button[@id='signin_button']")
    public WebElement SigninButtonInLoginPage;

    public void signinButtonInLoginPage(){
        BrowserUtils.waitForClickablility(SigninButtonInLoginPage,11);
        BrowserUtils.clickWithJS(SigninButtonInLoginPage);
    }
    @FindBy(xpath = "//input[@id='user_login']")
    public WebElement userName;
    @FindBy(xpath = "//input[@id='user_password']")
    public WebElement password;
    @FindBy(xpath = "//input[@value='Sign in']")
    public WebElement signInButton;
    @FindBy(xpath = "//div[contains(text(),'Login and/or password are wrong.')]")
    public WebElement wrongInfoMessage;

    public void signInButton(String username, String pasword){
        userName.sendKeys(username);
        password.sendKeys(pasword);
        BrowserUtils.waitForClickablility(signInButton,9);
        BrowserUtils.clickWithJS(signInButton);

    }
    public void enterTheMainPage(){
        Driver.get().navigate().back();
        BrowserUtils.waitFor(2);
        String url = ConfigurationReader.get("url2");
        Driver.get().get(url);
        BrowserUtils.waitFor(2);
    }

}
