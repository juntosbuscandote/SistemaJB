package pe.am.spring.entity;

public class RptaRegistroVenta {

	Long idVenta;
	String nroCPE;
	String serieCPE;

	String codRptaApp;
	String msjRptaApp;

	String codRptaSunat;
	String codMsjSunat;
	String notaSunat;

	String urlPDFVenta;

	String urlPDFComprSunat;
	String urlXMLSunat;
	String urlXMLRSunat;
	
	public RptaRegistroVenta() {
		
	}
	
	public RptaRegistroVenta(Long idVenta, String nroCPE, String serieCPE, String codRptaApp, String msjRptaApp,
			String codRptaSunat, String codMsjSunat, String notaSunat, String urlPDFVenta, String urlPDFComprSunat,
			String urlXMLSunat, String urlXMLRSunat) {
		super();
		this.idVenta = idVenta;
		this.nroCPE = nroCPE;
		this.serieCPE = serieCPE;
		this.codRptaApp = codRptaApp;
		this.msjRptaApp = msjRptaApp;
		this.codRptaSunat = codRptaSunat;
		this.codMsjSunat = codMsjSunat;
		this.notaSunat = notaSunat;
		this.urlPDFVenta = urlPDFVenta;
		this.urlPDFComprSunat = urlPDFComprSunat;
		this.urlXMLSunat = urlXMLSunat;
		this.urlXMLRSunat = urlXMLRSunat;
	}

	public Long getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(Long idVenta) {
		this.idVenta = idVenta;
	}

	public String getNroCPE() {
		return nroCPE;
	}

	public void setNroCPE(String nroCPE) {
		this.nroCPE = nroCPE;
	}

	public String getSerieCPE() {
		return serieCPE;
	}

	public void setSerieCPE(String serieCPE) {
		this.serieCPE = serieCPE;
	}

	public String getCodRptaApp() {
		return codRptaApp;
	}

	public void setCodRptaApp(String codRptaApp) {
		this.codRptaApp = codRptaApp;
	}

	public String getMsjRptaApp() {
		return msjRptaApp;
	}

	public void setMsjRptaApp(String msjRptaApp) {
		this.msjRptaApp = msjRptaApp;
	}

	public String getCodRptaSunat() {
		return codRptaSunat;
	}

	public void setCodRptaSunat(String codRptaSunat) {
		this.codRptaSunat = codRptaSunat;
	}

	public String getCodMsjSunat() {
		return codMsjSunat;
	}

	public void setCodMsjSunat(String codMsjSunat) {
		this.codMsjSunat = codMsjSunat;
	}

	public String getNotaSunat() {
		return notaSunat;
	}

	public void setNotaSunat(String notaSunat) {
		this.notaSunat = notaSunat;
	}

	public String getUrlPDFVenta() {
		return urlPDFVenta;
	}

	public void setUrlPDFVenta(String urlPDFVenta) {
		this.urlPDFVenta = urlPDFVenta;
	}

	public String getUrlPDFComprSunat() {
		return urlPDFComprSunat;
	}

	public void setUrlPDFComprSunat(String urlPDFComprSunat) {
		this.urlPDFComprSunat = urlPDFComprSunat;
	}

	public String getUrlXMLSunat() {
		return urlXMLSunat;
	}

	public void setUrlXMLSunat(String urlXMLSunat) {
		this.urlXMLSunat = urlXMLSunat;
	}

	public String getUrlXMLRSunat() {
		return urlXMLRSunat;
	}

	public void setUrlXMLRSunat(String urlXMLRSunat) {
		this.urlXMLRSunat = urlXMLRSunat;
	}

}
