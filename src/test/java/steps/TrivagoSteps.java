package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.TrivagoSearchPage;
import util.Constants;
import util.DriverFactory;

public class TrivagoSteps {

    private final WebDriver driver = DriverFactory.getDriver();
    private final TrivagoSearchPage trivagoSearchPage = new TrivagoSearchPage(driver);

    @Given("I open Trivago main page")
    public void openTrivagoMainPage() {
        driver.get(Constants.TRIVAGO_MAIN_URL);
        driver.manage().window().maximize();
    }

    @When("I search for {string} in the search field")
    public void searchForPlace(String place) {
        trivagoSearchPage.searchPlace(place);
    }

    @When("I set the guest configuration as single room")
    public void setSingleRoomOptions() {
        trivagoSearchPage.chooseSingleRoom();
    }

    @When("I sort the results by distance only")
    public void sortByDistanceOnly() {
        trivagoSearchPage.sortByDistanceOnly();
    }

    @Then("I should print the second hotel name")
    public void printSecondHotelName() {
        trivagoSearchPage.printSecondItemHotelName();
    }

    @Then("I should print the number of the hotel stars")
    public void printTheNumberOfStars() {
        trivagoSearchPage.printNumberOfStars();
    }

    @Then("I should print the name of the offer site")
    public void printRecommendedPricePartner() {
        trivagoSearchPage.printRecommendedPricePartner();
    }

    @Then("I should print the room price")
    public void printRecommendedPrice() {
        trivagoSearchPage.printRecommendedPrice();
    }

    @Then("I should print all room amenities")
    public void printRoomAmenities() {
        trivagoSearchPage.clickLocationOption();
        trivagoSearchPage.printRoomAmenities();
    }
}
