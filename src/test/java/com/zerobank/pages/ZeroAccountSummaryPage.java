package com.zerobank.pages;

import com.zerobank.utulities.BrowserUtils;
import com.zerobank.utulities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ZeroAccountSummaryPage extends BasePage{

    public void accountSummaryControl(String summary, String accountType){
        WebElement tab = Driver.get().findElement(By.xpath("//li[.='"+summary+"']"));
        WebElement module = Driver.get().findElement(By.xpath("//h2[.='"+accountType+"']"));
        BrowserUtils.clickWithJS(tab);
        String expectedAccountType = accountType;
        String actuallAccountType = module.getText();
        Assert.assertEquals(expectedAccountType,actuallAccountType);
    }

    @FindBy(xpath = "//th[.='Account']")
    public WebElement firstTitle;
    @FindBy(xpath = "//th[.='Credit Card']")
    public WebElement secondTitle;
    @FindBy(xpath = "//th[.='Balance']")
    public WebElement thirdTitle;

    public String titleControl(String title){
        WebElement titles = Driver.get().findElement(By.xpath("//th[.='"+title+"']"));
        return titles.getText();
    }

    @FindBy(xpath = "//div[@class='offset2 span8']/h2")
    public List<WebElement> menuList;

    @FindBy(xpath = "(//div[@class='board'])[3]//th")
    public List<WebElement> menuList2;




    }





