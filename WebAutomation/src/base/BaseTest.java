
package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import utils.DriverFactory;
import utils.ReportManager;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    protected WebDriver driver;
    protected ExtentReports extent;
    protected ExtentTest test;

    @BeforeSuite
    public void setupReport() {
        extent = ReportManager.getReportInstance();
    }

    @BeforeClass
    public void setupBrowser() {
        driver = DriverFactory.getDriver();
        driver.get("https://weatherapp-6gvw.onrender.com/");
    }

    @AfterClass
    public void tearDown() {
        DriverFactory.quitDriver();
    }

    @AfterSuite
    public void flushReport() {
        extent.flush();
    }
}
