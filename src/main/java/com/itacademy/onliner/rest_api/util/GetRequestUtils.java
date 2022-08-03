package com.itacademy.onliner.rest_api.util;

import io.restassured.response.ResponseBody;
import org.apache.commons.collections4.MapUtils;
import org.apache.http.HttpStatus;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetRequestUtils {

    public static ResponseBody sendGetRequestAndReturnResponseBody(String endpoint,
                                                                   Map<String, Object> headers,
                                                                   Map<String, Object> parameters) {

        return given()
                .headers(MapUtils.emptyIfNull(headers))
                .params(MapUtils.emptyIfNull(parameters))
                .when()
                .get(endpoint)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response()
                .getBody();

    }

    public static String getProductsListFilteredByRoll(String endpoint,
                                                        Map<String, Object> headers,
                                                        Map<String, Object> parameters) {

        return given()
                .headers(MapUtils.emptyIfNull(headers))
                .params(MapUtils.emptyIfNull(parameters))
                .when()
                .get(endpoint)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response()
                .getBody()
                .jsonPath().getString("products.name_prefix");
    }
}