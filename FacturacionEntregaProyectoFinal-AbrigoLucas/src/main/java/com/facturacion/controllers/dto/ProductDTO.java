package com.facturacion.controllers.dto;

import com.facturacion.models.entity.Product;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Modelo de ProductoDTO")
public class ProductDTO {
	@Schema(description = "Id de Producto", requiredMode = Schema.RequiredMode.REQUIRED, example = "5")
	private Integer id;
	@Schema(description = "Codigo de barra de Producto", requiredMode = Schema.RequiredMode.REQUIRED, example = "654321")
	private Integer code;
	@Schema(description = "Categoria de Producto", requiredMode = Schema.RequiredMode.REQUIRED, example = "Notebooks")
	private String category;
	@Schema(description = "Nombre de Producto", requiredMode = Schema.RequiredMode.REQUIRED, example = "Ideapad Gaming 3")
	private String name;
	@Schema(description = "Marca de Producto", requiredMode = Schema.RequiredMode.REQUIRED, example = "Lenovo")
	private String brand;
	@Schema(description = "Descripcion de Producto", requiredMode = Schema.RequiredMode.REQUIRED, example = "Lenovo Ideapad Gaming 3 16GB RAM")
	private String description;
	@Schema(description = "Precio de Producto", requiredMode = Schema.RequiredMode.REQUIRED, example = "1200")
    private double price;
	@Schema(description = "Stock de Producto", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private int stock;
	@Schema(description = "Validar Producto en Oferta", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
	private boolean isPromotion;

    // Constructor
    
    public ProductDTO() {
    }

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.code = product.getCode();
        this.category = product.getCategory();
        this.name = product.getName();
        this.brand = product.getBrand();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.stock = product.getStock();
        this.isPromotion = product.isPromotion();
        
     // Registro de producto creado
        System.out.println("Se creó un nuevo ProductoDTO a partir de Producto: " + product.getId());
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

	public Integer getCode() {
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
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
    
}