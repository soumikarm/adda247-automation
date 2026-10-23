package com.adda247.hooks;

import com.adda247.config.ConfigReader;
import com.adda247.driver.DriverFactory;
import com.adda247.utils.ScreenshotUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    @Before
    public void setUp() {
        DriverFactory.initDriver();
        DriverFactory.getDriver().get(ConfigReader.get("base.url"));
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            scenario.attach(ScreenshotUtil.capture(DriverFactory.getDriver()), "image/png", scenario.getName());
        }
        DriverFactory.quitDriver();
    }
}
