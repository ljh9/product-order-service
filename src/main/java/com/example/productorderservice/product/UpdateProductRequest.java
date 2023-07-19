package com.example.productorderservice.product;

import org.springframework.util.Assert;

record UpdateProductRequest(String name, int price, DiscountPolicy discountPolicy) {
    UpdateProductRequest {
        Assert.hasText(name, "상품명 필수");
        Assert.isTrue(price > 0, "0보다크게");
        Assert.notNull(discountPolicy, "할인필수");
    }
}
