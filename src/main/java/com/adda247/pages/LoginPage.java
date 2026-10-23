package com.adda247.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By mobileInput = By.cssSelector("input[type='tel'], input[placeholder*='mobile' i], input[placeholder*='phone' i]");
    private final By loginDialog = By.cssSelector("[role='dialog'], [class*='modal'], [class*='login']");
    private final By submitButton = By.xpath("//button[contains(normalize-space(),'Continue') or contains(normalize-space(),'Login') or contains(normalize-space(),'OTP')]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoginFormDisplayed() {
        return isDisplayed(mobileInput) || isDisplayed(loginDialog);
    }

    public LoginPage enterMobileNumber(String mobile) {
        type(mobileInput, mobile);
        return this;
    }

    public void submit() {
        click(submitButton);
    }
}
