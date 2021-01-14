package configsdriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class BaseDriver {

    //WaiterVariables
    public static WebDriverWait waiter;

    //WebDriverVariables
    public static WebDriver driver;

    //ExtentReportVariables
    public static ExtentReports extent;
    public static ExtentTest scenarioDef;
    public static ExtentTest features;
    public static String reportLocation = "./reports/";

    public static WebDriver getDriver() {
        return driver;
    }

    public static WebDriver newbornWebDriver() throws IOException {

        //FileHanddlerVariables
        Properties properties;
        properties = new Properties();
        try (FileInputStream propertiesFile = new FileInputStream("./drivers/driver.properties")) {
            properties.load(propertiesFile);
        }

        //Invocar al driver
        System.out.println("Chrome Browser detected on file");
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
        driver = new ChromeDriver();


        //Setting Other stuff
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        waiter = new WebDriverWait(driver, Integer.parseInt(properties.getProperty("waiterTime")));

        return driver;
    }

}
