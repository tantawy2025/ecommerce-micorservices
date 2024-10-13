package com.example.discount_service.commons.configs.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Pricing Service API")
                        .version("1.0.0")
                        .description("API for Add/Update Price for an SKU and Retrieve Pricing for a SKU based on DateProducts (SKU) will be populated to Pricing service after adding it from catalog service ."));
    }

}
