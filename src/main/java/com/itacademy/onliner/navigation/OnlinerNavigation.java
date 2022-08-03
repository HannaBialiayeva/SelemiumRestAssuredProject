package com.itacademy.onliner.navigation;


import com.itacademy.onliner.page_object.HomePage;

public class OnlinerNavigation {

    public static final String ONLINER_HOME_PAGE = "https://www.onliner.by/";

    public static void navigateToOnlinerHomePage(){
        new HomePage().navigate(ONLINER_HOME_PAGE);
    }
}
