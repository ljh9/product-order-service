package com.example.productorderservice.product;

import org.junit.jupiter.api.Test;

public class ProductServiceTest {

    private ProductService productService;

    @Test
    void list() {

        productService.addProduct(ProductSteps.getAddProductRequest());
        final long productId = 1L;

        final GetProductResponse response = productService.getProduct(productId);
        assertThat(response).isNotNull();
    }

}
