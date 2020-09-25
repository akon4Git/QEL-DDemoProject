package sectionals.livingRoom.Furniture.WayFair.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BasePageObject;

public class SectionalFurnitureDetailsPage extends BasePageObject {

    private By sectionalFurniturePriceLocator(){
        return By.xpath("//div[@class='StandardPriceBlock']/div/span");
    }
    private By sectionalFurnitureDescriptionDetailsLocator(){
        return By.xpath("(//*[@class='ProductDetailInfoBlock-header']/h1[contains(@class,'pageTitle')]) [2]");
    }

    private By addToCartLocator(){
        return By.xpath("//button[@id='btn-add-to-cart']");
    }
    private By continueToCartLocator(){
        return By.xpath("//button[@id='btn-add-to-cart']/span");
    }
    public SectionalFurnitureDetailsPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public String getPriceOfSectionals(){
        log.info("Fetching the price of the sectional furniture:");
        return find(sectionalFurniturePriceLocator()).getText();
    }

    public String getSectionalFurnitureDescriptionDetails(){
        log.info("Fetching the description of the sectional furniture..");
        return find(sectionalFurnitureDescriptionDetailsLocator()).getText();
    }

    public void addToCart(){
        log.info("Adding the selected sectional furniture to the Cart:");
        click(addToCartLocator());
    }

    public boolean verifySectionalAddedToCart(){
       log.info("Verify whether the item was added and user is able to click on the continue to cart button");
       return find(continueToCartLocator()).isEnabled();
    }

}
