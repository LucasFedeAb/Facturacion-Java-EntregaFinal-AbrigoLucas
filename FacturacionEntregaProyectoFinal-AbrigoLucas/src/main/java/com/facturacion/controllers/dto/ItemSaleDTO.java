package com.facturacion.controllers.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Modelo de Item agregado a venta")
public class ItemSaleDTO {
	@Schema(description = "Cantidad a vender", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
	private int quantity;
	@Schema(description = "Objeto Producto Entero", requiredMode = Schema.RequiredMode.REQUIRED)
    private ProductDTO product;
    
	public ItemSaleDTO() {
		super();
	}
	
	public ItemSaleDTO( int quantity, ProductDTO product) {
		super();
		this.quantity = quantity;
		this.product = product;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public ProductDTO getProduct() {
		return product;
	}
	public void setProduct(ProductDTO product) {
		this.product = product;
	}
 
}