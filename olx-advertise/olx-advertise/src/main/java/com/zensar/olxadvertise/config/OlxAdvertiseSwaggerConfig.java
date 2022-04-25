package com.zensar.olxadvertise.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class OlxAdvertiseSwaggerConfig {
	
	@Bean
	public Docket getCustomizedDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
		      .select()
		      .apis(RequestHandlerSelectors.basePackage("com.zensar.olxadvertise"))
		      .build()
		      .apiInfo(getApiInfo());
	}

	

	private ApiInfo getApiInfo() {
		
		return new ApiInfo("Olx Advertise Management", "This application manages Olx Advertise", "1.0.0","http://www.zensar.com", "Rajesh", "Apache", "https://tomcat.apache.org/");
	}

}
