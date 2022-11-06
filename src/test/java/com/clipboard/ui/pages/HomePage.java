package com.clipboard.ui.pages;

import com.clipboard.ui.annotation.PageScope;
import com.clipboard.ui.models.ShareDetails;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Lazy
@PageScope
public class HomePage extends BasePage {
    private static final Logger logger = LogManager.getLogger();

    @Autowired
    private RemoteWebDriver driver;

    @Value("${base.url}")
    private String baseUrl;
    @Autowired
    private WebDriverWait wait;
    @Autowired
    ShareDetails shareDetails;

    @FindBy(how = How.XPATH, using = "//a[@id='nav-hamburger-menu']")
    private WebElement allMenu;

    //    @FindBy(how = How.ID, using = "hmenu-content")
    @FindBy(how = How.XPATH, using = "//div[@id='hmenu-content']/ul[@class='hmenu hmenu-visible']")
    private WebElement menu_content;

    @FindBy(how = How.XPATH, using = "//a[@data-menu-id='9']/div")
    private WebElement tvAppEleMenuEle;

    @FindBy(how = How.XPATH, using = "//li/a[contains(@href,'television')]")
    private WebElement tvMenuEle;

    public void selectAllMenu() {
        logger.info("Clicking on all menu");
        scrollToElementAndClick(allMenu);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", allMenu);
        shareDetails.setParentWindow(driver.getWindowHandle());
        waitForElementToBeVisible(menu_content);
    }

    public synchronized void selectTvAppElectronicsMenu() throws InterruptedException {
        logger.info("Waiting for left menu to load");
        waitForElementToBeVisible(menu_content);
        logger.info("Scrolling to Television Main Menu");
        scrollIntoView(tvAppEleMenuEle);
        Thread.sleep(1000);
        logger.info("Waiting for TV, App, Electronics");
        waitForElementToBeClickable(tvAppEleMenuEle);
        tvAppEleMenuEle.click();

    }

    public synchronized void selectTelevisionMenu() throws InterruptedException {
        logger.info("Waiting for Television menu");
        waitForElementToBeVisible(tvMenuEle);
        waitForElementToBeClickable(tvMenuEle);
        Thread.sleep(1000);
        tvMenuEle.click();
    }

    public synchronized void filterResultWithBrand(String brand) {
        logger.info("Waiting for Brand -> " + brand + " filter");
        String brandLoc = "//a[@class='a-link-normal' and contains(@href, '" + brand + "')]";
        waitForPresenceOfMenuWithBrand(brandLoc);
        WebElement brandEle = getBrandElement(brandLoc);
        scrollIntoView(brandEle);
        brandEle.click();
    }

    private synchronized void waitForPresenceOfMenuWithBrand(String brand) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(brand)));
    }

    private synchronized WebElement getBrandElement(String brand) {
        return driver.findElement(By.xpath(brand));
    }
}