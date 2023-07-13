package com.example.productorderservice.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    void list() {

        productService.addProduct(ProductSteps.getAddProductRequest());
        final long productId = 1L;

        final GetProductResponse response = productService.getProduct(productId);
        assertThat(response).isNotNull();
    }

}
