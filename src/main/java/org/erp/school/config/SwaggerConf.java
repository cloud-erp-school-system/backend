package org.erp.school.config;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConf {
  @Bean
  public Docket docket() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
        .paths(PathSelectors.any())
        .build()
        .apiInfo(apiInfo());
  }

  @Bean
  public ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        .title("Cloud ERP School Backend")
        .description("Student & school management platform")
        .contact(
            new Contact(
                "Cloud ERP Team",
                "https://github.com/orgs/cloud-erp-school-system/people",
                ""))
        .license("GPL-3")
        .version("1.00")
        .build();
  }
}
