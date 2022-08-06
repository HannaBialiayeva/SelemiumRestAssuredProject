package com.itacademy.onliner.page_object;

import com.itacademy.onliner.framework.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static java.lang.String.format;

public class CatalogPage extends BasePage {
    public static final String CLASSIFIER_DROPDOWN_SECTIONS = "//div[@class='catalog-navigation-list__aside-title' and contains(text(), '%s' )]";
    public static final String CLASSIFIER_LINK_PATTERN = "//*[@class='catalog-navigation-classifier__item-title-wrapper' and contains(text(), '%s' )]";
    public static String LIST_OF_GEARS_PATTERN = "//span[@class='catalog-navigation-list__dropdown-title' and contains(text(), '%s')]";
    public static String PRODUCT_DATA_PATTERN = "//span[@class= 'catalog-navigation-list__dropdown-title' and contains(text(), '%s')]/following-sibling::*";

    @Step("Click on Catalog Section link")
    public void clickOnCatalogSectionLink(String classifierName) {
        waitForElementVisible(By.xpath(format(CLASSIFIER_LINK_PATTERN, classifierName))).click();
    }


    @Step("Click on Catalog Section Category link")
    public void clickOnCatalogSectionCategoryLink(String categoryName) {
        waitForElementVisible(By.xpath(format(CLASSIFIER_DROPDOWN_SECTIONS, categoryName))).click();
    }
}
