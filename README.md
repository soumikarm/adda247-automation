# Adda247 UI Automation Framework

Java 17 · Selenium 4 · Cucumber 7 · TestNG · Maven · Page Object Model

## Structure
```
src/main/java/com/adda247
  config/ConfigReader      – config.properties + -D overrides
  driver/DriverFactory     – ThreadLocal WebDriver (chrome/firefox/edge, headless)
  pages/                   – BasePage + HomePage, SearchResultsPage, LoginPage, ExamCategoryPage
  utils/ScreenshotUtil
src/test/java/com/adda247
  hooks/Hooks              – driver lifecycle, screenshot on failure
  stepdefs/AdaSteps        – step definitions (delegate to pages only)
  runners/TestRunner       – TestNG Cucumber runner
src/test/resources
  features/*.feature, config.properties
```

## Run
```
mvn clean test
mvn test -Dbrowser=firefox -Dheadless=true
mvn test -Dcucumber.filter.tags="@smoke"
```
Reports: `target/cucumber-reports/report.html`.

## Extending
1. Add a page class extending `BasePage` (locators private, actions public, return next page).
2. Add steps in a new `*Steps` class under `stepdefs` (PicoContainer injects per scenario).
3. Add scenarios to `features/`.
4. Parallel: set `parallel = true` on the runner DataProvider and `data-provider-thread-count` in `testng.xml`.

## Note
Locators are generic best guesses written without access to the live DOM; the site is dynamic, so
verify/adjust them in the page classes on first run (only the page classes need changes).
