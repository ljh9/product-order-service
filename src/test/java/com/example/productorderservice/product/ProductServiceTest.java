package com.example.productorderservice.product;

import com.sun.media.sound.SF2Soundbank;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class ProductServiceTest {

    private ProductService productService;

    @Test
    void list() {

        productService.addProduct();
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
