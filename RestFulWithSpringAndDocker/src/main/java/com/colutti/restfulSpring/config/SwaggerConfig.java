package com.colutti.restfulSpring.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.colutti"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("RestFul API by Colutti",
				"A  complete project, using SpringBoot, Docker, JWT,"
				+ " HATEOAS, Swagger and all good practices!", "v1",
				"https://github.com/vinicius-colutti/RestFulWithSpringAndDocker",
				new Contact("Vinicius Colutti", "https://github.com/vinicius-colutti",
				"viniciuscolutti@hotmail.com"), "For Colutti", "vinicius-colutti",
				Collections.emptyList());
	}

}
