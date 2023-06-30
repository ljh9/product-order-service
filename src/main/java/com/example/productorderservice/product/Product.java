package com.example.productorderservice.product;

import org.springframework.util.Assert;

class Product {

    private Long id;
    private final String name;
    private final int price;
    private final DiscountPolicy discountPolicy;


    public Product(final String name, int price, DiscountPolicy discountPolicy) {
        Assert.hasText(name, "상품명 필수");
        Assert.isTrue(price > 0, "0보다크게");
        Assert.notNull(discountPolicy, "할인필수");
        this.name = name;
        this.price = price;
        this.discountPolicy = discountPolicy;
    }

    public void assignId(final Long aLong) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
