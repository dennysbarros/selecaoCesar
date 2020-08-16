package util;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class WebDriverUtils {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final JavascriptExecutor js;

    public WebDriverUtils(WebDriver driver) {
        this.driver = driver;
        wait = DriverFactory.getWait();
        js = (JavascriptExecutor) driver;
    }

    public void waitAndClick(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    public void waitAndSendKeys(By locator, String keys) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).sendKeys(keys);
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() != 0;
    }

    public void scrollDown() {
        js.executeScript("window.scrollBy(0,350)", "");
    }

    public void scrollUntilTheEnd() {
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void switchToTab() {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    public String replaceStringByRegex(String string, String regex, String replacement) {
        return string.replaceAll(regex, replacement);
    }

    public void selectByValue(By locator, String value) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        Select select = new Select(driver.findElement(locator));
        select.selectByValue(value);
    }

    public String getTextFromLocator(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator).getText();
    }
}
