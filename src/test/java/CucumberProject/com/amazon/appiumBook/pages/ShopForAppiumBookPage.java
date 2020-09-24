package CucumberProject.com.amazon.appiumBook.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BasePageObject;

public class ShopForAppiumBookPage {
    public WebDriver driver;
    private By shopBookLocator=By.cssSelector(".a-section.a-spacing-none .a-size-mini span");

        public ShopForAppiumBookPage(WebDriver driver) {
        this.driver=driver;
    }

    public WebElement getshopBookLocator()
    {
        return driver.findElement(shopBookLocator);
    }




}
