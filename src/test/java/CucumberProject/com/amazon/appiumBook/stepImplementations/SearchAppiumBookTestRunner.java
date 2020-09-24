package CucumberProject.com.amazon.appiumBook.stepImplementations;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features={"src/test/resources/features"},
        glue={"CucumberProject/com/amazon/appiumBook/stepImplementations"})

public class SearchAppiumBookTestRunner extends AbstractTestNGCucumberTests{


}
