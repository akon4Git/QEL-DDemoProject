package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

@Listeners({base.TestListeners.class})
    public class BaseTest {
    protected WebDriver driver;
    protected Logger log;
    protected String testSuiteName;
    protected String testName;
    protected String testMethodName;

    @Parameters({"browser", "chromeOption"})
   @BeforeMethod(alwaysRun = true)
   public void setUp(Method method, @Optional("chrome") String browser, @Optional String profile, ITestContext ctx) {

        String testName = ctx.getCurrentXmlTest().getName();
        log = LogManager.getLogger(testName);
        BrowserDriverFactory factory = new BrowserDriverFactory(browser, log);
        if (profile != null) {
            driver = factory.createDriverWithProfile(profile);
        } else {
            driver = factory.createDriver();
        }

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        this.testSuiteName = ctx.getSuite().getName();
        this.testMethodName = method.getName();
        this.testName = testName;
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        log.info("Close driver");
        // Close browser
        driver.quit();
    }
}