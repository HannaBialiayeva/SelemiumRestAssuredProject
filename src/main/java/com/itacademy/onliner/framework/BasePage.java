package com.itacademy.onliner.framework;


import com.itacademy.onliner.framework.driver.WebDriverDiscovery;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;

public abstract class BasePage {
    private static final int WAITING_OF_BROWSER_OPEN = 60;
    private WebDriver driver;
    private WebDriverDiscovery webDriverDiscovery ;

    protected static final Logger LOG = LoggerFactory.getLogger(BasePage.class);

    public BasePage() {
        webDriverDiscovery = new WebDriverDiscovery() ;
        driver = webDriverDiscovery.getWebDriver();
    }

    public WebElement waitForElementVisible(By by) {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(WAITING_OF_BROWSER_OPEN));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }


    @Step("Find the element")
    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }


    public void navigate(String url) {
        driver.get(url);
    }

    public String getCurrentPageUrl(){
        return driver.getCurrentUrl();
    }

    @Step("Close browser")
    public void closeBrowser() {
        try {
            driver.quit();
        } catch (Exception e) {
            e.getMessage();
            LOG.error("Browser wasn't closed");
        }

    }

}

