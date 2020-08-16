package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.WebDriverUtils;

public class DiscourseMainPage {
    private final WebDriverUtils util;
    private final By demoMenuOption = By.cssSelector("#main > ul > li:nth-child(4) a");

    public DiscourseMainPage(WebDriver driver) {
        util = new WebDriverUtils(driver);
    }

    public void clickDemoMenuOption() {
        util.waitAndClick(demoMenuOption);
        util.switchToTab();
    }
}
