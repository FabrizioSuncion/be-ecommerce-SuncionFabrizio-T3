package com.ecommerce.suncionfabrizio.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPI() {
        final String esquema = "bearerAuth";
        return new OpenAPI()
            .info(new Info()
                .title("API E-commerce - Suncion Fabrizio")
                .version("1.0")
                .description("Backend REST con Spring Boot, JWT stateless y CRUD de productos"))
            .addSecurityItem(new SecurityRequirement().addList(esquema))
            .components(new Components().addSecuritySchemes(esquema,
                new SecurityScheme()
                    .name(esquema)
                    .type(SecurityScheme.Type.HTTP)
                    .scheme("bearer")
                    .bearerFormat("JWT")));
    }
}
