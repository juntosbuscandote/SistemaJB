package pe.am.spring.entity;

import java.math.BigDecimal;

public class MontoComprobante {
	BigDecimal preciounitario;
	
	BigDecimal porcentajeigv;
	
	BigDecimal porcentajeDescuento;
	
	String indicadorAfecto;
	
	BigDecimal cantidad;

	public BigDecimal getPreciounitario() {
		return preciounitario;
	}

	public void setPreciounitario(BigDecimal preciounitario) {
		this.preciounitario = preciounitario;
	}

	public BigDecimal getPorcentajeigv() {
		return porcentajeigv;
	}

	public void setPorcentajeigv(BigDecimal porcentajeigv) {
		this.porcentajeigv = porcentajeigv;
	}

	public BigDecimal getPorcentajeDescuento() {
		return porcentajeDescuento;
	}

	public void setPorcentajeDescuento(BigDecimal porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}

	public String getIndicadorAfecto() {
		return indicadorAfecto;
	}

	public void setIndicadorAfecto(String indicadorAfecto) {
		this.indicadorAfecto = indicadorAfecto;
	}

	public BigDecimal getCantidad() {
		return cantidad;
	}

	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}
}
