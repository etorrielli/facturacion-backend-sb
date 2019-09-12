package com.undec.facturacion.dto;

public class DetalleDTO {
	
	private Integer id;
	private Integer productoId;
	private int cantidad;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getProductoId() {
		return productoId;
	}
	public void setProductoId(Integer productoId) {
		this.productoId = productoId;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	

}
