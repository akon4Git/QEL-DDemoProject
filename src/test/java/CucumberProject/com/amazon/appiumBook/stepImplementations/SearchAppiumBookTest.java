package CucumberProject.com.amazon.appiumBook.stepImplementations;

import CucumberProject.com.amazon.appiumBook.pages.ShopForAppiumBookPage;
import base.BaseCucumber;
import CucumberProject.com.amazon.appiumBook.pages.HomeSearchPage;
import CucumberProject.com.amazon.appiumBook.pages.AppiumBookDetailsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchAppiumBookTest extends BaseCucumber {

    @Given("^User is on the \"([^\"]*)\" search page$")
    public void user_is_on_the_amazon_search_page(String url) throws Throwable {
        driver= initializeDriver();
        driver.get(url);
       }

    @When("^User searches for \"([^\"]*)\"$")
    public void user_searches_for_appium_book(String searchString) throws Throwable {
        HomeSearchPage homeSearchPage= new HomeSearchPage(driver);
        homeSearchPage.getInputSearchLocator().sendKeys(searchString);
        homeSearchPage.getsearchButtonLocator().click();
    }

    @Then("^User selects the first search result with some rating details$")
    public void user_selects_the_first_search_result_with_some_rating_details() throws Throwable {
        ShopForAppiumBookPage shopForAppiumBookPage= new ShopForAppiumBookPage(driver);
        shopForAppiumBookPage.getshopBookLocator().click();
    }

    @And("^User adds the book to the cart$")
    public void user_adds_the_book_to_the_cart() throws Throwable {
        AppiumBookDetailsPage appiumBookDetailsPage= new AppiumBookDetailsPage(driver);

        //Verify the name of the book matches with that of the selected ones
        String appiumBookDescription= appiumBookDetailsPage.getAppiumBookDescription();
        System.out.println("Name of the book:"+appiumBookDescription);

        //Print the rating of the book
        System.out.println("Rating of the book:"+appiumBookDetailsPage.getBookRating());

        //Add book to the cart
        appiumBookDetailsPage.addToCart();

        //Get the price of the Appium Book
        System.out.println("Price of the book:"+appiumBookDetailsPage.getAppiumBookPrice());
    }

    @And("^close browsers$")
    public void close_browsers() throws Throwable {
        driver.quit();
    }

}