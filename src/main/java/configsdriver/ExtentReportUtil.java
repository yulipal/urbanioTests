package configsdriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Timestamp;

public class ExtentReportUtil extends BaseDriver {

    public static String fileName = reportLocation + "extentReport.html";
    public static String scenarioName, scenarioID, screenshotTimeStamp, currentScreenshotLocation, browserConsoleLogs;


    public void createExtentReport() {
        extent = new ExtentReports();
        ExtentSparkReporter reporter = new ExtentSparkReporter(fileName);
        reporter.config().setTheme(Theme.DARK);
        reporter.config().setReportName("Open20Regression");
        reporter.config().setEncoding("utf-8");
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Pablo Avila");
    }

    public void takeScreenshot() throws IOException {
        //Time Stamp process
        Timestamp screenshotTime = new Timestamp(System.currentTimeMillis());
        screenshotTimeStamp = screenshotTime.toString();
        System.out.println("Screenshot time content: " + screenshotTime.toString());

        //Screenshot process
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Files.copy(src.toPath(), new File(reportLocation + "screenshots/" + screenshotTime.toString() + ".png").toPath());
        //currentScreenshotLocation = System.getProperty("user.dir") + "/reports/screenshots/" + screenshotTimeStamp + ".png";
        currentScreenshotLocation = "screenshots/" + screenshotTimeStamp + ".png";
        System.out.println("current Screenshot location: " + currentScreenshotLocation);

    }

    public void deleteScreenshots() {
        try {

            File screenshotFolder = new File(reportLocation + "screenshots");
            FileUtils.cleanDirectory(screenshotFolder);
            System.out.println("Screenshot deleted...");
        } catch (Exception e) {
            System.out.println("Current screenshot not deleted, something wrong happened...");
        }


    }

    public void flushReport() {
        extent.flush();
    }

}
