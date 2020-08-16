package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.DiscourseDemoPage;
import pages.DiscourseMainPage;
import util.Constants;
import util.DriverFactory;

public class DiscourseSteps {

    private final WebDriver driver = DriverFactory.getDriver();
    private final DiscourseMainPage discourseMainPage = new DiscourseMainPage(driver);
    private final DiscourseDemoPage discourseDemoPage = new DiscourseDemoPage(driver);

    @Given("I open Discourse main page")
    public void openDiscourseMainPage() {
        driver.get(Constants.DISCOURSE_MAIN_URL);
        driver.manage().window().maximize();
    }

    @When("I click on the Demo option in the main menu")
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
