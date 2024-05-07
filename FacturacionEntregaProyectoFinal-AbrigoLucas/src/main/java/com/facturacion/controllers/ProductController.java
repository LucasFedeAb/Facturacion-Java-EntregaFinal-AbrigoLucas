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

import com.facturacion.models.entity.Product;
import com.facturacion.services.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name= "Gestion de Productos", description = "Endpoints para Gestionar Productos")
@CrossOrigin(origins = "http://localhost:5173") //Acceder desde react en local
@RestController
@RequestMapping("/productos")
public class ProductController {
    @Autowired
    private ProductService productService;
    
    // Crear nuevo Producto
    @Operation(summary = "Crear nuevo Producto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Producto creado correctamente", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Product.class)) })
    })
    @PostMapping(value = "/crear", consumes = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
    	productService.createProduct(product);
		return new ResponseEntity<>(product, HttpStatus.CREATED); // Codigo 201
	}
    
    // Actualizar Producto
    @Operation(summary = "Actualizar Producto por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Producto actualizado correctamente", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Product.class)) }),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado", content = @Content)
    })
    @PutMapping(value = "/{id}/editar", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Product> updateProduct(@PathVariable("id") Integer id, @RequestBody Product product) {
    	Product productUpdated = productService.updateProductById(id, product);
		if (productUpdated != null) {
			return new ResponseEntity<>(productUpdated, HttpStatus.OK); // Codigo 200
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Error 404
		}
	}
    
    // Obtener todos los productos
    @Operation(summary = "Obtener todos los Productos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de productos obtenida correctamente", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Product.class)) }),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content)
    })
    @GetMapping (value = "/", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Product>> getAllProducts() {
		try {
			List<Product> products = productService.getAllProducts();
			return new ResponseEntity<>(products, HttpStatus.OK); // Codigo 200

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Error 500
		}

	}
    
    // Obtener Producto segun id
    @Operation(summary = "Obtener Producto por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Producto obtenido correctamente", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Product.class)) }),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado", content = @Content),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content)
    })
    @GetMapping(value = "/producto/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Product> getProductById(@PathVariable("id") Integer id) {
		try {
			Product product = productService.getProductById(id);
			if (product != null) {
				return new ResponseEntity<>(product, HttpStatus.OK); // Codigo 200
			} else {
				return new ResponseEntity<>(product, HttpStatus.NOT_FOUND); // Codigo 404
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Error 500
		}

	}

    // Eliminar Producto segun id
    @Operation(summary = "Eliminar Producto por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Producto eliminado correctamente"),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @DeleteMapping(value = "/{id}/eliminar")
	public ResponseEntity<Void> deleteProduct(@PathVariable("id") Integer id) {
		boolean deletedProduct = productService.deleteProductById(id);
		if (deletedProduct) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Codigo 204
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Error 404
		}
	}
}