package com.dosw.master_chef_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig<OpenAPI> {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new ProcessHandle.Info()
                        .title("Master Chef API")
                        .version("1.0")
                        .description("API para gestión de recetas culinarias"))
                .externalDocs(new ExternalDocumentation()
                        .description("Documentación completa")
                        .url("https://github.com/tu-repo"));
    }
}
