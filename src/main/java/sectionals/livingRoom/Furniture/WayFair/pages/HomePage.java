package sectionals.livingRoom.Furniture.WayFair.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BasePageObject;

public class HomePage extends BasePageObject {

    private String pageUrl="https://www.wayfair.com/";
    private By tab_Furniture= By.linkText("Furniture");
    private By subTab_Sectionals=By.linkText("Sectionals");

    public HomePage(WebDriver driver, Logger log){
        super(driver,log);
    }

    public void openPage(){
        log.info("Opening page:"+ pageUrl);
        openUrl(pageUrl);
        log.info("Page opened");
    }

     public void navigateToFurnitureTab(){
        log.info("Navigating to Furniture Page:"+ pageUrl);
        click(tab_Furniture);
        log.info("Navigated to Furniture");
    }

    public SectionalsFurniturePage clickOnSectionals(){
        log.info("Clicking on Sectionals under Furniture on Home Page");
        click(subTab_Sectionals);
        return new SectionalsFurniturePage(driver,log);
    }

}
