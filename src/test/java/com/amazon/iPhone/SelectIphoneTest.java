package com.amazon.iPhone;

import base.TestUtilities;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SelectIphoneTest extends TestUtilities {

    @Test
    @Parameters({"searchOption","IphoneType"})
    public void purchaseIphone(String searchOption, String phoneType){

        //Home Page for Search options on Amazon
        HomeSearchPage homeSearchPage= new HomeSearchPage(driver,log);

        //Open Page url
        homeSearchPage.openPage();

        //Search for an item:
        ShopForIphonePage shopForIphonePage= homeSearchPage.searchForItem(searchOption);

        shopForIphonePage.clearSearchInput();
        //Search for Iphone 11 Pro
        shopForIphonePage.searchForIPhone(phoneType);

        //Verify whether the user landed on the right iphone detail page
        String iPhoneDescription=shopForIphonePage.getIPhoneDescription();
        log.info(iPhoneDescription);
        Assert.assertTrue(iPhoneDescription.contains(phoneType),"Fail- iphone Description doesn't match per the user expectation");

        //Verify whether the comparison chart is displayed upon click the iphone 11 pro
        IphoneDetailsPage iphoneDetailsPage=shopForIphonePage.clickOnIphone();
        Assert.assertTrue(iphoneDetailsPage.verifyComparisonChartIsDisplayed(),"Fail-Comparison chart is not displayed");

        //Print the iPhone rating
        log.info(phoneType+" Rating is:"+iphoneDetailsPage.getIPhoneRating());

        //Print the price of the iphone
        log.info(phoneType+" price is:"+iphoneDetailsPage.getIPhonePrice());

        //Add the iphone to cart- commenting out since the Apple product sale is tied with user login/ phone availability
        //iphoneDetailsPage.addToCart();

     }
}
