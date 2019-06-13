package pe.am.spring.entity;


public class TSalesDashboardGet {
	private String saleVtipodoc;
	private String saleEstadoCdr;
	private String saleMes;
	private String saleYear;
	private String saleTmoneda;
	private Long busiBident;

	public Long getBusiBident() {
		return busiBident;
	}

	public void setBusiBident(Long busiBident) {
		this.busiBident = busiBident;
	}

	public String getSaleVtipodoc() {
		return saleVtipodoc;
	}

	public void setSaleVtipodoc(String saleVtipodoc) {
		this.saleVtipodoc = saleVtipodoc;
	}

	public String getsaleEstadoCdr() {
		return saleEstadoCdr;
	}

	public void setsaleEstadoCdr(String saleEstadoCdr) {
		this.saleEstadoCdr = saleEstadoCdr;
	}

	public String getSaleMes() {
		return saleMes;
	}

	public void setSaleMes(String saleMes) {
		this.saleMes = saleMes;
	}

	public String getSaleYear() {
		return saleYear;
	}

	public void setSaleYear(String saleYear) {
		this.saleYear = saleYear;
	}

	public String getsaleTmoneda() {
		return saleTmoneda;
	}

	public void setsaleTmoneda(String saleTmoneda) {
		this.saleTmoneda = saleTmoneda;
	}

}
