package pe.am.spring.entity;

import java.math.BigDecimal;

public class TVoucherDashboard {
	private String meses;
	private String tipoDoc;
	private BigDecimal montoTotal;
	private Long totalComprobantes;
	private Long busiBident;

	public Long getBusiBident() {
		return busiBident;
	}

	public void setBusiBident(Long busiBident) {
		this.busiBident = busiBident;
	}

	public String getMeses() {
		return meses;
	}

	public void setMeses(String meses) {
		this.meses = meses;
	}

	public String getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public BigDecimal getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(BigDecimal montoTotal) {
		this.montoTotal = montoTotal;
	}

	public Long getTotalComprobantes() {
		return totalComprobantes;
	}

	public void setTotalComprobantes(Long totalComprobantes) {
		this.totalComprobantes = totalComprobantes;
	}

}
