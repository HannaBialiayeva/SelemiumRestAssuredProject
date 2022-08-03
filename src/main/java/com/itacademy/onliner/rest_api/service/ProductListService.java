package com.itacademy.onliner.rest_api.service;

import com.google.common.collect.ImmutableMap;
import com.itacademy.onliner.rest_api.endpoints.OnlinerEndpoints;
import com.itacademy.onliner.rest_api.model.Product;
import com.itacademy.onliner.rest_api.util.GetRequestUtils;
import com.itacademy.onliner.rest_api.util.ResponseBodyUtils;
import io.restassured.response.ResponseBody;

import java.util.Map;
import java.util.List;

public class ProductListService {

    private static final String PRODUCTS_JSON_PATH = "products";


    public List <Product> getListOfProducts (){
        ResponseBody responseBody = GetRequestUtils.sendGetRequestAndReturnResponseBody
                (OnlinerEndpoints.getCatalogSuchiVeslaProductsEndpoint(), configureHeaders(),null);
        return ResponseBodyUtils.returnObjectsByJsonPath(responseBody, PRODUCTS_JSON_PATH, Product.class);
    }

    public List <Product> getListOfProductsFilteredByRoll (){
        ResponseBody responseBody = GetRequestUtils.sendGetRequestAndReturnResponseBody
                (OnlinerEndpoints.getCatalogSuchiVeslaProductsRollsEndpoint(), configureHeaders(),null);
        return ResponseBodyUtils.returnObjectsByJsonPath(responseBody, PRODUCTS_JSON_PATH, Product.class);
    }

    public String listOfProductsFilteredByRollAndContainceNamePrefixRoll (){
        String namePrefix = GetRequestUtils.getProductsListFilteredByRoll
                (OnlinerEndpoints.getCatalogSuchiVeslaProductsRollsEndpoint(), configureHeaders(),null);
        return namePrefix;
    }

    public Map<String, Object> configureHeaders() {
        return ImmutableMap.of("Host", "catalog.onliner.by");

    }
}
