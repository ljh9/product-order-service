package com.example.productorderservice.product;

import com.example.productorderservice.ApiTest;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest
public class ProductApiTest extends ApiTest {

    @Test
    void add() {
        final var request = ProductSteps.getAddProductRequest();

        final var response = ProductSteps.addProductRequest(request);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());

    }


}
