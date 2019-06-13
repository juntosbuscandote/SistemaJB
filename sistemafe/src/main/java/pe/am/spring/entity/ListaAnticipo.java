package pe.am.spring.entity;

import java.math.BigDecimal;

public class ListaAnticipo {
	Long idsale;
	String serie;
	String numero;
	BigDecimal saldoDisponible;
	BigDecimal saldoUtilizado;
	BigDecimal igvMontoUtil;
	BigDecimal saldoSinIGVUtil;

	public Long getIdsale() {
		return idsale;
	}

	public void setIdsale(Long idsale) {
		this.idsale = idsale;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public BigDecimal getSaldoDisponible() {
		return saldoDisponible;
	}

	public void setSaldoDisponible(BigDecimal saldoDisponible) {
		this.saldoDisponible = saldoDisponible;
	}

	public BigDecimal getSaldoUtilizado() {
		return saldoUtilizado;
	}

	public void setSaldoUtilizado(BigDecimal saldoUtilizado) {
		this.saldoUtilizado = saldoUtilizado;
	}

	public BigDecimal getIgvMontoUtil() {
		return igvMontoUtil;
	}

	public void setIgvMontoUtil(BigDecimal igvMontoUtil) {
		this.igvMontoUtil = igvMontoUtil;
	}

	public BigDecimal getSaldoSinIGVUtil() {
		return saldoSinIGVUtil;
	}

	public void setSaldoSinIGVUtil(BigDecimal saldoSinIGVUtil) {
		this.saldoSinIGVUtil = saldoSinIGVUtil;
	}

	
	
}
