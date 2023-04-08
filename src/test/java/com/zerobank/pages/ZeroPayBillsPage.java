package com.zerobank.pages;

import com.zerobank.utulities.BrowserUtils;
import com.zerobank.utulities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZeroPayBillsPage extends BasePage {


    public void payeeCheckBox(String payee) {
        WebElement element = Driver.get().findElement(By.xpath("//select[@id='sp_payee']"));
        Select select = new Select(element);
        select.selectByVisibleText(payee);
        select.getFirstSelectedOption();
    }

    public void accountcheckBox(String account) {
        WebElement element = Driver.get().findElement(By.xpath("//select[@id='sp_account']"));
        Select select = new Select(element);
        select.selectByVisibleText(account);
        select.getFirstSelectedOption();
    }

    @FindBy(css = "#sp_amount")
    public WebElement amountCheckBox;

    @FindBy(css = "#sp_date")
    public WebElement dateCheckBox;

    @FindBy(css = "#sp_description")
    public WebElement descriptionCheckBox;

    @FindBy(css = "#pay_saved_payees")
    public WebElement payButton;

    public void paymentProcess(String payee, String account, String amount, String date, String description) {
        payeeCheckBox(payee);
        BrowserUtils.waitFor(1);
        accountcheckBox(account);
        BrowserUtils.waitFor(1);
        amountCheckBox.sendKeys(amount);
        BrowserUtils.waitFor(1);
        dateCheckBox.sendKeys(date);
        BrowserUtils.waitFor(1);
        descriptionCheckBox.sendKeys(description);
        BrowserUtils.waitForClickablility(payButton, 9);
        BrowserUtils.clickWithJS(payButton);
        BrowserUtils.waitFor(1);
    }

    @FindBy(xpath = "//div[.='The payment was successfully submitted.']")
    public WebElement succesfullPayText;

    public void enterTheWrongMessage(String amount, String date, String message) {
        amountCheckBox.sendKeys(amount);
        BrowserUtils.waitFor(1);
        dateCheckBox.sendKeys(date);
        BrowserUtils.waitFor(1);
        BrowserUtils.waitForClickablility(payButton, 9);
        BrowserUtils.clickWithJS(payButton);
        String expectedWarningMessage = message;
        System.out.println("expectedWarningMessage = " + expectedWarningMessage);
        String actualWarningMsg = "";
        if (amount.isEmpty()) {
            actualWarningMsg = amountCheckBox.getAttribute("validationMessage");
        } else if (date.isEmpty()) {
            actualWarningMsg = dateCheckBox.getAttribute("validationMessage");
        }
        System.out.println("actualWarningMsg = " + actualWarningMsg);
        Assert.assertEquals(expectedWarningMessage, actualWarningMsg);

    }


}
