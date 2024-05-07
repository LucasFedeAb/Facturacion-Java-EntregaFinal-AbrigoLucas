package com.facturacion.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facturacion.models.entity.Client;
import com.facturacion.services.ClientService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name= "Gestion de Clientes", description = "Endpoints para Gestionar Clientes")
@CrossOrigin(origins = "http://localhost:5173") //Acceder desde react en local
@RestController
@RequestMapping("/clientes")
public class ClientController {
    @Autowired
    private ClientService clientService;

    
    //  
    @Operation(summary = "Crear nuevo Cliente")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Crear Cliente correctamente", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Client.class)) }),
			@ApiResponse(responseCode = "400", description = "Solicitud Incorrecta", content = @Content) })
    @PostMapping(value = "/crear", consumes = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
    	try {
    		clientService.createClient(client);
    		return new ResponseEntity<>(client, HttpStatus.CREATED); // Codigo 201
    	} catch (Exception e) {
    		return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // Codigo 400
    	}
	}
    
    @Operation(summary = "Actualizar datos del Cliente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente actualizado exitosamente", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Client.class)) }),
            @ApiResponse(responseCode = "404", description = "Cliente no encontrado")
    })
    @PutMapping(value="/{id}/actualizar", consumes = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Client> updateClient(@PathVariable("id") Integer dni, @RequestBody Client client) {
    	Client clientUpdated = clientService.updateClientByDni(dni, client);
    	
			if (clientUpdated != null) {
				return new ResponseEntity<>(client, HttpStatus.OK); // Codigo 200
			} else {
				return new ResponseEntity<>(client, HttpStatus.NOT_FOUND); // Codigo 404
			}
    }
    
    // 
    @Operation(summary = "Obtener lista de todos los clientes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de clientes obtenida exitosamente", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Client.class)) }),
            @ApiResponse(responseCode = "500", description = "Error interno del servido")
    })
    @GetMapping (value = "/", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Client>> listClients() {
		try {
			List<Client> clients = clientService.getAllClients();
			return new ResponseEntity<>(clients, HttpStatus.OK); // Codigo 200

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Error 500
		}
	}
    
    // Obtener cliente segun dni
    @Operation(summary = "Obtener cliente segun dni")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente encontrado exitosamente", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Client.class)) }),
            @ApiResponse(responseCode = "404", description = "Cliente no encontrado")
    })
    @GetMapping(value = "/cliente/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Client> getClientByDNI(@PathVariable("id") Integer dni) {
		try {
			Client client = clientService.getClientByDni(dni);
			if (client != null) {
				return new ResponseEntity<>(client, HttpStatus.OK); // Codigo 200
			} else {
				return new ResponseEntity<>(client, HttpStatus.NOT_FOUND); // Codigo 404
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Error 500
		}

	}
    
    // 
    @Operation(summary = "Eliminar cliente segund dni")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Cliente eliminado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Cliente no encontrado"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @DeleteMapping(value = "/{id}/eliminar")
	public ResponseEntity<Void> deleteClient(@PathVariable("id") Integer dni) {
    	try {
    		boolean deletedClient = clientService.deleteClientByDNI(dni);
    			if (deletedClient) {
    				return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Codigo 204
    			} else {
    				return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Error 404
    			}
    	} catch(Exception e) {
    		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Error 500
    		}
    	}
    
}