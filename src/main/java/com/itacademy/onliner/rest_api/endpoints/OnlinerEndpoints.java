package com.itacademy.onliner.rest_api.endpoints;

import com.itacademy.onliner.framework.PropertiesReader;

public class OnlinerEndpoints {

    public static String getCatalogSuchiVeslaProductsEndpoint() {
        return PropertiesReader.getEndpointProperty("catalogue.sushivesla.products");
    }

    public static String getCatalogSuchiVeslaProductsRollsEndpoint() {
        return PropertiesReader.getEndpointProperty("catalogue.sushivesla.products.roll");
    }


}
