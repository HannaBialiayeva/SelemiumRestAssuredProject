package com.itacademy.onliner.ui_tests.catalogPageTests;

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

import static com.itacademy.onliner.navigation.OnlinerNavigation.navigateToOnlinerHomePage;
import static com.itacademy.onliner.page_object.CatalogPage.CLASSIFIER_LINK_PATTERN;
import static java.lang.String.format;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CatalogSectionsMenuTest {

    public HomePage homePage = new HomePage();
    
    @BeforeAll
    public static void navigateToHomePage() {
        navigateToOnlinerHomePage();
    }

    @ParameterizedTest
    @Severity(SeverityLevel.BLOCKER)
    @Description("Catalog Menu contains required sections")
    @ValueSource(strings = {"Электроника", "Компьютеры", "Бытовая техника", "Стройка",
            "Дом", "Авто", "Красота", "Детям", "Работа"})
    void testCatalogMenuContainsSectionHeaders(String classifierName) {
        homePage.clickOnCatalogueLink();
        WebElement sectionsMenu = homePage.findElement(By.xpath(format(CLASSIFIER_LINK_PATTERN, classifierName)));
        assertThat(sectionsMenu.getText().contains(classifierName));
    }

    @AfterAll
    public static void closeBrowser() {
        new HomePage().closeBrowser();
    }


}
