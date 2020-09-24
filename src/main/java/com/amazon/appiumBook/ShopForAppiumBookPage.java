package com.amazon.appiumBook;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BasePageObject;

import java.util.Iterator;
import java.util.List;

public class ShopForAppiumBookPage extends BasePageObject {

    private By shopBookLocator=By.cssSelector(".a-section.a-spacing-none .a-size-mini span");
    private By shopBookRatingLocator=By.cssSelector(".a-section.a-spacing-none  span.a-declarative i span");

    public ShopForAppiumBookPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public AppiumBookDetailsPage selectBook(){
        log.info("Shop and select 1st book:");
        List<WebElement> books =findAll(shopBookLocator);
        Iterator bookIterator= books.iterator();

        while(bookIterator.hasNext()){
            String ratingOfThisBook=find(shopBookRatingLocator).getAttribute("textContent");
            if(!ratingOfThisBook.isEmpty() && ratingOfThisBook.toLowerCase().contains("star".toLowerCase())){
                click(shopBookLocator);
                break;
            }
        }
        return new AppiumBookDetailsPage(driver,log);
    }
}
