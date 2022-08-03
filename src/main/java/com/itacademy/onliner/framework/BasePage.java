package com.itacademy.onliner.framework;


import com.itacademy.onliner.framework.driver.WebDriverDiscovery;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class BasePage {
    private static final int WAITING_OF_BROWSER_OPEN = 60;
    private final WebDriver driver;
    private WebDriverDiscovery webDriverDiscovery ;

    public BasePage() {
        webDriverDiscovery = new WebDriverDiscovery() ;
        driver = webDriverDiscovery.getWebDriver();
    }

    public WebElement waitForElementVisible(By by) {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(WAITING_OF_BROWSER_OPEN));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    public void navigate(String url) {
        driver.get(url);
    }

    public void closeBrowser() {
        try {
            driver.quit();
        } catch (Exception e) {
        }
    }

}

