package com.zerobank.pages;

import com.zerobank.utulities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ZeroAccountActivityPage extends BasePage{


    @FindBy(xpath = "(//select/option[.='Savings'])[1]")
    public WebElement selectAccount;

//        public WebElement acoountSelect(String account){
//            WebElement acccountsName = Driver.get().findElement(By.xpath("//select[@id='aa_accountId']"));
//            Select select = new Select(acccountsName);
//             select.selectByValue(account);
//              return select.getFirstSelectedOption();
//        }

        public List<WebElement> accountOptions(){
            WebElement options = Driver.get().findElement(By.xpath("//select[@id='aa_accountId']"));
             Select select = new Select(options);
             List<WebElement> elements = select.getOptions();
//            for (WebElement element : elements) {
//                System.out.println(element.getText());
//            }

            return elements;
        }

        @FindBy(xpath = "//div[@id='all_transactions_for_account']//th")
        public List<WebElement> menu;




}
