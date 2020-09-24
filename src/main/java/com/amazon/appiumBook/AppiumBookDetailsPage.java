package com.amazon.appiumBook;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BasePageObject;

public class AppiumBookDetailsPage extends BasePageObject {

    private By comparisonChartLocator=By.id("comparison-chart");
    private By appiumBookDescriptionLocator=By.cssSelector("#productTitle");
    private By appiumBookRatingLocator=By.xpath("(//span[@id='acrPopover'] /span) [1]/a/i/span");

    private By appiumBookAddToCartLocator= By.xpath("//span[@id='submit.add-to-cart']/span/input");
    private By appiumBookPriceLocator= By.xpath("//*[@id='hlb-subcart']/div[1]/span/span[2]");


    public AppiumBookDetailsPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public boolean verifyComparisonChartIsDisplayed(){
        log.info("Verifying whether the comparison Chart is displayed on the iphone details page");
        return find(comparisonChartLocator).isDisplayed();
    }

    public void addToCart(){
        log.info("Adding Book to the cart");
        if (find(appiumBookAddToCartLocator).isEnabled()){
            log.info("The button is enabled, item is ready to be added to the Cart!");
            click(appiumBookAddToCartLocator);
            log.info("Book successfully added to cart");
        }else
            log.info("Add to cart button is not enabled");

    }

    public String getBookRating(){
        log.info("Fetching the rating of the Book....");
        return find(appiumBookRatingLocator).getAttribute("textContent");
    }

    public String getAppiumBookDescription() {
        log.info("Fetching the name of the Book..");
        return find(appiumBookDescriptionLocator).getText();
    }

    public String getAppiumBookPrice() {
        log.info("Fetching the price of the Book..");
        return find(appiumBookPriceLocator).getText();
    }
}
