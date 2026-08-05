package com.coding.ProductMS;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductMsApplicationTests {

    @Container
    @ServiceConnection
    static MongoDBContainer mongoDBContainer =
            new MongoDBContainer("mongo:7.0.5");

    @LocalServerPort
    private Integer port;

    @BeforeEach
    void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    @Test
    void shouldCreateProduct() {

        String requestBody = """
                {
                    "name": "Masala Dosa",
                    "description": "dosa description",
                    "price": 90
                }
                """;

        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/api/product/add-product")
                .then()
                .statusCode(201)
                .body("status", equalTo(true))
                .body("message", equalTo("Product created successfully."))
                .body("data.id", notNullValue())
                .body("data.name", equalTo("Masala Dosa"))
                .body("data.description", equalTo("dosa description"))
                .body("data.price", equalTo(90));
    }
}