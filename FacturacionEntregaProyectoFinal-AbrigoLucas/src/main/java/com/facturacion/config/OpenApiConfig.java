package com.facturacion.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenApiConfig {

	@Bean
	OpenAPI customOpenAPI () {
		return new OpenAPI()
				.info(new Info()
						.title("API JavaFACTURACION | Coder")
						.version("1.0.1")
						.description("La API FACTURACION esta diseñada para gestion de ventas "
                        		+ "de un comercion, la cual permite acceder a diferentes endpoints "
                        		+ "para Clientes, Productos y Ventas, con acceso a un sistema CRUD completo. "
                        		+ "Los endpoints permiten listar, agregar, mostrar, editar y eliminar"
                        		+ "clientes, cursos y ventas. La API está documentada utilizando "
                        		+ "Swagger, lo que facilita la comprensión de los endpoints y su uso."
                        		+ "Además se esta desarrollando una vista front en React para una mejor experiencia"
                        		+ "de usuario.")
						.contact(new Contact()
								.name("Lucas Federico Abrigo")
								.email("luca.mdq@gmail.com")
								.url("https://github.com/LucasFedeAb/Facturacion-Java-EntregaFinal-AbrigoLucas"))
						.license(new License()
								.name("Licencia")
								.url("https://github.com/LucasFedeAb/Facturacion-Java-EntregaFinal-AbrigoLucas"))
						)
						.servers(List.of(new Server()
								.url("http://localhost:8080")
								.description("Servidor Local")));
				
	}
	
}