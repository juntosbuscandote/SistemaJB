package pe.am.spring.entity;

public class TVoucherDashboardGet {
	private String voucVtipodoc;
	private String voucEstadoCdr;
	private String voucMes;
	private String voucYear;
	private String voucVmoneda;
	private Long busiBident;

	public Long getBusiBident() {
		return busiBident;
	}

	public void setBusiBident(Long busiBident) {
		this.busiBident = busiBident;
	}

	public String getVoucVtipodoc() {
		return voucVtipodoc;
	}

	public void setVoucVtipodoc(String voucVtipodoc) {
		this.voucVtipodoc = voucVtipodoc;
	}

	public String getVoucEstadoCdr() {
		return voucEstadoCdr;
	}

	public void setVoucEstadoCdr(String voucEstadoCdr) {
		this.voucEstadoCdr = voucEstadoCdr;
	}

	public String getVoucMes() {
		return voucMes;
	}

	public void setVoucMes(String voucMes) {
		this.voucMes = voucMes;
	}

	public String getVoucYear() {
		return voucYear;
	}

	public void setVoucYear(String voucYear) {
		this.voucYear = voucYear;
	}

	public String getVoucVmoneda() {
		return voucVmoneda;
	}

	public void setVoucVmoneda(String voucVmoneda) {
		this.voucVmoneda = voucVmoneda;
	}
}
