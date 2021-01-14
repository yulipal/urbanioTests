package configsdriver;

import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class GeneralListener extends ExtentReportUtil implements ITestListener {


    public void onTestStart(ITestResult result) {
        System.out.println("Passing onTestStartMethod");

    }

    public void onTestSuccess(ITestResult result) {
        //Reporting to Extent Reports
        features = extent.createTest(scenarioName);
        scenarioDef = features.createNode(scenarioName);
        scenarioDef.pass("PASSED");
        scenarioDef.pass("Test successfully passed :)");
        scenarioDef.addScreenCaptureFromPath(currentScreenshotLocation, "Screenshot of the las state of the test");
        scenarioDef.log(Status.PASS, "DRIVER CONSOLE MESSAGES: \n" + browserConsoleLogs);

    }

    public void onTestFailure(ITestResult result) {
        //Reporting to Extent Reports
        features = extent.createTest(scenarioName);
        scenarioDef = features.createNode(scenarioName);
        scenarioDef.fail("FAILED");
        scenarioDef.fail("ScenarioID: " + scenarioID);
        scenarioDef.log(Status.FAIL, "FULL STACK THROWABLE: \n" + result.getThrowable().toString());
        scenarioDef.log(Status.WARNING, "DRIVER CONSOLE MESSAGES: \n" + browserConsoleLogs);
        scenarioDef.addScreenCaptureFromPath(currentScreenshotLocation, "Screenshot of the las state of the test");

    }

    public void onTestSkipped(ITestResult result) {
        features = extent.createTest(scenarioName);
        scenarioDef = features.createNode(scenarioName);
        scenarioDef.info("TEST SKIPED");
        scenarioDef.info("Test faskiped ...");
        scenarioDef.addScreenCaptureFromPath(currentScreenshotLocation, "Screenshot of the las state of the test");
        scenarioDef.log(Status.WARNING, "DRIVER CONSOLE MESSAGES: \n" + browserConsoleLogs);
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        features = extent.createTest(scenarioName);
        scenarioDef = features.createNode(scenarioName);
        scenarioDef.info("onTestFailedButWithinSuccessPercentage");
    }

    public void onTestFailedWithTimeout(ITestResult result) {
        this.onTestFailure(result);
        features = extent.createTest(scenarioName);
        scenarioDef = features.createNode(scenarioName);
        scenarioDef.info("onTestFailedWithTimeout");
    }

    public void onStart(ITestContext context) {
        System.out.println("Passin onStart Method");
        createExtentReport();
        deleteScreenshots();
    }

    public void onFinish(ITestContext context) {
        System.out.println("Passing onFinish");
        flushReport();
    }

}
