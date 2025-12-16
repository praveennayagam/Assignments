package com.mphasis.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {
	
	@Bean
	public OpenAPI OpenApi()
	{
		return new  OpenAPI()
				.info(new Info().title("User Management Application")
						.description("Swagger configuration demo using springboot UserApp")
						.version("1.0")
						.contact(new Contact()
								.name("API support team")
								.email("praveen@gmail.com")
								.url("com.mphasis.userapp"))
								.license(new License()
										.name("Apache 2.0")
										.url("http://wwwa.apache.org./licenses/LICENCES-2.0")));
	}
	
	

}
