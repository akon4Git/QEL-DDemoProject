package com.amazon.iPhone;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BasePageObject;

public class HomeSearchPage extends BasePageObject {

    private String pageUrl="https://www.amazon.com/";
    private By inputSearchLocator= By.id("twotabsearchtextbox");
    private By searchButtonLocator=By.xpath("//input[@type='submit' and @value='Go']");

    public HomeSearchPage(WebDriver driver, Logger log){
        super(driver,log);
    }

    public void openPage(){
        log.info("Opening page:"+ pageUrl);
        openUrl(pageUrl);
        log.info("Page opened");
    }

    public ShopForIphonePage searchForItem(String typeSelection){
        log.info("Searching for :"+typeSelection);
        type(inputSearchLocator,typeSelection);
        click(searchButtonLocator);

        return new ShopForIphonePage(driver, log);

    }

   }