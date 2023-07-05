package com.example.productorderservice.product;

import org.springframework.util.Assert;

@Entity
@Table(name = "products")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

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

}
