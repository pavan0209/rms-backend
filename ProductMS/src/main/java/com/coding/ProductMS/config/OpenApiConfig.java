package com.coding.ProductMS.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI productMSAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Product Service API")
                        .description("This is REST API for product service")
                        .license(new License().name("Apache 2.0")
                        ))
                .externalDocs(new ExternalDocumentation().
                        description("You can refer to the product service Documentation")
                        .url("https://product-ms-dummy-url.com/docs"));
    }
}
