package com.itacademy.onliner.rest_api.util;

import io.restassured.response.ResponseBody;

import java.util.List;

public class ResponseBodyUtils {

    public static <T> List<T> returnObjectsByJsonPath(ResponseBody responseBody,
                                                      String jsonPath,
                                                      Class<T> type) {
        return responseBody
                .jsonPath()
                .getList(jsonPath, type);
    }

    public static <T> T returnObjectByJsonPath(ResponseBody responseBody,
                                               String jsonPath,
                                               Class<T> type) {
        return responseBody
                .jsonPath()
                .getObject(jsonPath, type);
    }

}
