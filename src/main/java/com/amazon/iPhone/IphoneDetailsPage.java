package com.amazon.iPhone;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BasePageObject;

public class IphoneDetailsPage extends BasePageObject {

    private  By comparisonChartLocator=By.id("comparison-chart");
    private By iPhoneRatingLocator=By.cssSelector(".container_horizontal_center .a-icon-alt");

    private By iphoneAddToCartLocator= By.xpath("");
    private By iphonePriceLocator= By.xpath("(//span[contains(@class,'a-color-price')]) [1]");

    public IphoneDetailsPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

     public boolean verifyComparisonChartIsDisplayed(){
        log.info("Verifying whether the comparison Chart is displayed on the iphone details page");
        return find(comparisonChartLocator).isDisplayed();
    }

    public String getIPhoneRating(){
        log.info("Fetching rating of the iphone");
        String rating= find(iPhoneRatingLocator).getAttribute("textContent");
        return rating;
    }

    public void addToCart(){
        log.info("Adding iPhone to the cart");
        if (find(iphoneAddToCartLocator).isEnabled()){
            log.info("The button is enabled, item is ready to be added to the Cart!");
            click(iphoneAddToCartLocator);
        }
    }

    public String getIPhonePrice(){
        log.info("Fetching the price of the iphone");
        return find(iphonePriceLocator).getText();
    }
}
