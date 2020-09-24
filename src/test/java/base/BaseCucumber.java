package base;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseCucumber {

    public WebDriver driver;
    public Properties prop;
    public WebDriver initializeDriver() throws IOException  {

        prop= new Properties();
        FileInputStream fis=new FileInputStream("C:\\Users\\akonchada\\Documents\\Anusha\\SeProjects\\FinalQEAssignment\\src\\test\\resources\\data.properties");

        prop.load(fis);
        String browserName=prop.getProperty("browser");
        System.out.println("Using Browser:"+browserName);

        if(browserName.equals("chrome"))
        {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            driver= new ChromeDriver();
            //execute in chrome driver

        }
        else if (browserName.equals("firefox"))
        {
            driver= new FirefoxDriver();
            //firefox code
        }
        else if (browserName.equals("IE"))
        {
        //	IE code
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;

    }

    public void getScreenshot(String result) throws IOException
    {
        File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("C://test//"+result+"screenshot.png"));

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
    protected void waitFor(ExpectedCondition<WebElement> condition, Integer timeOutInSeconds){
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


}
