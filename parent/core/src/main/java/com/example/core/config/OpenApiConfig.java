package com.example.core.config;

import com.example.core.constants.SwaggerConstants;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.OAuthFlow;
import io.swagger.v3.oas.annotations.security.OAuthFlows;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        security = @SecurityRequirement(name = SwaggerConstants.OAUTH2_SECURITY_SCHEME)
)
@Configuration
@SecurityScheme(
        type = SecuritySchemeType.OAUTH2,
        name = SwaggerConstants.OAUTH2_SECURITY_SCHEME,
        flows = @OAuthFlows(
                authorizationCode = @OAuthFlow(
                        authorizationUrl = "${springdoc.oAuthFlow.authorizationUrl}",
                        tokenUrl = "${springdoc.oAuthFlow.tokenUrl}"
                )
        )
)
public class OpenApiConfig {

    @Bean
    public OpenAPI baseOpenAPI(){
        return new OpenAPI().info(new Info().title(SwaggerConstants.OPENAPI_TITLE)
                .version(SwaggerConstants.OPENAPI_VERSION).description(SwaggerConstants.OPENAPI_DESCRIPTION));
    }

}
