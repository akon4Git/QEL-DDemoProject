package utilities;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class BasePageObject {

    protected WebDriver driver;
    protected Logger log;

    public BasePageObject(WebDriver driver, Logger log){
        this.driver=driver;
        this.log=log;
    }

    protected void openUrl(String url){
        driver.get(url);
    }

    protected WebElement find(By locator){
        return driver.findElement(locator);
    }

    protected List<WebElement> findAll(By locator){
        return driver.findElements(locator);
    }

    protected void click(By locator){
        waitForVisibilityOf(locator,5);
        find(locator).click();

    }
    protected void type(By locator, String textValue){
        waitForVisibilityOf(locator,5);
        find(locator).sendKeys(textValue);
    }

    //wait for specific condition for the given amount of time on the page
    protected void waitFor(ExpectedCondition<WebElement> condition,Integer timeOutInSeconds){
       timeOutInSeconds= timeOutInSeconds!= null ? timeOutInSeconds:30;
        WebDriverWait wait= new WebDriverWait(driver,timeOutInSeconds);
        wait.until(condition);

    }

    //wait for given number of seconds for element to be visible on the page
    protected void waitForVisibilityOf(By locator, Integer... timeOutInSeconds){
        int attempts=0;
        while(attempts < 0){
            try {
                waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
                        timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : null);
                break;
            }
            catch(StaleElementReferenceException e){
                e.printStackTrace();
            }
            attempts++;
        }


    }

    public String getCurrentPageTitle(){
        return driver.getTitle();
    }

    public void switchToWindowithTitle(String expectedTitle){
        String firstWindowHandle=driver.getWindowHandle();
        Set<String> allHandles= driver.getWindowHandles();
        Iterator windowsIterator= allHandles.iterator();

        while(windowsIterator.hasNext()){
            String windowHandle= windowsIterator.next().toString();
            if(!windowHandle.equals(firstWindowHandle)) {
                driver.switchTo().window(windowHandle);
                if (getCurrentPageTitle().equals(expectedTitle))
                    break;
            }
        }
    }

    public void switchToWindow(){
    // Store the current window handle
    String winHandleBefore = driver.getWindowHandle();

    // Perform the click operation that opens new window
    // Switch to new window opened
            for(String winHandle : driver.getWindowHandles()){
                driver.switchTo().window(winHandle);
            }
    }

    public void scrolltoBottom() {
        log.info("Scrolling to the bottom of the page");
        JavascriptExecutor jsExecutor= (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }


}
