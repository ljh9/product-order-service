package com.example.productorderservice.product;

import org.junit.jupiter.api.Test;

public class ProductServiceTest {

    final Long productId = 1L;
    final UpdateProductRequest request = new UpdateProductRequest("product update", 2000, DiscountPolicy.NONE);

    @Test
    void updateProduct() {

        productService.updateProduct(productId, request);

    }

    private class UpdateProductRequest {
        private final String name;
        private final int price;
        private final DiscountPolicy discountPolicy;

        public UpdateProductRequest(final String name, final int price, final DiscountPolicy discountPolicy) {
            this.name = name;
            this.price = price;
            this.discountPolicy = discountPolicy;
        }
    }
}
