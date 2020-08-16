package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.WebDriverUtils;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DiscourseDemoPage {
    private final WebDriver driver;
    private final WebDriverUtils util;
    private final By footerMessage = By.cssSelector(".footer-message");
    private final By viewTitle = By.cssSelector(".views span[title]");
    private final By byCategoryItems = By.cssSelector(".link-bottom-line .category-name");
    private final By lockedItem = By.xpath("//*[contains(@class,'locked')]" +
            "/ancestor::div/following-sibling::a");
    private final By byNoCategoryItems = By.xpath("//tr//div[@class='link-bottom-line']" +
            "[not(.//a//span[@class='category-name'])]");

    public DiscourseDemoPage(WebDriver driver) {
        this.driver = driver;
        util = new WebDriverUtils(driver);
    }

    public void scrollUntilTheEndOfThePage() {
        while (!util.isElementPresent(footerMessage)) {
            util.scrollUntilTheEnd();
        }
        util.scrollUntilTheEnd();
    }

    public void printAllLockedItems() {
        List<WebElement> allLockedItems = driver.findElements(lockedItem);

        for (WebElement lockedItem : allLockedItems) {
            System.out.println("Locked item description: " + lockedItem.getText());
        }
    }

    public void printAllNumberOfItemsByCategory() {
        List<WebElement> allCategoryItems = driver.findElements(byCategoryItems);
        List<WebElement> noCategoryItems = driver.findElements(byNoCategoryItems);
        List<String> categoryItems = new ArrayList<>();

        //Adds the text of each item of allCategoryItems into categoryItems list
        for (WebElement categoryItem : allCategoryItems) {
            categoryItems.add(categoryItem.getText());
        }

        /*
        * Creates a new list of strings (uniqueCategories)
        * based on categoryItem but eliminating duplicates
        */
        List<String> uniqueCategories = categoryItems.stream().
                distinct().collect(Collectors.toList());

        /*
        * For each item of uniqueCategories, check the occurrences
        * inside categoryItems and print
        */
        for (int index = 0; index < uniqueCategories.size(); index++) {
            int occurrences = Collections.frequency
                    (categoryItems, uniqueCategories.get(index));

            System.out.println("Number of items of "
                    + uniqueCategories.get(index) + ": " + occurrences);
        }

        System.out.println("Number of items with no categories: "
                + noCategoryItems.size());
    }

    public void getTitleOfMostViewedItem() {
        List<WebElement> allViews = driver.findElements(viewTitle);
        List<Integer> allNumbers = new ArrayList<>();

        /*
        * Extract the title attribute of each view in the table,
        * delete chars that are not digits and add to allNumbers list
        */
        for (WebElement view : allViews) {
            String viewFormatted = util.replaceStringByRegex
                    (view.getAttribute("title"), "\\D+", "");

            allNumbers.add(Integer.parseInt(viewFormatted));
        }

        String highestNumber = _getHighestNumberOfList(allNumbers);

        By byTitleOfMostViewedTopic = By.xpath("//span[contains(@title,'"
                + highestNumber + "')]/ancestor::tr//td//span/a");

        System.out.println("Title of the most viewed topic: " +
                util.getTextFromLocator(byTitleOfMostViewedTopic));
    }

    /**
     * @param listOfNumbers list of integers
     * @return a string with the highest number of the list, but adding the comma back to the string
     * @author Dennys Barros
     */
    private String _getHighestNumberOfList(List<Integer> listOfNumbers) {
        DecimalFormat formatter = new DecimalFormat("#,###");
        return formatter.format(Collections.max(listOfNumbers));
    }
}
