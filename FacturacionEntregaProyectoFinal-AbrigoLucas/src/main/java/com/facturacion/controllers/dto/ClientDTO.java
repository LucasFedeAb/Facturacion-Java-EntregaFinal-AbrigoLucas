package com.facturacion.controllers.dto;

import com.facturacion.models.abstractClass.Person;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Modelo de ClienteDTO")
public class ClientDTO extends Person {
	
	@Schema(description = "Id del Cliente", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
	private Integer id;
	@Schema(description = "DNI del Cliente", requiredMode = Schema.RequiredMode.REQUIRED, example = "12345678")
	private Integer dni;
	@Schema(description = "Nombre de Persona", requiredMode = Schema.RequiredMode.REQUIRED, example = "Jhon")
    private String firstName;
	@Schema(description = "Apellido de Persona", requiredMode = Schema.RequiredMode.REQUIRED, example = "Doe")
    private String lastName;
	@Schema(description = "Email de Persona", requiredMode = Schema.RequiredMode.REQUIRED, example = "jhon.doe@example.com")
    private String email;
	@Schema(description = "Telefono de Persona", requiredMode = Schema.RequiredMode.REQUIRED, example = "1155669988")
    private Long phone;
	@Schema(description = "Direccion de Persona", requiredMode = Schema.RequiredMode.REQUIRED, example = "Calle publica 123")
    private String address;
    
    // Constructor
    public ClientDTO() {
    } 

	public ClientDTO(Integer id, Integer dni, String firstName, String lastName, String email, Long phone,
			String address) {
		super();
		this.id = id;
		this.dni = dni;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getDni() {
		return dni;
	}


	public void setDni(Integer dni) {
		this.dni = dni;
	}



	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
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