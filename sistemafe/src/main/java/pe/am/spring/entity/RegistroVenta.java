package pe.am.spring.entity;

import java.util.List;

public class RegistroVenta {
	TSalesPost sales;
	List<TSaleDetailPost> salesDatail;
	
	
	String tipoOper;
	String tipoDoc;
	String fechaEmision;
	String serieDoc;
	String nroDoc;
	
	String fechaVencDoc;
	String monedaDoc;
	String tipoCambioDoc;
	
	
	//datos del cliente
	String nombreCliente;
	String emailCliente;
	String direccionCliente;
	String nroDocCliente;
	String tipoDocCliente;
	
	//datos de la empresa 
	private String razonsocialEmpr;
	private String ubigeoEmpr;
	private String nombrecomercialEmpr;
	private String direccionEmpr;
	private String provinciaEmpr;
	private String departamentoEmpr;
	private String distritoEmpr;
	private String paisEmpr;
	private String nrorucEmpr;
	private String tipodocEmpr;
	
	String porcIgvDoc;
	String porcIscDoc;
	String montoDctoGlobalDoc;
	String montoTotalDctoDoc;
	String montoTotalAnticipoDoc;
	String montoTotalGravadaDoc;
	String montoTotalInafectaDoc;
	String montoTotalExoneradaDoc;
	String montoTotalIgvDoc;
	String montoTotalGratuitaDoc;
	String montoTotalOtrosCargosDoc;
	String montoTotalOtrosTrib;
	String montoTotalDoc;
	String montoIscDoc;
	
	
	String inafecto;
	String gravada;
	String exonerada;
	String exportacion;
	String gratuita;
	String neto;
	String igv;
	String importeDescuento;
	String total;
	String conversion;
	String nombreVendedor;
	String totalenletras;
	
	String idMetodoPago;
	
	String obs;
	
	String fecDocReferencia;
	String tipCompReferencia;
	String serCompReferencia;
	String nroCompReferencia;
	String codMotivoCre;
	String codMotivoDeb;
	
	String ejercicio;
	String idAlmacen;
	String idRegVenta;
	List<ListaAnticipo> listaAnticipo;
	
	public String getTotalenletras() {
		return totalenletras;
	}

	public void setTotalenletras(String totalenletras) {
		this.totalenletras = totalenletras;
	}

	public TSalesPost getSales() {
		return sales;
	}

	public void setSales(TSalesPost sales) {
		this.sales = sales;
	}

	public List<TSaleDetailPost> getSalesDatail() {
		return salesDatail;
	}

	public void setSalesDatail(List<TSaleDetailPost> salesDatail) {
		this.salesDatail = salesDatail;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getEmailCliente() {
		return emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	public String getInafecto() {
		return inafecto;
	}

	public void setInafecto(String inafecto) {
		this.inafecto = inafecto;
	}

	public String getGravada() {
		return gravada;
	}

	public void setGravada(String gravada) {
		this.gravada = gravada;
	}

	public String getExonerada() {
		return exonerada;
	}

	public void setExonerada(String exonerada) {
		this.exonerada = exonerada;
	}

	public String getExportacion() {
		return exportacion;
	}

	public void setExportacion(String exportacion) {
		this.exportacion = exportacion;
	}

	public String getGratuita() {
		return gratuita;
	}

	public void setGratuita(String gratuita) {
		this.gratuita = gratuita;
	}

	public String getNeto() {
		return neto;
	}

	public void setNeto(String neto) {
		this.neto = neto;
	}

	public String getIgv() {
		return igv;
	}

	public void setIgv(String igv) {
		this.igv = igv;
	}
	
	public String getImporteDescuento() {
		return importeDescuento;
	}

	public void setImporteDescuento(String importeDescuento) {
		this.importeDescuento = importeDescuento;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getConversion() {
		return conversion;
	}

	public void setConversion(String conversion) {
		this.conversion = conversion;
	}

	public String getTipoOper() {
		return tipoOper;
	}

	public void setTipoOper(String tipoOper) {
		this.tipoOper = tipoOper;
	}

	public String getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public String getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(String fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public String getSerieDoc() {
		return serieDoc;
	}

	public void setSerieDoc(String serieDoc) {
		this.serieDoc = serieDoc;
	}

	public String getNroDoc() {
		return nroDoc;
	}

	public void setNroDoc(String nroDoc) {
		this.nroDoc = nroDoc;
	}

	public String getFechaVencDoc() {
		return fechaVencDoc;
	}

	public void setFechaVencDoc(String fechaVencDoc) {
		this.fechaVencDoc = fechaVencDoc;
	}

	public String getMonedaDoc() {
		return monedaDoc;
	}

	public void setMonedaDoc(String monedaDoc) {
		this.monedaDoc = monedaDoc;
	}

	public String getTipoCambioDoc() {
		return tipoCambioDoc;
	}

	public void setTipoCambioDoc(String tipoCambioDoc) {
		this.tipoCambioDoc = tipoCambioDoc;
	}

	public String getPorcIgvDoc() {
		return porcIgvDoc;
	}

	public void setPorcIgvDoc(String porcIgvDoc) {
		this.porcIgvDoc = porcIgvDoc;
	}

	public String getPorcIscDoc() {
		return porcIscDoc;
	}

	public void setPorcIscDoc(String porcIscDoc) {
		this.porcIscDoc = porcIscDoc;
	}

	public String getMontoDctoGlobalDoc() {
		return montoDctoGlobalDoc;
	}

	public void setMontoDctoGlobalDoc(String montoDctoGlobalDoc) {
		this.montoDctoGlobalDoc = montoDctoGlobalDoc;
	}

	public String getMontoTotalDctoDoc() {
		return montoTotalDctoDoc;
	}

	public void setMontoTotalDctoDoc(String montoTotalDctoDoc) {
		this.montoTotalDctoDoc = montoTotalDctoDoc;
	}

	public String getMontoTotalAnticipoDoc() {
		return montoTotalAnticipoDoc;
	}

	public void setMontoTotalAnticipoDoc(String montoTotalAnticipoDoc) {
		this.montoTotalAnticipoDoc = montoTotalAnticipoDoc;
	}

	public String getMontoTotalGravadaDoc() {
		return montoTotalGravadaDoc;
	}

	public void setMontoTotalGravadaDoc(String montoTotalGravadaDoc) {
		this.montoTotalGravadaDoc = montoTotalGravadaDoc;
	}

	public String getMontoTotalInafectaDoc() {
		return montoTotalInafectaDoc;
	}

	public void setMontoTotalInafectaDoc(String montoTotalInafectaDoc) {
		this.montoTotalInafectaDoc = montoTotalInafectaDoc;
	}

	public String getMontoTotalExoneradaDoc() {
		return montoTotalExoneradaDoc;
	}

	public void setMontoTotalExoneradaDoc(String montoTotalExoneradaDoc) {
		this.montoTotalExoneradaDoc = montoTotalExoneradaDoc;
	}

	public String getMontoTotalIgvDoc() {
		return montoTotalIgvDoc;
	}

	public void setMontoTotalIgvDoc(String montoTotalIgvDoc) {
		this.montoTotalIgvDoc = montoTotalIgvDoc;
	}

	public String getMontoTotalGratuitaDoc() {
		return montoTotalGratuitaDoc;
	}

	public void setMontoTotalGratuitaDoc(String montoTotalGratuitaDoc) {
		this.montoTotalGratuitaDoc = montoTotalGratuitaDoc;
	}

	public String getMontoTotalOtrosCargosDoc() {
		return montoTotalOtrosCargosDoc;
	}

	public void setMontoTotalOtrosCargosDoc(String montoTotalOtrosCargosDoc) {
		this.montoTotalOtrosCargosDoc = montoTotalOtrosCargosDoc;
	}

	public String getMontoTotalOtrosTrib() {
		return montoTotalOtrosTrib;
	}

	public void setMontoTotalOtrosTrib(String montoTotalOtrosTrib) {
		this.montoTotalOtrosTrib = montoTotalOtrosTrib;
	}

	public String getMontoTotalDoc() {
		return montoTotalDoc;
	}

	public void setMontoTotalDoc(String montoTotalDoc) {
		this.montoTotalDoc = montoTotalDoc;
	}

	public String getMontoIscDoc() {
		return montoIscDoc;
	}

	public void setMontoIscDoc(String montoIscDoc) {
		this.montoIscDoc = montoIscDoc;
	}

	public String getDireccionCliente() {
		return direccionCliente;
	}

	public void setDireccionCliente(String direccionCliente) {
		this.direccionCliente = direccionCliente;
	}

	public String getNroDocCliente() {
		return nroDocCliente;
	}

	public void setNroDocCliente(String nroDocCliente) {
		this.nroDocCliente = nroDocCliente;
	}

	public String getTipoDocCliente() {
		return tipoDocCliente;
	}

	public void setTipoDocCliente(String tipoDocCliente) {
		this.tipoDocCliente = tipoDocCliente;
	}

	public String getRazonsocialEmpr() {
		return razonsocialEmpr;
	}

	public void setRazonsocialEmpr(String razonsocialEmpr) {
		this.razonsocialEmpr = razonsocialEmpr;
	}

	public String getUbigeoEmpr() {
		return ubigeoEmpr;
	}

	public void setUbigeoEmpr(String ubigeoEmpr) {
		this.ubigeoEmpr = ubigeoEmpr;
	}

	public String getNombrecomercialEmpr() {
		return nombrecomercialEmpr;
	}

	public void setNombrecomercialEmpr(String nombrecomercialEmpr) {
		this.nombrecomercialEmpr = nombrecomercialEmpr;
	}

	public String getDireccionEmpr() {
		return direccionEmpr;
	}

	public void setDireccionEmpr(String direccionEmpr) {
		this.direccionEmpr = direccionEmpr;
	}

	public String getProvinciaEmpr() {
		return provinciaEmpr;
	}

	public void setProvinciaEmpr(String provinciaEmpr) {
		this.provinciaEmpr = provinciaEmpr;
	}

	public String getDepartamentoEmpr() {
		return departamentoEmpr;
	}

	public void setDepartamentoEmpr(String departamentoEmpr) {
		this.departamentoEmpr = departamentoEmpr;
	}

	public String getDistritoEmpr() {
		return distritoEmpr;
	}

	public void setDistritoEmpr(String distritoEmpr) {
		this.distritoEmpr = distritoEmpr;
	}

	public String getPaisEmpr() {
		return paisEmpr;
	}

	public void setPaisEmpr(String paisEmpr) {
		this.paisEmpr = paisEmpr;
	}

	public String getNrorucEmpr() {
		return nrorucEmpr;
	}

	public void setNrorucEmpr(String nrorucEmpr) {
		this.nrorucEmpr = nrorucEmpr;
	}

	public String getTipodocEmpr() {
		return tipodocEmpr;
	}

	public void setTipodocEmpr(String tipodocEmpr) {
		this.tipodocEmpr = tipodocEmpr;
	}

	public String getNombreVendedor() {
		return nombreVendedor;
	}

	public void setNombreVendedor(String nombreVendedor) {
		this.nombreVendedor = nombreVendedor;
	}

	public String getIdMetodoPago() {
		return idMetodoPago;
	}

	public void setIdMetodoPago(String idMetodoPago) {
		this.idMetodoPago = idMetodoPago;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public String getFecDocReferencia() {
		return fecDocReferencia;
	}

	public void setFecDocReferencia(String fecDocReferencia) {
		this.fecDocReferencia = fecDocReferencia;
	}

	public String getTipCompReferencia() {
		return tipCompReferencia;
	}

	public void setTipCompReferencia(String tipCompReferencia) {
		this.tipCompReferencia = tipCompReferencia;
	}

	public String getSerCompReferencia() {
		return serCompReferencia;
	}

	public void setSerCompReferencia(String serCompReferencia) {
		this.serCompReferencia = serCompReferencia;
	}

	public String getNroCompReferencia() {
		return nroCompReferencia;
	}

	public void setNroCompReferencia(String nroCompReferencia) {
		this.nroCompReferencia = nroCompReferencia;
	}

	public String getCodMotivoCre() {
		return codMotivoCre;
	}

	public void setCodMotivoCre(String codMotivoCre) {
		this.codMotivoCre = codMotivoCre;
	}

	public String getCodMotivoDeb() {
		return codMotivoDeb;
	}

	public void setCodMotivoDeb(String codMotivoDeb) {
		this.codMotivoDeb = codMotivoDeb;
	}

	public String getEjercicio() {
		return ejercicio;
	}

	public void setEjercicio(String ejercicio) {
		this.ejercicio = ejercicio;
	}

	public String getIdAlmacen() {
		return idAlmacen;
	}

	public void setIdAlmacen(String idAlmacen) {
		this.idAlmacen = idAlmacen;
	}

	public String getIdRegVenta() {
		return idRegVenta;
	}

	public void setIdRegVenta(String idRegVenta) {
		this.idRegVenta = idRegVenta;
	}

	public List<ListaAnticipo> getListaAnticipo() {
		return listaAnticipo;
	}

	public void setListaAnticipo(List<ListaAnticipo> listaAnticipo) {
		this.listaAnticipo = listaAnticipo;
	}
	
}
