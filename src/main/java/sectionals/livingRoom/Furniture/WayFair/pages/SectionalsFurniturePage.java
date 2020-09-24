package sectionals.livingRoom.Furniture.WayFair.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BasePageObject;

public class SectionalsFurniturePage extends BasePageObject {

    private By sectionalFurnitureLocator(String nth){
        return By.xpath("(//div[@class='ProductCard-details'])["+nth+"]");
    }
    private  By sectionalFurnitureRatingLocator(String nth){
        return By.xpath("(//div[@class='ProductCard-details'])["+nth+"]/div[@class='ProductCard-reviews']/div/p[@class='pl-ReviewStars-reviews']");
    }
    private By sectionalFurnitureDescriptionLocator(String nth){
        return By.xpath("(//div[@class='ProductCard-details'])["+nth+"]/div/h2");
    }

    public SectionalsFurniturePage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void selectSectionalFurniture(String nth){
        log.info("Navigating to "+ nth + "furniture");
        click(sectionalFurnitureLocator(nth));
        log.info("Navigating to "+ nth + "furniture successfully");
    }

    public String getSectionalsDescription(String nth){
        log.info("Fetching description of the sectional furniture positioned at #"+ nth);
        return find(sectionalFurnitureDescriptionLocator(nth)).getText();
    }

    public String getRatingOfSectionals(String nth){
        log.info("Fetching rating of the sectional furniture positioned at "+ nth);
        return find(sectionalFurnitureRatingLocator(nth)).getText();
    }

    public SectionalFurnitureDetailsPage addSectionalFurnitureToCart(String nth){
        log.info("Adding the sectional furniture positioned at "+ nth+" place to the cart");
        click(sectionalFurnitureLocator(nth));
        return new SectionalFurnitureDetailsPage(driver,log);
    }


}
