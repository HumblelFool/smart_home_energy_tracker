package com.smart_home.usage_service.config;

import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI usageServiceApiDocs(){
        return new OpenAPI()
                .info(new io.swagger.v3.oas.models.info.Info()
                        .title("Usage Service Api")
                        .description("Usage Service Api for Home Energy Trackers")
                        .version("1.0.0"));
    }
}
