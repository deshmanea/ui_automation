package com.clipboard.ui.steps;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import com.clipboard.ui.pages.HomePage;


public class HomePageSteps {
    private static final Logger logger = LogManager.getLogger();

    @Autowired
    RemoteWebDriver driver;

    @Autowired
    HomePage homePage;

    @Given("^User select \"([^\"]*)\" menu with \"([^\"]*)\" submenu$")
    public synchronized void userSelectMenuWithSubmenu(String mainMenu, String subMenu) throws Throwable {
        homePage.selectAllMenu();

    }

    @When("User filter result with {string} brand")
    public synchronized void userFilterResultWithBrand(String brand) {

    }


}
