package com.example.productorderservice.product;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class ProductServiceTest {

    @Test
    void list() {

        final long productId = 1L;

        final GetProductResponse response = productService.getProduct(productId);
        assertThat(response).isNotNull();
    }

    private record GetProductResponse(
            long id,
            String name,
            int price,
            DiscountPolicy discountPolicy
    ) {
        private GetProductResponse {
            Assert.notNull(id, "id");
            Assert.hasText(name, "name");
            Assert.notNull(discountPolicy, "policy");

        }
    }
}
