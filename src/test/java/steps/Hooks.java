package steps;

import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import util.DriverFactory;

public class Hooks {
    private static final WebDriver driver = DriverFactory.getDriver();

    @After(order = 0)
    public static void quitDriver() {
        DriverFactory.quitDriver();
    }
}
