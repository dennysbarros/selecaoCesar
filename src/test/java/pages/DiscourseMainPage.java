package pages;

import org.openqa.selenium.By;
import util.WebDriverUtils;

public class DiscourseMainPage {
    private final WebDriverUtils util = new WebDriverUtils();
    private final By demoMenuOption = By.cssSelector("#main > ul > li:nth-child(4) a");

    public void clickDemoMenuOption(){
        util.waitAndClick(demoMenuOption);
        util.switchToTab();
    }
}
