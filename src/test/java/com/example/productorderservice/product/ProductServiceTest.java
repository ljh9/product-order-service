package com.example.productorderservice.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

public class ProductServiceTest {
    private ProductService productService;
    private ProductPort productPort;
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
//        productPort = new ProductPort() {
//            @Override
//            public void save(final Product product) {
//
//            }
//        };
        productRepository = new ProductRepository();
        productPort = new ProductAdapter(productRepository);
        productService = new ProductService(productPort);
    }

    @Test
    void add() {
        final String name = "상품명";
        final int price = 1000;
        final DiscountPolicy discountPolicy = DiscountPolicy.NONE;
        final AddProductRequest request = new AddProductRequest(name, price, discountPolicy);
        productService.addProduct(request);
    }

    private class ProductService {
        private final ProductPort productPort;

        private ProductService(final ProductPort productPort) {
            this.productPort = productPort;
        }

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

    private interface ProductPort {
        void save(final Product product);
    }

    private class ProductAdapter implements ProductPort {
        private final ProductRepository productRepository;

        private ProductAdapter(final ProductRepository productRepository) {
            this.productRepository = productRepository;
        }

        @Override
        public void save(final Product product){
            productRepository.save(product);
        }
    }

    private class ProductRepository {

        private Map<Long, Product> persistence = new HashMap<>();
        private Long sequence = 0L;


        public void save(final Product product) {
            product.assignId(++sequence);
            persistence.put(product.getId(), product);
        }
    }
}
