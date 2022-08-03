package com.itacademy.onliner.api_tests;

import com.itacademy.onliner.navigation.OnlinerNavigation;
import com.itacademy.onliner.page_object.HomePage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ProductNavigationBaseTest {

    @BeforeAll

    public static void navigateToOnliner() {
        OnlinerNavigation.navigateToOnlinerHomePage();
    }

    @Test
    public void testUserIsAbleToNavigateToProductsPageViaCatalogueLink(){
        new HomePage().clickOnCatalogueLink();
    }


}
