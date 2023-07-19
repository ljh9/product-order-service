package com.example.productorderservice.product;

import org.apache.http.HttpStatus;
import org.springframework.stereotype.Component;

@RestController
@ReqeustMapping("/products")
class ProductService {
    private final ProductPort productPort;

    ProductService(final ProductPort productPort) {
        this.productPort = productPort;
    }

    @PostMapping
    @Transectional
    public ResponseEntity<Void> addProduct(@RequestBody final AddProductRequest request) {
        final Product product = new Product(request.name(), request.price(), request.discountPolicy());

        productPort.save(product);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{productId}")
    public ResponseEntity<GetProductResponse> getProduct(@PathVariable final Long productId) {
        final Product product = productPort.getProduct(productId);
        final GetProductResponse response = new GetProductResponse(product.getId(), product.getName(), product.getPrice(), product.getDiscountPolicy());

        return ResponseEntity.ok(response);
    }

    public void updateProduct(Long productId, UpdateProductRequest request) {
        throw new UnsupportedOperationException("");
    }
}
