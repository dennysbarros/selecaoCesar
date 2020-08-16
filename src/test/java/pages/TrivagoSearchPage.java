package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.DriverFactory;
import util.WebDriverUtils;

import java.util.List;

public class TrivagoSearchPage {
    private final WebDriverWait wait;
    private final WebDriver driver;
    private final WebDriverUtils util;
    private final String secondItemLocator = "section li:nth-child(2) article[data-qa=itemlist-element]";
    private final By placeSearchInput = By.cssSelector("form input[type=search]");
    private final By placeSearchButton = By.cssSelector("button[data-qa=search-button]");
    private final By guestsButton = By.cssSelector("form button.js-dealform-button-guests");
    private final By removeAdultButton = By.cssSelector("button[data-role=removeAdult]");
    private final By confirmGuestsButton = By.cssSelector("button[data-role=applyConfigBtn]");
    private final By sortBySelect = By.cssSelector("#mf-select-sortby");
    private final By resultsLoader = By.cssSelector("section[data-qa=itemlist] span.loader-text");
    private final By placeSuggestions = By.cssSelector("div.js-suggestions ul.ssg-suggestions");
    private final By roomAmenitiesLink = By.cssSelector(secondItemLocator + " div.expand-amenities button");
    private final By secondItemHotelName = By.cssSelector(secondItemLocator +
            " span[data-qa=item-name]");
    private final By secondItemHotelStars = By.cssSelector(secondItemLocator +
            " div.stars-wrp span");
    private final By secondHotelRecommendedPrice = By.cssSelector(secondItemLocator +
            " strong[data-qa=recommended-price]");
    private final By secondHotelRecommendedPricePartner = By.cssSelector(secondItemLocator +
            " h3 span[data-qa=recommended-price-partner]");
    private final By secondHotelLocation = By.cssSelector(secondItemLocator +
            " div[data-qa=item-location-details]");
    private final By roomAmenities = By.cssSelector(secondItemLocator +
            " div.all-amenities__group:nth-child(2) li");

    public TrivagoSearchPage(WebDriver driver) {
        this.driver = driver;
        util = new WebDriverUtils(driver);
        wait = DriverFactory.getWait();
    }

    public void printRoomAmenities() {
        util.scrollDown();
        util.waitAndClick(roomAmenitiesLink);

        List<WebElement> roomAmenitiesList = driver.findElements(roomAmenities);

        System.out.println("Room amenities: ");

        for (WebElement amenity : roomAmenitiesList) {
            wait.until(ExpectedConditions.visibilityOf(amenity));
            System.out.println("- " + amenity.getText());
        }
    }

    public void clickLocationOption() {
        util.scrollDown();
        util.waitAndClick(secondHotelLocation);
    }

    public void searchPlace(String place) {
        util.waitAndSendKeys(placeSearchInput, place);
        wait.until(ExpectedConditions.visibilityOfElementLocated(placeSuggestions));
        util.waitAndClick(placeSearchButton);
        _waitResultsToLoad();
    }

    public void chooseSingleRoom() {
        util.waitAndClick(guestsButton);
        util.waitAndClick(removeAdultButton);
        util.waitAndClick(confirmGuestsButton);
        _waitResultsToLoad();
    }

    public void printSecondItemHotelName() {
        System.out.println("Name: " + util.getTextFromLocator(secondItemHotelName));
    }

    public void printNumberOfStars() {
        List<WebElement> numberOfStars = driver.findElements(secondItemHotelStars);

        if (numberOfStars.size() == 0) {
            System.out.println("Stars: The number of stars is not provided");
        } else {
            System.out.println("Stars: " + numberOfStars.size());
        }
    }

    public void printRecommendedPrice() {
        System.out.println("Preço: " + util.getTextFromLocator(secondHotelRecommendedPrice));
    }

    public void printRecommendedPricePartner() {
        System.out.println("Oferta da empresa: " + util.getTextFromLocator(secondHotelRecommendedPricePartner));
    }

    public void sortByDistanceOnly() {
        util.selectByValue(sortBySelect, "3");
        _waitResultsToLoad();
    }

    private void _waitResultsToLoad() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(resultsLoader));
        wait.until(ExpectedConditions.stalenessOf(driver.findElement(resultsLoader)));
    }
}
