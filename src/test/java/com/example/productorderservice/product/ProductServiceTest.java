package com.example.productorderservice.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.server.MockWebSession;
import org.springframework.util.Assert;

public class ProductServiceTest {
    private ProducService productService;

    @BeforeEach
    void setUp() {
        productService = new ProducService();
    }

    @Test
    void add() {
        final String name = "상품명";
        final int price = 1000;
        final DiscountPolicy discountPolicy = DiscountPolicy.NONE;
        final AddProductRequest request = new AddProductRequest(name, price, discountPolicy);
        productService.addProduct(request);
    }

    private class ProducService {
        private ProductPort productPort;

        public void addProduct(final AddProductRequest request) {
            final Product product = new Product(request.name(), request.price(), request.discountPolicy());

            productPort.save(product);
        }
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


    private class Product {
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

    private interface ProductPort {
        void save(final Product product);
    }
}
