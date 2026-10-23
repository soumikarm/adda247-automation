package com.adda247.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage extends BasePage {

    private final By resultItems = By.cssSelector("a[href*='/product'], a[href*='/p/'], .search-results a, [class*='card'] a");
    private final By pageBody = By.tagName("body");

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public boolean hasResults() {
        wait.until(d -> !findAll(resultItems).isEmpty());
        return true;
    }

    public boolean urlContains(String text) {
        return wait.until(d -> d.getCurrentUrl().toLowerCase().contains(text.toLowerCase()));
    }

    public boolean pageMentions(String text) {
        return getText(pageBody).toLowerCase().contains(text.toLowerCase());
    }
}
