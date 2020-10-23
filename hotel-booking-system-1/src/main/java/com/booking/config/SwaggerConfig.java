package com.booking.config;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
	public Docket hotelBookingApiDoc() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.booking.controller"))
				.build()
				.apiInfo(metaData());
	}

	private ApiInfo metaData() {
		StringBuilder description = new StringBuilder("This is Demonstration Project For Hotel Management System.")
				.append("You can execute all the web service calls on this page.<br/>")
				.append("Below are the modules covered in this API ")
				.append("<ol><li>Room Booking.</li>")
				.append("<li>User expence tracking.</li>")
				.append("<li>Reports.</li></ol>");

		return new ApiInfo("Hotel Room Booking System", 
				description.toString(), 
				"1.0", 
				null, 
				new Contact("Harsh Patel", "", "harshvpatel24@gmail.com"), 
				"Harsh Patel", null, new ArrayList<>());
	}
}
