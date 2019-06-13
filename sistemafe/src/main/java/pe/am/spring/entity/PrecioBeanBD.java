package pe.am.spring.entity;

public class PrecioBeanBD {

	private String precValorVenta;
	private String precPrecVenta;
	private String precValorVentaDscto;
	private String precPrecioVentaDscto;
	private String precIgvVenta;
	private String precIgvVentaDscto;
	private boolean precPrincipal;
	private boolean precInclIgv;
	private String precDescrip;
	private String precDescripMoneda;
	private String precDescripDsctoConversion;
	private boolean precDescripDscto;
	private String tipoDesct;
	private String precDesct;

	public PrecioBeanBD() {
		super();
	}

	public String getPrecValorVenta() {
		return precValorVenta;
	}

	public void setPrecValorVenta(String precValorVenta) {
		this.precValorVenta = precValorVenta;
	}

	public String getPrecPrecVenta() {
		return precPrecVenta;
	}

	public void setPrecPrecVenta(String precPrecVenta) {
		this.precPrecVenta = precPrecVenta;
	}

	public String getPrecValorVentaDscto() {
		return precValorVentaDscto;
	}

	public void setPrecValorVentaDscto(String precValorVentaDscto) {
		this.precValorVentaDscto = precValorVentaDscto;
	}

	public String getPrecPrecioVentaDscto() {
		return precPrecioVentaDscto;
	}

	public void setPrecPrecioVentaDscto(String precPrecioVentaDscto) {
		this.precPrecioVentaDscto = precPrecioVentaDscto;
	}

	public String getPrecIgvVenta() {
		return precIgvVenta;
	}

	public void setPrecIgvVenta(String precIgvVenta) {
		this.precIgvVenta = precIgvVenta;
	}

	public String getPrecIgvVentaDscto() {
		return precIgvVentaDscto;
	}

	public void setPrecIgvVentaDscto(String precIgvVentaDscto) {
		this.precIgvVentaDscto = precIgvVentaDscto;
	}

	public boolean isPrecPrincipal() {
		return precPrincipal;
	}

	public void setPrecPrincipal(boolean precPrincipal) {
		this.precPrincipal = precPrincipal;
	}

	public boolean isPrecInclIgv() {
		return precInclIgv;
	}

	public void setPrecInclIgv(boolean precInclIgv) {
		this.precInclIgv = precInclIgv;
	}

	public String getPrecDescrip() {
		return precDescrip;
	}

	public void setPrecDescrip(String precDescrip) {
		this.precDescrip = precDescrip;
	}

	public String getPrecDescripMoneda() {
		return precDescripMoneda;
	}

	public void setPrecDescripMoneda(String precDescripMoneda) {
		this.precDescripMoneda = precDescripMoneda;
	}

	public String getPrecDescripDsctoConversion() {
		return precDescripDsctoConversion;
	}

	public void setPrecDescripDsctoConversion(String precDescripDsctoConversion) {
		this.precDescripDsctoConversion = precDescripDsctoConversion;
	}

	public boolean isPrecDescripDscto() {
		return precDescripDscto;
	}

	public void setPrecDescripDscto(boolean precDescripDscto) {
		this.precDescripDscto = precDescripDscto;
	}

	public String getTipoDesct() {
		return tipoDesct;
	}

	public void setTipoDesct(String tipoDesct) {
		this.tipoDesct = tipoDesct;
	}

	public String getPrecDesct() {
		return precDesct;
	}

	public void setPrecDesct(String precDesct) {
		this.precDesct = precDesct;
	}

}
