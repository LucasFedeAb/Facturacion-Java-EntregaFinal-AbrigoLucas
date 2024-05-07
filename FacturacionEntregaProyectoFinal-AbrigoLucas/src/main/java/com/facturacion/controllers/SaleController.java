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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facturacion.controllers.dto.SaleDTO;
import com.facturacion.models.entity.Sale;
import com.facturacion.models.entity.TimeApi;
import com.facturacion.services.SaleService;
import com.facturacion.services.TimeAPIService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name= "Gestion de Ventas", description = "Endpoints para Gestionar Ventas")
@CrossOrigin(origins = "http://localhost:5173") //Acceder desde react en local
@RestController
@RequestMapping("/ventas")
public class SaleController {
    @Autowired
    private SaleService saleService;
    @Autowired
    private TimeAPIService timeAPIService;
    
    @Operation(summary = "Obtener fecha y hora actual desde una API")
    @GetMapping("/fechayhora-actual")
    public TimeApi getCurrentDateTime() {
        return timeAPIService.getCurrentDateTime();
    }
    
    @Operation(summary = "Obtener todas las ventas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de ventas obtenida correctamente", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Sale.class)) }),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping(value = "/", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<Sale>> getAllVentas() {
         try {
 			List<Sale> sales = saleService.getAllSales();
 			return new ResponseEntity<>(sales, HttpStatus.OK); // Codigo 200

 		} catch (Exception e) {
 			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Error 500
 		}
    }
    
    @Operation(summary = "Obtener venta por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Venta obtenida correctamente", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Sale.class)) }),
            @ApiResponse(responseCode = "404", description = "Venta no encontrada", content = @Content),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content)
    })
    @GetMapping(value = "/{id}/venta", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity <Sale> getSaleById(@PathVariable("id") Integer id) {
    	try {
    		Sale sale = saleService.getSaleById(id);
			if (sale != null) {
				return new ResponseEntity<>(sale, HttpStatus.OK); // Codigo 200
			} else {
				return new ResponseEntity<>(sale, HttpStatus.NOT_FOUND); // Codigo 404
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Error 500
		}
    }
    
    @Operation(summary = "Obtener ventas por DNI de cliente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de ventas obtenida correctamente", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Sale.class)) }),
            @ApiResponse(responseCode = "404", description = "No se encontraron ventas para el cliente", content = @Content),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content)
    })
    @GetMapping(value = "/cliente/{dni}/venta", produces = { MediaType.APPLICATION_JSON_VALUE })
    //@Transactional
    public ResponseEntity <List<Sale>> getSalesByClientDni(@PathVariable("dni") Integer dni) {
    	try {
    		List<Sale> sales = saleService.getSalesByClientDni(dni);
			if (sales != null) {
				return new ResponseEntity<>(sales, HttpStatus.OK); // Codigo 200
			} else {
				return new ResponseEntity<>(sales, HttpStatus.NOT_FOUND); // Codigo 404
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Error 500
		}
    }
    
    @Operation(summary = "Crear nueva venta")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Venta creada correctamente", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = SaleDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Solicitud Incorrecta", content = @Content)
    })
    @PostMapping(value = "/crear", consumes = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<SaleDTO> createSale(@RequestBody SaleDTO saleDTO) {
    	try {
            SaleDTO saleCreated = saleService.createSale(saleDTO);
            if(saleCreated != null) {
            	System.out.println("Venta creada con éxito");
            }
            return new ResponseEntity<>(saleCreated, HttpStatus.CREATED); // 201 - Created
        } catch (RuntimeException e) {
        	 System.out.println("Error al crear la venta: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // 400 - Bad Request
        }
    }
    
    
    @Operation(summary = "Eliminar venta segun id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Venta eliminada correctamente"),
            @ApiResponse(responseCode = "404", description = "Venta no encontrada"),
            @ApiResponse(responseCode = "400", description = "Solicitud Incorrecta")
    })
    @DeleteMapping(value = "/venta/{id}/delete")
	public ResponseEntity<Void> deleteSale(@PathVariable("id") Integer id) {
    	try {
    		boolean deletedSale = saleService.deleteSaleById(id);
    			if (deletedSale) {
    				System.out.println("Venta id:" + id + " eliminada con éxito");
    				return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Codigo 204
    			} else {
    				System.out.println("Venta id:" + id + " no encontrada");
    				return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Error 404
    			}
    	} catch (RuntimeException e) {
    		System.out.println("Error al eliminar la venta: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // 400 - Bad Request
    	}
	}
    
}