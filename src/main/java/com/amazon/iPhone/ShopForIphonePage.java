package com.amazon.iPhone;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BasePageObject;

public class ShopForIphonePage extends BasePageObject {

    private  By shopIphoneLocator=By.id("comparison-chart");
    private By inputIPhoneSearchLocator= By.id("twotabsearchtextbox");
    private By searchButtonLocator=By.xpath("//input[@type='submit' and @value='Go']");
    //private By iPhoneSearchResultsLocator=By.xpath("(//div[@data-component-type='sp-sponsored-result']) [1]");
    private By iPhoneNameDescriptionLocator=By.xpath("(//div[@data-component-type='sp-sponsored-result']) [1]/div/div/div[2]/div[2]/div/div/div/div/div/h2/a/span");

    public ShopForIphonePage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void searchForIPhone(String typeSelection){
        log.info("Searching for:"+ typeSelection);
        find(inputIPhoneSearchLocator).sendKeys(typeSelection);
        click(searchButtonLocator);
    }
    public void selectPhoneCategory(String phoneType){
        log.info("Shop Iphone:"+ phoneType);
        click(shopIphoneLocator);
    }

    public void clearSearchInput(){
        find(inputIPhoneSearchLocator).clear();
    }
    public IphoneDetailsPage clickOnIphone(){
        log.info("Click on the Iphone");
        click(iPhoneNameDescriptionLocator);
        return new IphoneDetailsPage(driver,log);
    }

    public String getIPhoneDescription(){
        return find(iPhoneNameDescriptionLocator).getText();
    }


}
