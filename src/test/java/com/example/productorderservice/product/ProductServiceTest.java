package com.example.productorderservice.product;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class ProductServiceTest {
    @Test
    void add() {
        final String name = "상품명";
        final int price = 1000;
        final DiscountPolicy discountPolicy = DiscountPolicy.NONE;
        final AddProductRequest request = new AddProductRequest(name, price, discountPolicy);
        productService.addProduct(request);
    }

    private record AddProductRequest(String name, int price, DiscountPolicy discountPolicy) {
        private AddProductRequest {
            Assert.hasText(name, "상품명 필수");
            Assert.isTrue(price > 0, "0보다크게");
            Assert.notNull(discountPolicy, "할인필수");
        }
        }

    private enum DiscountPolicy {
        NONE
    }
}
