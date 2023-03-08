package com.example.demo;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import java.util.List;

@EnableCaching
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public OpenAPI myOpenAPI() {
		Contact contact = new Contact();
		contact.setEmail("1kevinson.online@gmail.com");
		contact.setName("Kevin KOUOMEU");
		contact.setUrl("https://hooo-api.com");

		Server localServer = new Server();
		localServer.setUrl("http://localhost:8000");
		localServer.setDescription("Server URL for Local development");

		Server productionServer = new Server();
		productionServer.setUrl("https://hooo-api.com");
		productionServer.setDescription("Server URL in Production");

		License mitLicense = new License()
				.name("MIT License")
				.url("https://choosealicense.com/licenses/mit/");

		Info info = new Info()
				.title("Product Manager API")
				.contact(contact)
				.version("1.0")
				.description("This API exposes endpoints to manage products. ")
				.license(mitLicense);

		return new OpenAPI()
				.info(info)
				.servers(List.of(localServer, productionServer));
	}
}
