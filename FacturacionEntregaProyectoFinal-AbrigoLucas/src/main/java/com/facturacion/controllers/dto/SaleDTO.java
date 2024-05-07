package com.facturacion.controllers.dto;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Modelo de VentaDTO")
public class SaleDTO {
	@Schema(description = "Id de VentaDTO", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
	private Integer id;
	@Schema(description = "Fecha y hora de VentaDTO", requiredMode = Schema.RequiredMode.REQUIRED, example = "04-05-24 15:30:25")
	private String dateSale;
	@Schema(description = "Monto total de VentaDTO", requiredMode = Schema.RequiredMode.REQUIRED, example = "2500")
    private double totalSaleAmount;
	@Schema(description = "Objeto Cliente comprador", requiredMode = Schema.RequiredMode.REQUIRED)
    private ClientDTO client;
	@Schema(description = "Listado de productos vendidos", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<ItemSaleDTO> items;
    
    
	public SaleDTO() {
		super();
	}
	
	public SaleDTO(Integer id, String dateSale, double totalSaleAmount, ClientDTO client, List<ItemSaleDTO> items) {
		super();
		this.id = id;
		this.dateSale = dateSale;
		this.totalSaleAmount = totalSaleAmount;
		this.client = client;
		this.items = items;
	}


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


	public double getTotalSaleAmount() {
		return totalSaleAmount;
	}


	public void setTotalSaleAmount(double totalSaleAmount) {
		this.totalSaleAmount = totalSaleAmount;
	}


	public ClientDTO getClient() {
		return client;
	}


	public void setClient(ClientDTO client) {
		this.client = client;
	}


	public List<ItemSaleDTO> getItems() {
		return items;
	}


	public void setItems(List<ItemSaleDTO> items) {
		this.items = items;
	}

}