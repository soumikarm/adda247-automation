package com.adda247.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private final By logo = By.cssSelector("a[href='/'] img, header img");
    private final By searchBox = By.cssSelector("input[type='search'], input[placeholder*='Search' i]");
    private final By loginButton = By.xpath("//*[self::a or self::button or self::span][normalize-space()='Login' or normalize-space()='Login/Register']");
    private final By navLinks = By.cssSelector("header a, nav a");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isLogoDisplayed() {
        return isDisplayed(logo);
    }

    public SearchResultsPage searchFor(String keyword) {
        typeAndEnter(searchBox, keyword);
        return new SearchResultsPage(driver);
    }

    public LoginPage clickLogin() {
        click(loginButton);
        return new LoginPage(driver);
    }

    public ExamCategoryPage openCategory(String categoryName) {
        By category = By.xpath("(//header//a | //nav//a)[normalize-space()='" + categoryName + "' or contains(normalize-space(),'" + categoryName + "')]");
        click(category);
        return new ExamCategoryPage(driver);
    }

    public int getNavigationLinkCount() {
        return findAll(navLinks).size();
    }
}
