package com.facturacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class FacturacionEntregaProyectoFinalAbrigoLucasApplication {

	public static void main(String[] args) {
		SpringApplication.run(FacturacionEntregaProyectoFinalAbrigoLucasApplication.class, args);
	}
	
	@Bean
	RestTemplate restTample () {
		return new RestTemplate();
	}
	
}
