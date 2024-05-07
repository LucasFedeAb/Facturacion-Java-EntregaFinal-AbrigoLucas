package com.facturacion.models.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Schema(description = "Modelo de Producto Vendido")
@Entity
public class SaleItem {
	@Schema(description = "Id de item venta ", requiredMode = Schema.RequiredMode.AUTO)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id_item_venta")
	private Integer itemSaleId;
	@Schema(description = "Id de producto vendido", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
	@Column(name = "Id_producto_vendido")
	private Integer productId;
	@Schema(description = "Cantidad x producto vendido", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
	@Column(name = "Cantidad vendida")
	private int quantity;
	@Schema(description = "Codigo barra prodcuto", requiredMode = Schema.RequiredMode.REQUIRED, example = "123456")
	@Column(name = "Codigo barra")
	private Integer code;
	@Schema(description = "Categoria de producto", requiredMode = Schema.RequiredMode.REQUIRED, example = "Notebooks")
	@Column(name = "Categoria")
	private String category;
	@Schema(description = "Nombre porducto vendido", requiredMode = Schema.RequiredMode.REQUIRED, example = "Notebook 8GB RAM")
	@Column(name = "Nombre")
	private String name;
	@Schema(description = "Marca de producto vendido", requiredMode = Schema.RequiredMode.REQUIRED, example = "Lenovo")
	@Column(name = "Marca")
	private String brand;
	@Schema(description = "DNI del Cliente", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@Column(name = "Descripcion")
    private String description;
	@Schema(description = "Monto total de venta", requiredMode = Schema.RequiredMode.REQUIRED, example = "1500")
	@Column(name = "Monto total")
    private double salePrice;
	@Schema(description = "DNI del Cliente", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
	@Column(name = "Stock")
    private int stock;
	@Schema(description = "Validacion producto en oferta", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
	@Column(name = "Oferta")
	private boolean isPromotion;
    
	@Schema(description = "Venta generada")
    @ManyToOne
    @JoinColumn(name = "sale_id")
    @JsonBackReference 		//!importante para serializacion y no generar bucle infinito
    private Sale sale;

	public SaleItem() {
		super();
	}
	
	//Getters y Setters
	public Integer getItemSaleId() {
		return itemSaleId;
	}

	public void setItemSaleId(Integer itemSaleId) {
		this.itemSaleId = itemSaleId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Integer getCode(Integer code) {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public boolean isPromotion() {
		return isPromotion;
	}
	
	public void setPromotion(boolean isPromotion) {
		this.isPromotion = isPromotion;
	}

	public Sale getSale() {
		return sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}

}