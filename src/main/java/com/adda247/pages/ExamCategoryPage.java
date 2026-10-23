package com.adda247.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExamCategoryPage extends BasePage {

    private final By heading = By.cssSelector("h1, h2");

    public ExamCategoryPage(WebDriver driver) {
        super(driver);
    }

    public String getHeading() {
        return getText(heading);
    }

    public boolean isOnCategory(String name) {
        return wait.until(d -> d.getTitle().toLowerCase().contains(name.toLowerCase())
                || d.getCurrentUrl().toLowerCase().contains(name.toLowerCase().replace(" ", "-")));
    }
}
