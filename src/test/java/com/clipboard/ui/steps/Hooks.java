package com.clipboard.ui.steps;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class Hooks {
    @Autowired
    private RemoteWebDriver driver;

    @Value("${base.url}")
    private String baseurl;
    private static final Logger logger = LogManager.getLogger();

    @Before
    public void intializeTest(Scenario scenario){
        driver.manage().window().maximize();
        driver.get(baseurl);
        logger.info("Created driver => " + driver.toString());
    }
}
