package com.zerobank.pages;

import com.zerobank.utulities.BrowserUtils;
import com.zerobank.utulities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//a[.='Account Summary']")
    public WebElement accountSummary;

    public String tabNames(String summary){
        WebElement tab = Driver.get().findElement(By.xpath("//li[.='"+summary+"']"));
        return tab.getText();
    }

    public void enterTabNames(String summary){
        WebElement tab = Driver.get().findElement(By.xpath("//li[.='"+summary+"']"));
        tab.click();
    }
    public void accountSummaryControl(String summary, String accountType){
        WebElement tab = Driver.get().findElement(By.xpath("//li[.='"+summary+"']"));
        WebElement module = Driver.get().findElement(By.xpath("//h2[.='"+accountType+"']"));
        BrowserUtils.clickWithJS(tab);
        String expectedAccountType = accountType;
        String actuallAccountType = module.getText();
    }

    public void tabPageName(String pageName){
        WebElement page = Driver.get().findElement(By.xpath("//li[.='"+pageName+"']"));
        BrowserUtils.hover(page);
        BrowserUtils.waitForClickablility(page,9);
        BrowserUtils.clickWithJS(page);
    }



}
