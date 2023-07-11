package com.example.productorderservice.product;

import org.springframework.util.Assert;

record GetProductResponse(
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
