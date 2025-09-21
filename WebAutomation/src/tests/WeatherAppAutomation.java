

package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WeatherApp;

public class WeatherAppAutomation extends BaseTest {

    @Test
    public void ValidateWeatherAppTitle() {
        test = extent.createTest("WeatherApp HomePage", "Verify Weather App title");

        WeatherApp page = new WeatherApp(driver);

        String title = page.getWeatherAppTitle();
        test.info("Page title: " + title);

        Assert.assertTrue(title.contains("Smart Weather App"),
                "Page does not contain the expected text 'Smart Weather App'");
        test.pass("Title verified successfully");
    }

    
}
