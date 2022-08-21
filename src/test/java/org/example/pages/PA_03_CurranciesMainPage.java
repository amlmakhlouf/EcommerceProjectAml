package org.example.pages;

import org.example.StepsDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class PA_03_CurranciesMainPage {
    public PA_03_CurranciesMainPage(){PageFactory.initElements(Hooks.driver,this);}
    public WebElement getElementByCssSelector(String element){return Hooks.driver.findElement(By.cssSelector(element));}

    public void CU_1_SelectCurrency() throws InterruptedException {
        WebElement euro = Hooks.driver.findElement(By.name("customerCurrency"));
        Select select = new Select(euro);
        Thread.sleep(2000);
        select.selectByValue("https://demo.nopcommerce.com/changecurrency/6?returnUrl=%2F");

    }
    public void CU_2_CurrencySymol()
    {
        List<WebElement> productlist = Hooks.driver.findElements(By.cssSelector("span[class='price actual-price']"));
        String expectedCurrency = "€";
        for(int i = 0 ;i <  productlist.size() ;i++)
        {
            Assert.assertTrue(productlist.get(i).getText().contains(expectedCurrency));
        }
    }
}
