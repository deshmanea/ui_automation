package com.clipboard.ui.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features",
        glue= "com.clipboard.ui.steps",
        plugin = {"pretty","html:target/cucumber-report.html","json:target/cucumber-report/CucumberTestReport.json"},
        monochrome = true
)

public class DemoCucumberTestRunner extends AbstractTestNGCucumberTests {
    @DataProvider(parallel = false)
    @Override
    public Object[][] scenarios() {
        return super.scenarios();
    }

}
