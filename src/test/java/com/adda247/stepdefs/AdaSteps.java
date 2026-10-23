package com.adda247.stepdefs;

import com.adda247.driver.DriverFactory;
import com.adda247.pages.ExamCategoryPage;
import com.adda247.pages.HomePage;
import com.adda247.pages.LoginPage;
import com.adda247.pages.SearchResultsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

/** One instance per scenario (PicoContainer) so page state is never shared between scenarios. */
public class AdaSteps {

    private HomePage homePage;
    private SearchResultsPage searchResultsPage;
    private LoginPage loginPage;
    private ExamCategoryPage categoryPage;

    @Given("the user is on the Adda247 home page")
    public void userOnHomePage() {
        homePage = new HomePage(DriverFactory.getDriver());
    }

    @Then("the page title should contain {string}")
    public void titleShouldContain(String text) {
        Assert.assertTrue(homePage.getTitle().toLowerCase().contains(text.toLowerCase()),
                "Unexpected title: " + homePage.getTitle());
    }

    @Then("the Adda247 logo should be displayed")
    public void logoDisplayed() {
        Assert.assertTrue(homePage.isLogoDisplayed(), "Logo not displayed");
    }

    @When("the user searches for {string}")
    public void searchFor(String keyword) {
        searchResultsPage = homePage.searchFor(keyword);
    }

    @Then("search results related to {string} should be displayed")
    public void resultsDisplayed(String keyword) {
        Assert.assertTrue(searchResultsPage.hasResults() || searchResultsPage.pageMentions(keyword));
    }

    @When("the user clicks on the login button")
    public void clickLogin() {
        loginPage = homePage.clickLogin();
    }

    @Then("the login form should be displayed")
    public void loginFormDisplayed() {
        Assert.assertTrue(loginPage.isLoginFormDisplayed(), "Login form not displayed");
    }

    @When("the user opens the {string} category from the navigation")
    public void openCategory(String name) {
        categoryPage = homePage.openCategory(name);
    }

    @Then("the {string} category page should be displayed")
    public void categoryDisplayed(String name) {
        Assert.assertTrue(categoryPage.isOnCategory(name), "Not on category page: " + name);
    }
}
