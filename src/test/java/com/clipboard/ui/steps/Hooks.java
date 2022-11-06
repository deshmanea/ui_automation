package com.clipboard.ui.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class Hooks {
    private static final Logger logger = LogManager.getLogger();

    @Autowired
    private RemoteWebDriver driver;

    @Value("${base.url}")
    private String baseurl;

    @Value("${screenshot.path}")
    private String screenshotPath;

    @Value("${browser}")
    private String testBrowser;

    @Before
    public void intializeTest(Scenario scenario){
        driver.manage().window().maximize();
        driver.get(baseurl);
        logger.info("Created driver => " + driver.toString());
    }

    @After
    public void closeSafely(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            String FileSeparator = System.getProperty("file.separator");
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String screenshotName = "screenshot_" + testBrowser + "_" + UUID.randomUUID() + ".png";
            String screenShotPath = screenshotPath + FileSeparator + screenshotName;
            File destFile = new File(screenShotPath);
            FileUtils.copyFile(srcFile, destFile);
        }

        driver.quit();
        logger.info("Quitting driver object : " + driver.toString() + " || Closing session : " + driver.getSessionId());
    }
}
