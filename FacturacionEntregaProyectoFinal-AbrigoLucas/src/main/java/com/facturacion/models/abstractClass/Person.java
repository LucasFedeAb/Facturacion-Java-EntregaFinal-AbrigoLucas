package com.facturacion.models.abstractClass;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@Schema(description = "Modelo de Persona")
@MappedSuperclass
public abstract class Person {
	
	@Schema(description = "DNI de la Persona", requiredMode = Schema.RequiredMode.REQUIRED, example = "12345678")
	@Column(name = "Dni", unique = true)
    private Integer dni;
	@Schema(description = "Nombre de Persona", requiredMode = Schema.RequiredMode.REQUIRED, example = "Jhon")
	@Column(name = "Nombre")
    private String firstName;
	@Schema(description = "Apellido de Persona", requiredMode = Schema.RequiredMode.REQUIRED, example = "Doe")
    @Column(name = "Apellido")
    private String lastName;
	@Schema(description = "Email de Persona", requiredMode = Schema.RequiredMode.REQUIRED, example = "jhon.doe@example.com")
    @Column(name = "Email")
    private String email;
    
    
    public Person () {
    	super();
    }    
    
    public Person(Integer dni, String firstName, String lastName, String email) {
		this.dni = dni;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
    
    //Getters y Setters

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

}
