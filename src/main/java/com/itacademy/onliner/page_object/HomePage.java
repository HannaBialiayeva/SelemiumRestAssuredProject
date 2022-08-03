package com.itacademy.onliner.page_object;

import com.itacademy.onliner.framework.BasePage;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    public static final String CATALOGUE_LINK = "//span[@class='b-main-navigation__text' and contains(text(), 'Каталог')]";
    public static final String CLASSIFIER_MENU = "//span[@class='catalog-navigation-classifier__item-title-wrapper']";

    public void clickOnCatalogueLink(){
        waitForElementVisible(By.xpath(CATALOGUE_LINK)).click();
    }
}
