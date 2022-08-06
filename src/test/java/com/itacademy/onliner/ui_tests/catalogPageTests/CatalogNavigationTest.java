package com.itacademy.onliner.ui_tests.catalogPageTests;

import com.itacademy.onliner.navigation.OnlinerNavigation;
import com.itacademy.onliner.page_object.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CatalogNavigationTest  {

    protected static final Logger LOG = LoggerFactory.getLogger(CatalogNavigationTest.class);

    public HomePage homePage = new HomePage();

    @BeforeAll
    public static void navigateToOnliner() {
        OnlinerNavigation.navigateToOnlinerHomePage();
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Description("User navigates to Onliner Catalog")
    public void testUserIsAbleToNavigateToCatalogPageViaCatalogueLink(){
        homePage.clickOnCatalogueLink();
        String url = homePage.getCurrentPageUrl();
        Assertions.assertEquals("https://catalog.onliner.by/", url, "Incorrect page URL");
    }

    @AfterAll
    public static void closeBrowser() {
        new HomePage().closeBrowser();
    }
}
