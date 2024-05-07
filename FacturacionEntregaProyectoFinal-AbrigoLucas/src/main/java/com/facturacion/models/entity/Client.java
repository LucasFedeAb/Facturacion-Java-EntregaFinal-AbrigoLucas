package com.facturacion.models.entity;

import com.facturacion.models.abstractClass.Person;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Schema(description = "Modelo de Clientes")
@Entity
@Table (name = "clientes")
public class Client extends Person {
		@Schema(description = "DNI del Cliente", requiredMode = Schema.RequiredMode.REQUIRED, example = "12345678")
		@Id
		@Column(unique = true)
		private Integer id;
		@Schema(description = "Numero de Telefono Cliente", requiredMode = Schema.RequiredMode.REQUIRED, example = "1155783369")
	  	@Column(name = "Telefono")
	  	private Long phone;
		@Schema(description = "Direccion Cliente", requiredMode = Schema.RequiredMode.REQUIRED, example = "Av. Falsa 123")
	  	@Column(name = "Direccion")
		private String address;
	  	
		
	  	// Constructor
	  	public Client () {
	    	super();
	    }
	  	
		public Client (Integer dni, String firstName, String lastName, String email, Long phone, String address) {
	    	super(dni, firstName, lastName, email);
	    	this.id = dni;
	        this.phone = phone;
	        this.address = address;
	    }
	    
		// Getters y Setters
	    public Integer getId() {
			return id;
		}


		public void setId(Integer id) {
			this.id = id;
		}


		public Long getPhone() {
			return phone;
		}


		public void setPhone(Long phone) {
			this.phone = phone;
		}


		public String getAddress() {
			return address;
		}


		public void setAddress(String address) {
			this.address = address;
		}	
}