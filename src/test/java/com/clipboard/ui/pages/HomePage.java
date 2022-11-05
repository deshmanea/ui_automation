package com.clipboard.ui.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Component
public class HomePage extends BasePage{
    private static final Logger logger = LogManager.getLogger();

    @Autowired
    private RemoteWebDriver driver;

    @FindBy(how= How.XPATH, using = "//a[@id='nav-hamburger-menu']")
    private WebElement allMenu;

    @FindBy(how = How.XPATH, using = "//div[@id='hmenu-content']/ul[@class='hmenu hmenu-visible']")
    private WebElement menu_content;

    @FindBy(how = How.XPATH, using ="//a[@data-menu-id='9']/div")
    private WebElement tvAppEleMenuEle;

    @FindBy(how = How.XPATH, using = "//li/a[contains(@href,'television')]")
    private WebElement tvMenuEle;

    public void selectAllMenu(){
        logger.info("Clicking on all menu");
        scrollToElementAndClick(allMenu);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", allMenu);
        waitForElementToBeVisible(menu_content);
    }
    public void selectTvAppElectronicsMenu() throws InterruptedException {
        logger.info("Waiting for left menu to load");
        waitForElementToBeVisible(menu_content);
        logger.info("Scrolling to Television Main Menu");
        scrollIntoView(tvAppEleMenuEle);
        Thread.sleep(1000);
        logger.info("Waiting for TV, App, Electronics");
        waitForElementToBeClickable(tvAppEleMenuEle);
        tvAppEleMenuEle.click();

    }



}
