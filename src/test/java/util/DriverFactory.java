package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverFactory {

    protected static WebDriver driver;
    protected static WebDriverWait wait;

    public static WebDriver getDriver() {
        if (driver == null) {
            //Option to avoid Chrome detection so Trivago can work properly
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-blink-features=AutomationControlled");
            
            System.setProperty("webdriver.chrome.driver", "chromedriver");
            driver = new ChromeDriver(options);

            // Add the 2 lines below back if Windows is being used
            // System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            // driver = new ChromeDriver(options);

        }
        return driver;
    }

    public static WebDriverWait getWait() {
        if (wait == null) {
            wait = new WebDriverWait(driver, 10);
        }
        return wait;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            wait = null;
            driver = null;
        }
    }
}
