package com.home_energy.injestion_service.config;

import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI ingestionServiceApiDocs(){
        return new OpenAPI()
                .info(new io.swagger.v3.oas.models.info.Info()
                        .title("ingestion Service Api")
                        .description("ingestion Service Api for Home Energy Trackers")
                        .version("1.0.0"));
    }
}
