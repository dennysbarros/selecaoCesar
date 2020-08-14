package util;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtils {

    private static final WebDriver driver = DriverFactory.getDriver();;
    private static final WebDriverWait wait = DriverFactory.getWait();
    private static final Actions action = new Actions(driver);

    public void waitAndClick(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    public void waitAndSendKeys(By locator, String keys) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).sendKeys(keys);
    }

    public void mouseOverElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        action.moveToElement(element).perform();
    }

    public void mouseOverElement(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        WebElement element = driver.findElement(locator);
        action.moveToElement(element).perform();
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() != 0;
    }

    public void scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,450)", "");
    }
}
