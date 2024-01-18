package com.tech.challenge.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenApi(@Value("${springdoc.version}") String appVersion,
                                 @Value("${swagger.apiUrl}") String apiUrl) {
        return new OpenAPI()
                .addServersItem(new Server().url(apiUrl))
                .info(new Info()
                        .title("CCEE Meter API")
                        .description("""
                                                          
                          This API collects Meter Point information and updates and externalizes its measurements.
                                                          
                          To interact with this API, make sure to include the 'x-created-by' header in your requests to identify the creator of the request.
                                                          
                          """)
                        .version(appVersion));
    }
}