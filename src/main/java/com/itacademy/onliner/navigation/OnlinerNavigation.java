package com.itacademy.onliner.navigation;


import com.itacademy.onliner.page_object.HomePage;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OnlinerNavigation {
    protected static final Logger LOG = LoggerFactory.getLogger(OnlinerNavigation.class);

    public static final String ONLINER_HOME_PAGE = "https://www.onliner.by/";

    @Step("Navigate to Onliner Home page")
    public static void navigateToOnlinerHomePage(){
        try {
            new HomePage().navigate(ONLINER_HOME_PAGE);
            LOG.info("Onliner Home page was opened");
        } catch (Exception e) {
            e.getMessage();
            LOG.error("Onliner Home page isn't opened");
        }

    }
}
