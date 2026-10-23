package com.adda247.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.adda247.stepdefs", "com.adda247.hooks"},
        plugin = {"pretty", "html:target/cucumber-reports/report.html", "json:target/cucumber-reports/report.json"},
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = false) // set true (and configure thread-count in testng.xml) for parallel runs
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
