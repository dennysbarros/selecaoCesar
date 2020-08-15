package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.DiscourseDemoPage;
import pages.DiscourseMainPage;
import util.Constants;
import util.DriverFactory;
import util.WebDriverUtils;

public class DiscourseSteps {

    private static final WebDriver driver = DriverFactory.getDriver();
    private static final WebDriverUtils util = new WebDriverUtils();
    private final DiscourseMainPage discourseMainPage = new DiscourseMainPage();
    private final DiscourseDemoPage discourseDemoPage = new DiscourseDemoPage();

    @Given("I open the discourse main page")
    public void openDiscourseMainPage() {
        driver.get(Constants.DISCOURSE_MAIN_URL);
        driver.manage().window().maximize();
    }

    @When("I click in the Demo option in the main menu")
    public void clickDemoOptionFromMainMenu() {
        discourseMainPage.clickDemoMenuOption();
    }

    @When("I scroll until the end of the page")
    public void scrollUntilTheEndOfThePage() {
        discourseDemoPage.scrollUntilTheEndOfThePage();
    }

    @Then("I should print the description of all locked topics")
    public void printDescriptionOfLockedItems() {
        discourseDemoPage.printAllLockedItems();
    }

    @Then("I should print the number of items of each category")
    public void printNumberOfItemsOfEachCategory() {
        discourseDemoPage.printAllNumberOfItemsByCategory();
    }

    @Then("I should print the title of the topic with more views")
    public void printTitleOfMostViewedTopic() {
        discourseDemoPage.getTitleOfMostViewedItem();
    }
}