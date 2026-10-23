Feature: Adda247 website

  Background:
    Given the user is on the Adda247 home page

  @smoke
  Scenario: Home page loads
    Then the page title should contain "Adda247"
    And the Adda247 logo should be displayed

  @smoke
  Scenario Outline: Search for a course
    When the user searches for "<keyword>"
    Then search results related to "<keyword>" should be displayed

    Examples:
      | keyword |
      | SSC     |
      | Banking |

  @regression
  Scenario: Login form opens
    When the user clicks on the login button
    Then the login form should be displayed

  @regression
  Scenario: Navigate to an exam category
    When the user opens the "SSC" category from the navigation
    Then the "SSC" category page should be displayed
