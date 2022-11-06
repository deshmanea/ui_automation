package com.clipboard.ui.steps;

import com.clipboard.ui.pages.ElectronicsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

public class ElectronicsPageSteps {

    private static final Logger logger = LogManager.getLogger();
    @Autowired
    ElectronicsPage electronicsPage;

    @And("Filter result by price high to low, select {string} result")
    public synchronized void filterResultByPriceHighToLowSelectResult(String result_num) {
        electronicsPage.filterProductByHighToLow();
        electronicsPage.selectProduct(result_num);
    }

    @Then("User should be able to see {string}")
    public synchronized void userShouldBeAbleToSee(String details) {

    }
}
