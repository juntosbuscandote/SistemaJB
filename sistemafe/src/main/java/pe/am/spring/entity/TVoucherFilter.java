package pe.am.spring.entity;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(NON_NULL)
public class TVoucherFilter {

	private Long id;
	private Date fechaEmision;
	private String tipoDoc;
	private String tipoDocDescr;
	private String nroDoc;
	private String emprRS;
	private String emprTipoDoc;
	private String emprTipoDocDescr;
	private String empreNroDoc;
	private String monedaDescr;
	private String moneda;
	private String total;
	private String urlXML;
	private String urlCDR;
	private String urlPDF;
	private String estadoSistema;
	private String estadoSunat;
	private String empreNroDocEst;
	private String nroDocEst;
	private String totalEst;
	private String nombreCliente;
	private String numeroCliente;
	private String obs;
	private String tipodocCliente;
	
	
	

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public String getTipodocCliente() {
		return tipodocCliente;
	}

	public void setTipodocCliente(String tipodocCliente) {
		this.tipodocCliente = tipodocCliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public String getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public String getNroDoc() {
		return nroDoc;
	}

	public void setNroDoc(String nroDoc) {
		this.nroDoc = nroDoc;
	}

	public String getEmprRS() {
		return emprRS;
	}

	public void setEmprRS(String emprRS) {
		this.emprRS = emprRS;
	}

	public String getEmprTipoDoc() {
		return emprTipoDoc;
	}

	public void setEmprTipoDoc(String emprTipoDoc) {
		this.emprTipoDoc = emprTipoDoc;
	}

	public String getEmpreNroDoc() {
		return empreNroDoc;
	}

	public void setEmpreNroDoc(String empreNroDoc) {
		this.empreNroDoc = empreNroDoc;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getUrlXML() {
		return urlXML;
	}

	public void setUrlXML(String urlXML) {
		this.urlXML = urlXML;
	}

	public String getUrlCDR() {
		return urlCDR;
	}

	public void setUrlCDR(String urlCDR) {
		this.urlCDR = urlCDR;
	}

	public String getUrlPDF() {
		return urlPDF;
	}

	public void setUrlPDF(String urlPDF) {
		this.urlPDF = urlPDF;
	}

	public String getTipoDocDescr() {
		return tipoDocDescr;
	}

	public void setTipoDocDescr(String tipoDocDescr) {
		this.tipoDocDescr = tipoDocDescr;
	}

	public String getEmprTipoDocDescr() {
		return emprTipoDocDescr;
	}

	public void setEmprTipoDocDescr(String emprTipoDocDescr) {
		this.emprTipoDocDescr = emprTipoDocDescr;
	}

	public String getMonedaDescr() {
		return monedaDescr;
	}

	public void setMonedaDescr(String monedaDescr) {
		this.monedaDescr = monedaDescr;
	}

	public String getEstadoSistema() {
		return estadoSistema;
	}

	public void setEstadoSistema(String estadoSistema) {
		this.estadoSistema = estadoSistema;
	}

	public String getEstadoSunat() {
		return estadoSunat;
	}

	public void setEstadoSunat(String estadoSunat) {
		this.estadoSunat = estadoSunat;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getEmpreNroDocEst() {
		return empreNroDocEst;
	}

	public void setEmpreNroDocEst(String empreNroDocEst) {
		this.empreNroDocEst = empreNroDocEst;
	}

	public String getNroDocEst() {
		return nroDocEst;
	}

	public void setNroDocEst(String nroDocEst) {
		this.nroDocEst = nroDocEst;
	}

	public String getTotalEst() {
		return totalEst;
	}

	public void setTotalEst(String totalEst) {
		this.totalEst = totalEst;
	}

	public String getNumeroCliente() {
		return numeroCliente;
	}

	public void setNumeroCliente(String numeroCliente) {
		this.numeroCliente = numeroCliente;
	}

}
