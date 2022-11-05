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
public class HomePage {
    private static final Logger logger = LogManager.getLogger();

    @Autowired
    private RemoteWebDriver driver;

    @PostConstruct
    public void initPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(how= How.XPATH, using = "//a[@id='nav-hamburger-menu']")
    private WebElement allMenu;

    public void selectAllMenu(){
        logger.info("Clicking on all menu");
        scrollToElementAndClick(allMenu);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", allMenu);
    }

    public synchronized void scrollToElementAndClick(WebElement element) {
        scrollIntoView(element);
        element.click();
    }

    public synchronized void scrollIntoView(WebElement element){
        logger.info("Scrolling to element with Javascript");
        String scrollIntoViewOptions = "{behavior: 'smooth', block: 'center', inline: 'center'}";
        logger.info("Using driver session for scroll : " + driver.getSessionId());
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(" + scrollIntoViewOptions + ")", element);
    }


}
