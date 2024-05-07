package com.facturacion.models.entity;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Api para obtener hora actual")
public class TimeApi {
	
	@Schema(description = "Variable para almacenar la fecha y hs actual")
	private String datetime;

	public TimeApi() {
		super();
	}

	public TimeApi(String datetime) {
		super();
		this.datetime = datetime;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	@Override
	public String toString() {
		return "TimeApi [dateTime=" + datetime + ", getDateTime()=" + getDatetime() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	

}
