package com.clipboard.ui.driver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

@Configuration("com.clipboard.ui")
public class WebdriverGenerator {

    @Value("${selenium.hub.url}")
    private String seleniumHubUrl;
    @Value("${browser}")
    private String testBrowser;
    @Value("${wait.time}")
    private int waitTime;
    private RemoteWebDriver driver;

    @Value("${local}")
    private boolean local;

    @Bean
    @Scope("driverscope")
    public RemoteWebDriver getDriver() throws MalformedURLException {
        if(local){
            if (testBrowser.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
                driver = new FirefoxDriver(firefoxOptions);
            } else {
                System.setProperty("webdriver.gecko.driver", "chromedriver.exe");
                driver = new ChromeDriver();
            }
        } else{
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability("browserName", testBrowser);
            desiredCapabilities.setCapability("se:recordVideo","true");
            driver = new RemoteWebDriver(new URL(seleniumHubUrl), desiredCapabilities);
        }

        return driver;
    }

    @Bean
    @Scope("driverscope")
    public WebDriverWait getExplicitWait(){
        return new WebDriverWait(driver, Duration.ofSeconds(waitTime));
    }

}
