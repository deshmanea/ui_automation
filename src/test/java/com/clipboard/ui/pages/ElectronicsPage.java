package com.clipboard.ui.pages;

import com.clipboard.ui.models.ShareDetails;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.beans.factory.annotation.Autowired;

public class ElectronicsPage extends BasePage{
    private static final Logger logger = LogManager.getLogger();
    @Autowired
    RemoteWebDriver driver;
    @Autowired
    ShareDetails shareDetails;
    @FindBy(how = How.ID, using = "a-autoid-0-announce")
    private WebElement sortByEle;

    @FindBy(how = How.ID, using = "s-result-sort-select_2" )
    private WebElement highToLowPriceEle;

    @FindBy(how = How.XPATH, using = "//div[@class='a-spinner-wrapper']")
    private WebElement spinnerEle;

    @FindBy(how = How.ID, using = "feature-bullets")
    private WebElement aboutThisItem;

    @FindBy(how = How.ID, using = "productTitle")
    private WebElement productTitleEle;

    @FindBy(how = How.XPATH, using = "//ul[@role='listbox']")
    private WebElement sortOptions;

    public void filterProductByHighToLow(){
        logger.info("Filter product");
        waitForElementToBeVisible(sortByEle);
        scrollIntoView(sortByEle);
        sortByEle.click();
        waitForElementToBeVisible(sortOptions);
        waitForElementToBeVisible(highToLowPriceEle);
        highToLowPriceEle.click();
    }

    public void selectProduct(String result_num){
        logger.info("Selecting product # " + result_num);
        waitForSpinnerToGetDisappear(spinnerEle);
        waitForPresenceOfElement(By.xpath
                ("//div[@data-index='" + result_num + "']"));
        WebElement productEle = driver.findElement(By.xpath
                ("//div[@data-cel-widget='MAIN-SEARCH_RESULTS-" + result_num + "']"));
        productEle.click();
    }

    public String getAboutThisItemText(){
        logger.info("Scrolling to About this item");
        scrollIntoView(aboutThisItem);
        waitForElementToBeVisible(aboutThisItem);
        return aboutThisItem.getText();
    }

    public void switchToNewlyOpenedTab() {
        switchToTab(shareDetails.getParentWindow(), driver.getWindowHandles());
        waitForElementToBeVisible(productTitleEle);
    }

}
