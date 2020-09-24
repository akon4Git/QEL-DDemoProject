package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners implements ITestListener {
   Logger log;
   String testName;
   String testMethodName;

    @Override
    public void onTestStart(ITestResult result) {
        this.testMethodName=result.getMethod().getMethodName();
        log.info("[Starting "+testMethodName +"]");

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        this.testMethodName=result.getMethod().getMethodName();
        log.info("[Test "+testMethodName +"passed]");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        this.testMethodName=result.getMethod().getMethodName();
        log.info("[Test "+testMethodName +"failed]");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    @Override
    public void onStart(ITestContext context) {
    this.testName=context.getCurrentXmlTest().getName();
    this.log= LogManager.getLogger(testName);
        log.info("[Test "+testName +"Started]");
    }

    @Override
    public void onFinish(ITestContext context) {
        this.testName=context.getCurrentXmlTest().getName();
        this.log= LogManager.getLogger(testName);
        log.info("[All "+testName +"Finished]");
    }
}
