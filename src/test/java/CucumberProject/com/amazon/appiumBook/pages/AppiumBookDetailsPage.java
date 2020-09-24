package CucumberProject.com.amazon.appiumBook.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class AppiumBookDetailsPage {

    private By comparisonChartLocator=By.id("comparison-chart");
    private By appiumBookDescriptionLocator=By.cssSelector("#productTitle");
    private By appiumBookRatingLocator=By.xpath("(//span[@id='acrPopover'] /span) [1]/a/i/span");
    private By appiumBookAddToCartLocator= By.xpath("//span[@id='submit.add-to-cart']/span/input");
    private By appiumBookPriceLocator= By.xpath("//*[@id='hlb-subcart']/div[1]/span/span[2]");
    public WebDriver driver;

    public WebElement getComparisonChartLocator()
    {
        return driver.findElement(comparisonChartLocator);
    }
    public WebElement getsAppiumBookDescriptionLocator()
    {
        return driver.findElement(appiumBookDescriptionLocator);
    }
    public WebElement getAppiumBookRatingLocator()
    {
        return driver.findElement(appiumBookRatingLocator);
    }
    public WebElement getAppiumBookAddToCartLocator()
    {
        return driver.findElement(appiumBookAddToCartLocator);
    }
    public WebElement getAppiumBookPriceLocator()
    {
        return driver.findElement(appiumBookPriceLocator);
    }


    public AppiumBookDetailsPage(WebDriver driver) {
        this.driver=driver;
    }
    public boolean verifyComparisonChartIsDisplayed(){
        System.out.println("Verifying whether the comparison Chart is displayed on the iphone details page");
        return getComparisonChartLocator().isDisplayed();
    }

    public void addToCart(){
        System.out.println("Adding Book to the cart");
        if (getAppiumBookAddToCartLocator().isEnabled()){
            System.out.println("The button is enabled, item is ready to be added to the Cart!");
            getAppiumBookAddToCartLocator().click();
            System.out.println("Book successfully added to cart");
        } else
            System.out.println("Add to cart button is not enabled");

    }

    public String getBookRating(){
        System.out.println("Fetching the rating of the Book....");
        return getAppiumBookRatingLocator().getAttribute("textContent");
    }

    public String getAppiumBookDescription() {
        System.out.println("Fetching the name of the Book..");
        return getsAppiumBookDescriptionLocator().getText();
    }

    public String getAppiumBookPrice() {
        System.out.println("Fetching the price of the Book..");
        return getAppiumBookPriceLocator().getText();
    }

}
