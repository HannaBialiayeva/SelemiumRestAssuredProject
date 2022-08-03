package com.itacademy.onliner.framework.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;

public class WebDriverDiscovery {

    private static final RemoteWebDriver CHROME = new ChromeDriver();
    private static final int DURATION_OF_WAITING = 15;

    //    private static final RemoteWebDriver FIREFOX = new FirefoxDriver();

    private static ThreadLocal <RemoteWebDriver> remoteWebDriverThreadLocal = new ThreadLocal<>();


    public WebDriverDiscovery() {
        if (remoteWebDriverThreadLocal.get() == null){
            startBrowser();

        }
    }
    private void startBrowser() {
        setWebDriver(CHROME);
    }

    private static void setWebDriver(RemoteWebDriver driver) {
        remoteWebDriverThreadLocal.set(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(DURATION_OF_WAITING));
    }

    public WebDriver getWebDriver(){
       return remoteWebDriverThreadLocal.get();
    }

}
