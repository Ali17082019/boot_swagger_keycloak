package com.eazybytes.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.OAuthFlow;
import io.swagger.v3.oas.annotations.security.OAuthFlows;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Ali Reza",
                        email = "ali.reza@mycompany.com"
                ),
                description = "Your need authorization token to access protected resources",
                title = "API specification for url service",
                version = "1.0"
        ),
        security = {
                @SecurityRequirement(
                        name = "bearerAuth"
                )
        }
)
@SecurityScheme(
        name = "bearerAuth",
        description = "JWT auth description",
        scheme = "bearer",
        type = SecuritySchemeType.OAUTH2,
        flows = @OAuthFlows(
                authorizationCode =
                @OAuthFlow(
                        authorizationUrl = "http://localhost:8080/realms/dhotools/protocol/openid-connect/auth",
                        tokenUrl = "http://localhost:8080/realms/dhotools/protocol/openid-connect/token"


                )
        ),
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)

public class OpenApiConfig {
}
