package com.itacademy.onliner.ui_tests.catalogPageTests;

import com.itacademy.onliner.page_object.CatalogPage;
import com.itacademy.onliner.page_object.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.itacademy.onliner.navigation.OnlinerNavigation.navigateToOnlinerHomePage;
import static com.itacademy.onliner.page_object.CatalogPage.CLASSIFIER_DROPDOWN_SECTIONS;
import static java.lang.String.format;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class CatalogSectionDropdownTest {

    protected static final Logger LOG = LoggerFactory.getLogger(CatalogSectionDropdownTest.class);
    public CatalogPage catalogPage = new CatalogPage();

    @BeforeAll
    public static void navigateToHomePage() {
        navigateToOnlinerHomePage();
        new HomePage().clickOnCatalogueLink();

    }

    @ParameterizedTest
    @Severity(SeverityLevel.NORMAL)
    @Description("Catalog Section Menu contains all required categories")
    @ValueSource(strings = {"Ноутбуки,компьютеры, мониторы", "Комплектующие", "Хранение данных", "Сетевое оборудование"})
    void testDropdownIsShownByClickOnSectionLinkAndContainsCategoryHeaders(String categoryName) {
        catalogPage.clickOnCatalogSectionLink("Компьютеры");
        WebElement classifierDropdownSection = catalogPage.findElement(By.xpath(format(CLASSIFIER_DROPDOWN_SECTIONS, categoryName)));
        assertThat(classifierDropdownSection.getText().contains(categoryName));
    }

    @AfterAll
    public static void closeBrowser() {
        new HomePage().closeBrowser();
    }
}

