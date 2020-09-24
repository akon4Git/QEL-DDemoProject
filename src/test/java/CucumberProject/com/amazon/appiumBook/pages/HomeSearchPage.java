package CucumberProject.com.amazon.appiumBook.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomeSearchPage  {

    private String pageUrl="https://www.amazon.com/";
    private By inputSearchLocator= By.id("twotabsearchtextbox");
    private By searchButtonLocator=By.xpath("//input[@type='submit' and @value='Go']");
    public WebDriver driver;

    public HomeSearchPage(WebDriver driver) {
           this.driver=driver;
    }
    public WebElement getInputSearchLocator()
    {
        return driver.findElement(inputSearchLocator);
    }
    public WebElement getsearchButtonLocator()
    {
        return driver.findElement(searchButtonLocator);
    }

   }