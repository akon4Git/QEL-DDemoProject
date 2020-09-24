package com.amazon.appiumBook;

import base.TestUtilities;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchAppiumBookTest extends TestUtilities {

    @Test
    @Parameters({"searchOption"})
    public void searchAndAddAppiumBook(String searchOption){

        //Home Page for Search options on Amazon
        HomeSearchPage homeSearchPage= new HomeSearchPage(driver,log);

        //Open Page url
        homeSearchPage.openPage();

        //Search for Appium Book:
        ShopForAppiumBookPage shopForAppiumBookPage= homeSearchPage.searchForItem(searchOption);
        //select 1st search result
        AppiumBookDetailsPage appiumBookDetailsPage= shopForAppiumBookPage.selectBook();

        //Verify the name of the book matches with that of the selected ones
        String appiumBookDescription= appiumBookDetailsPage.getAppiumBookDescription();
       log.info("Name of the book:"+appiumBookDescription);

       //Print the rating of the book
       log.info("Rating of the book:"+appiumBookDetailsPage.getBookRating());

       //Add book to the cart
       appiumBookDetailsPage.addToCart();

       //Get the price of the Appium Book
       log.info("Price of the book:"+appiumBookDetailsPage.getAppiumBookPrice());

     }
}
