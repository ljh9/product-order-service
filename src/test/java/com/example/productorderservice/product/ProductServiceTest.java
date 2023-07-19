package com.example.productorderservice.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductServiceTest {


    private ProductService productService;

    @BeforeEach
    void setUp() {
        final ProductPort productPort = new ProductPort() {
            @Override
            public void save(Product product) {

            }

            @Override
            public Product getProduct(Long productId) {
                return null;
            }
        };
        productService = new ProductService(productPort);
    }

    @Test
    void updateProduct() {

        final Long productId = 1L;
        final UpdateProductRequest request = new UpdateProductRequest("product update", 2000, DiscountPolicy.NONE);

        productService.updateProduct(productId, request);

    }

}
