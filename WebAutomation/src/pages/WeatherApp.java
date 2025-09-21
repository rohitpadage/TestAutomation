package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import java.time.Duration;
import java.util.NoSuchElementException;

public class WeatherApp {

    WebDriver driver;
    FluentWait<WebDriver> wait;

    By appTitleLocator = By.id("app-title");

    public WeatherApp(WebDriver driver) {
        this.driver = driver;
        // FluentWait allows polling and ignoring exceptions
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(120))  // max total wait time
                .pollingEvery(Duration.ofSeconds(5))  // check every 5 seconds
                .ignoring(NoSuchElementException.class);
    }

    public String getWeatherAppTitle() {
        // Wait until the element is visible
        WebElement titleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(appTitleLocator));
        return titleElement.getText();
    }
}
