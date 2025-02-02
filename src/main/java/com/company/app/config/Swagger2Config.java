package com.company.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.company.app"))
            .paths(PathSelectors.any())
            .build()
                .apiInfo(metaData());
}

    private ApiInfo metaData(){
        return new ApiInfoBuilder()
                .title("Company")
                .description("API Company")
                .version("1.0.0")
                .license("MIT License")
                .licenseUrl("")
                .build();
    }

}