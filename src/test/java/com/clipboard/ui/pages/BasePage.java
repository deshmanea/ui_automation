package com.clipboard.ui.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public abstract class BasePage {

    private static final Logger logger = LogManager.getLogger();
    @Autowired
    private RemoteWebDriver driver;
    @Autowired
    private WebDriverWait wait;


    @PostConstruct
    public void initPage(){
        PageFactory.initElements(driver, this);
    }

    public synchronized void scrollToElementAndClick(WebElement element) {
        scrollIntoView(element);
        waitForElementToBeVisible(element);
        waitForElementToBeClickable(element);
        element.click();
    }

    public synchronized void waitForElementToBeClickable(WebElement element){
        logger.info("Waiting for clickable element");
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public synchronized void waitForElementToBeVisible(WebElement element){
        logger.info("Waiting for element");
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public synchronized void waitForPresenceOfElement(By locator){
        logger.info("Waiting for present of element");
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public synchronized void scrollIntoView(WebElement element){
        logger.info("Scrolling to element with Javascript");
        String scrollIntoViewOptions = "{behavior: 'smooth', block: 'center', inline: 'center'}";
        logger.info("Using driver session for scroll : " + driver.getSessionId());
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(" + scrollIntoViewOptions + ")", element);
    }

    public synchronized void waitForSpinnerToGetDisappear(WebElement element){
        logger.info("Waiting for Spinner to disappear");
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

}
