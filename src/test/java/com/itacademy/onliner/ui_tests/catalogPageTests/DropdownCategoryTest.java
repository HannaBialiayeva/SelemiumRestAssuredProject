package com.itacademy.onliner.ui_tests.catalogPageTests;


import com.itacademy.onliner.page_object.CatalogPage;
import com.itacademy.onliner.page_object.HomePage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.itacademy.onliner.navigation.OnlinerNavigation.navigateToOnlinerHomePage;
import static com.itacademy.onliner.page_object.CatalogPage.LIST_OF_GEARS_PATTERN;
import static com.itacademy.onliner.page_object.CatalogPage.PRODUCT_DATA_PATTERN;
import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;

public class DropdownCategoryTest {

    public CatalogPage catalogPage = new CatalogPage();

    @BeforeAll
    public static void navigateToHomePage() {
        navigateToOnlinerHomePage();
        new HomePage().clickOnCatalogueLink();
        new CatalogPage().clickOnCatalogSectionLink("Компьютеры");
    }

    @ParameterizedTest
    @ValueSource(strings = {"Видеокарты",
            "Процессоры", "Материнские платы",
            "Оперативная память", "Системы охлаждения",
            "SSD", "Жесткие диски", "Корпуса", "Звуковые карты",
            "Сетевые адаптеры", "Оптические приводы"})
    void testProductsListIsShownByClickOnCategoryLinkAndContainsNameOfProduct(String expectedProductName) {
        List<WebElement> products = catalogPage.findElements(By.xpath(format(LIST_OF_GEARS_PATTERN, expectedProductName)));
        for (WebElement element : products) {
            Assertions.assertTrue(element.isEnabled(), "Category of product with such name isn't presented");
        }

    }

    @ParameterizedTest
    @ValueSource(strings = {"Видеокарты",
            "Процессоры", "Материнские платы",
            "Оперативная память", "Системы охлаждения",
            "SSD", "Жесткие диски", "Корпуса", "Звуковые карты",
            "Сетевые адаптеры", "Оптические приводы"})
    void testProductsListIsShownByClickOnCategoryLinkAndContainsPriceAndCountOfItems(String productName) {
        List<WebElement> productDescriptions = catalogPage.findElements(By.xpath(format(PRODUCT_DATA_PATTERN, productName)));
        for (WebElement element : productDescriptions) {
            boolean isProductCostPresented = element.getText().contains("от");
            boolean isProductCountPresented = element.getText().contains("товар");
            Assertions.assertAll("At least 1 test was failed",
                    () -> assertThat(isProductCostPresented).as("Product Price isn't presented").isTrue(),
                    () -> assertThat(isProductCountPresented).as("Product Count isn't presented").isTrue()
            );
        }
    }

    @AfterAll
    public static void closeBrowser() {
        new HomePage().closeBrowser();
    }

}
