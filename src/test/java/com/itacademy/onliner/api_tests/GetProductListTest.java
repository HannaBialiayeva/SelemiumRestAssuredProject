package com.itacademy.onliner.api_tests;

import com.itacademy.onliner.rest_api.model.Product;
import com.itacademy.onliner.rest_api.service.ProductListService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GetProductListTest {

    @Test
    public void testGetListOfProducts() {
        List<Product> products = new ProductListService().getListOfProducts();
        Assertions.assertNotNull(products, "List of Products is returned!");
        for (Product product : products) {
            String productName = product.getName();
            Assertions.assertNotNull(productName, "Product Name is null!");
        }
    }

    @Test
    public void testFilterProductsListByRoll() {
        List<Product> products = new ProductListService().getListOfProductsFilteredByRoll();
        for (Product product : products) {
            String namePrefixRoll = product.getName_prefix();
            Assertions.assertEquals("Роллы", namePrefixRoll, "Filter by Roll isn't applied!");
        }
    }
}
