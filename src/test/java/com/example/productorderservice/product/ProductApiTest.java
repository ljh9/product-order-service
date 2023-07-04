package com.example.productorderservice.product;

import com.example.productorderservice.ApiTest;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest
public class ProductApiTest extends ApiTest {

    @Test
    void add() {
        final var request = getAddProductRequest();

        final var response = addProductRequest(request);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());

    }

    private  static ExtractableResponse<Response> addProductRequest(final AddProductRequest request){
        return RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(request)
                .when()
                .post("/products")
                .then()
                .log().all().extract();
    }

    private static AddProductRequest getAddProductRequest() {
        final String name = "상품명";
        final int price = 1000;
        final DiscountPolicy discountPolicy = DiscountPolicy.NONE;
        return new AddProductRequest(name, price, discountPolicy);
    }


}
