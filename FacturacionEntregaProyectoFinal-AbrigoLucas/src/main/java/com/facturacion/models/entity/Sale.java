package com.facturacion.models.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Schema(description = "Modelo de Ventas")
@Entity
@Table( name = "ventas")
public class Sale {
	@Schema(description = "Id Venta", requiredMode = Schema.RequiredMode.AUTO)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	@Schema(description = "Fecha de Venta", requiredMode = Schema.RequiredMode.AUTO)
	@Column(name = "Fecha Venta")
    private String dateSale;
	@Schema(description = "Monto total de venta", requiredMode = Schema.RequiredMode.AUTO)
	@Column(name = "Total x Venta")
    private double totalPrice;
	
	@Schema(description = "Cliente que realiza compra", requiredMode = Schema.RequiredMode.REQUIRED)
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    
	@Schema(description = "Listado de productos a vender", requiredMode = Schema.RequiredMode.REQUIRED)
    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL)
    @JsonManagedReference	//!importante para serializacion y no generar bucle infinito
    private List<SaleItem> items = new ArrayList<>();

    public Sale() {
    	super();
    }
    
   // Getters y Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDateSale() {
		return dateSale;
	}

	public void setDateSale(String dateSale) {
		this.dateSale = dateSale;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<SaleItem> getItems() {
		return items;
	}

	public void setItems(List<SaleItem> items) {
		this.items = items;
	}

}