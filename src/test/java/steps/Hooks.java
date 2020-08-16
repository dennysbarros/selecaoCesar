package steps;

import io.cucumber.java.After;
import util.DriverFactory;

public class Hooks {

    @After(order = 0)
    public static void quitDriver() {
        DriverFactory.quitDriver();
    }
}
