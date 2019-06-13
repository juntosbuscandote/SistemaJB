package pe.am.spring.entity;
//import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

//import static com.fasterxml.jackson.annotation.JsonInclude.Include.*;
//import static org.apache.commons.lang3.builder.ToStringBuilder.*;
//import static org.apache.commons.lang3.builder.ToStringStyle.*;

import java.math.*;
import java.util.*;


public class TSalesDetailFilter {
	
	
//	 @Min(1)
//	  @ApiModelProperty(value = "Clave foranea de tabla Venta")
	  Long saleBident;
	 
//	 @Min(1)
//	  @ApiModelProperty(value = "Clave foranea de tabla Venta")
	  Long detailBident;
	
//	 @ApiModelProperty(value = "Codigo de Producto o Servicio")
//	@Size(max = 200)
	String sdetvcode;
   
	 
//	 @ApiModelProperty(value = "Codigo comercial de Producto o Servicio")
//	@Size(max = 200)
	String sdetvcommercialcode;
  
	 
//	 @ApiModelProperty(value = "Nombre corto de producto o servicio")
//	@Size(max = 200)
	String sdetvshortnameprod_serv;
	
	 
//	 @ApiModelProperty(value = "Descripcion de Producto o Servicio")
//	@Size(max = 200)
	String sdetvdescripprod_serv;
	
	
//	 @ApiModelProperty(value = "Concepto de producto o servicio")
//	@Size(max = 200)
	String sdetvconcept;
	
	 
//	 @ApiModelProperty(value = "Unidad De Medida")
//	@Size(max = 200)
	String sdetvvmeassure_unity;
	
//	 @ApiModelProperty(value = "Cantidad")
	BigDecimal sdetdquantity;
	
//	 @ApiModelProperty(value = "Valor unitario")
		BigDecimal sdetdvaluesunit;
	 
//	 @ApiModelProperty(value = "Igv unitario")
	BigDecimal sdetdigvunit;
	
	 
//	 @ApiModelProperty(value = "Precio unitario")
	BigDecimal sdetdpriceunit;
	
	 
//	 @ApiModelProperty(value = "Valor de venta")
	BigDecimal sdetdvaluesale;
	
	 
//	 @ApiModelProperty(value = "Porcentaje de descuento")
	BigDecimal sdetddescporcentage;
	
	 
//	 @ApiModelProperty(value = "Importe de descuento")
	BigDecimal sdetddescimport;
	
	 
//	 @ApiModelProperty(value = "valor de precio con descuento")
	BigDecimal sdetdiscountvaluepric;
	
	 
//	 @ApiModelProperty(value = "igv de precio con descuento")
	BigDecimal sdetdnigvdescupric;
	
	 
//	 @ApiModelProperty(value = "precio con descuento")
	BigDecimal sdetdiscountpric;
	
	 
//	 @ApiModelProperty(value = "Base imponible")
	BigDecimal sdetdtaxbase;
	
	 
//	 @ApiModelProperCCCCCCty(value = "Igv")
	BigDecimal sdetdigv;
	
	 
//	 @ApiModelProperty(value = "Total Bruto")
	BigDecimal sdetdgroostotal;
	
	 
//	 @ApiModelProperty(value = "Total neto")
	BigDecimal sdetdnettotal;
	
//	 @ApiModelProperty(value = "Indicador")
//	@Size(max = 50)
	String sdetvaffindicator;
	
//	 @ApiModelProperty(value = "Tipo de afectacion indicador")
//	@Size(max = 50)
	String sdetvtipaffecindicator;
	
//	 @ApiModelProperty(value = "Moneda de origen")
//	@Size(max = 50)
	String sdetvcoinorigin;
	
//	 
//	 @ApiModelProperty(value = "Moneda Destino")
//	@Size(max = 50)
	String sdetvcoincurrency;
	
	 

//	@ApiModelProperty(value = "Tipo de cambio")
	BigDecimal sdetdmountexchange;
	
//	 @ApiModelProperty(value = "Conversion")
	BigDecimal sdetdcurrencyconvers;

//	@ApiModelProperty(value = "Numero de venta")
	  Long sdetBnumber;
	
//	  @ApiModelProperty(value = "Incluir igv")
	  Boolean sdetBincludeIgv;

//	  @Size(max = 200)
//	  @ApiModelProperty(value = "Observacion de la venta")
	  String sdetVobservation;


//	  @Size(max = 50)
//	  @ApiModelProperty(value = "Transferencia libre")
	  String sdetVfreeTransfer;
	  
	  Long prodBident;
	  Long servBident;
	  
	  Long storeBident;
	  String sdetCflagNote;
	  BigDecimal sdetDcantNote;
	  String sdetVclassSunat;

	  
	  

	public Long getSdetBnumber() {
		return sdetBnumber;
	}




	public void setSdetBnumber(Long sdetBnumber) {
		this.sdetBnumber = sdetBnumber;
	}




	public Boolean getSdetBincludeIgv() {
		return sdetBincludeIgv;
	}




	public void setSdetBincludeIgv(Boolean sdetBincludeIgv) {
		this.sdetBincludeIgv = sdetBincludeIgv;
	}




	public String getSdetVobservation() {
		return sdetVobservation;
	}




	public void setSdetVobservation(String sdetVobservation) {
		this.sdetVobservation = sdetVobservation;
	}




	public String getSdetVfreeTransfer() {
		return sdetVfreeTransfer;
	}




	public void setSdetVfreeTransfer(String sdetVfreeTransfer) {
		this.sdetVfreeTransfer = sdetVfreeTransfer;
	}




	public Long getSaleBident() {
		return saleBident;
	}




	public void setSaleBident(Long saleBident) {
		this.saleBident = saleBident;
	}




	public Long getDetailBident() {
		return detailBident;
	}




	public void setDetailBident(Long detailBident) {
		this.detailBident = detailBident;
	}




	public String getSdetvcode() {
		return sdetvcode;
	}




	public void setSdetvcode(String sdetvcode) {
		this.sdetvcode = sdetvcode;
	}




	public String getSdetvcommercialcode() {
		return sdetvcommercialcode;
	}




	public void setSdetvcommercialcode(String sdetvcommercialcode) {
		this.sdetvcommercialcode = sdetvcommercialcode;
	}




	public String getSdetvshortnameprod_serv() {
		return sdetvshortnameprod_serv;
	}




	public void setSdetvshortnameprod_serv(String sdetvshortnameprod_serv) {
		this.sdetvshortnameprod_serv = sdetvshortnameprod_serv;
	}




	public String getSdetvdescripprod_serv() {
		return sdetvdescripprod_serv;
	}




	public void setSdetvdescripprod_serv(String sdetvdescripprod_serv) {
		this.sdetvdescripprod_serv = sdetvdescripprod_serv;
	}




	public String getSdetvconcept() {
		return sdetvconcept;
	}




	public void setSdetvconcept(String sdetvconcept) {
		this.sdetvconcept = sdetvconcept;
	}




	public String getSdetvvmeassure_unity() {
		return sdetvvmeassure_unity;
	}




	public void setSdetvvmeassure_unity(String sdetvvmeassure_unity) {
		this.sdetvvmeassure_unity = sdetvvmeassure_unity;
	}




	public BigDecimal getSdetdquantity() {
		return sdetdquantity;
	}




	public void setSdetdquantity(BigDecimal sdetdquantity) {
		this.sdetdquantity = sdetdquantity;
	}




	public BigDecimal getSdetdvaluesunit() {
		return sdetdvaluesunit;
	}




	public void setSdetdvaluesunit(BigDecimal sdetdvaluesunit) {
		this.sdetdvaluesunit = sdetdvaluesunit;
	}




	public BigDecimal getSdetdigvunit() {
		return sdetdigvunit;
	}




	public void setSdetdigvunit(BigDecimal sdetdigvunit) {
		this.sdetdigvunit = sdetdigvunit;
	}




	public BigDecimal getSdetdpriceunit() {
		return sdetdpriceunit;
	}




	public void setSdetdpriceunit(BigDecimal sdetdpriceunit) {
		this.sdetdpriceunit = sdetdpriceunit;
	}




	public BigDecimal getSdetdvaluesale() {
		return sdetdvaluesale;
	}




	public void setSdetdvaluesale(BigDecimal sdetdvaluesale) {
		this.sdetdvaluesale = sdetdvaluesale;
	}




	public BigDecimal getSdetddescporcentage() {
		return sdetddescporcentage;
	}




	public void setSdetddescporcentage(BigDecimal sdetddescporcentage) {
		this.sdetddescporcentage = sdetddescporcentage;
	}




	public BigDecimal getSdetddescimport() {
		return sdetddescimport;
	}




	public void setSdetddescimport(BigDecimal sdetddescimport) {
		this.sdetddescimport = sdetddescimport;
	}




	public BigDecimal getSdetdiscountvaluepric() {
		return sdetdiscountvaluepric;
	}




	public void setSdetdiscountvaluepric(BigDecimal sdetdiscountvaluepric) {
		this.sdetdiscountvaluepric = sdetdiscountvaluepric;
	}




	public BigDecimal getSdetdnigvdescupric() {
		return sdetdnigvdescupric;
	}




	public void setSdetdnigvdescupric(BigDecimal sdetdnigvdescupric) {
		this.sdetdnigvdescupric = sdetdnigvdescupric;
	}




	public BigDecimal getSdetdiscountpric() {
		return sdetdiscountpric;
	}




	public void setSdetdiscountpric(BigDecimal sdetdiscountpric) {
		this.sdetdiscountpric = sdetdiscountpric;
	}




	public BigDecimal getSdetdtaxbase() {
		return sdetdtaxbase;
	}




	public void setSdetdtaxbase(BigDecimal sdetdtaxbase) {
		this.sdetdtaxbase = sdetdtaxbase;
	}




	public BigDecimal getSdetdigv() {
		return sdetdigv;
	}




	public void setSdetdigv(BigDecimal sdetdigv) {
		this.sdetdigv = sdetdigv;
	}




	public BigDecimal getSdetdgroostotal() {
		return sdetdgroostotal;
	}




	public void setSdetdgroostotal(BigDecimal sdetdgroostotal) {
		this.sdetdgroostotal = sdetdgroostotal;
	}




	public BigDecimal getSdetdnettotal() {
		return sdetdnettotal;
	}




	public void setSdetdnettotal(BigDecimal sdetdnettotal) {
		this.sdetdnettotal = sdetdnettotal;
	}




	public String getSdetvaffindicator() {
		return sdetvaffindicator;
	}




	public void setSdetvaffindicator(String sdetvaffindicator) {
		this.sdetvaffindicator = sdetvaffindicator;
	}




	public String getSdetvtipaffecindicator() {
		return sdetvtipaffecindicator;
	}




	public void setSdetvtipaffecindicator(String sdetvtipaffecindicator) {
		this.sdetvtipaffecindicator = sdetvtipaffecindicator;
	}




	public String getSdetvcoinorigin() {
		return sdetvcoinorigin;
	}




	public void setSdetvcoinorigin(String sdetvcoinorigin) {
		this.sdetvcoinorigin = sdetvcoinorigin;
	}




	public String getSdetvcoincurrency() {
		return sdetvcoincurrency;
	}




	public void setSdetvcoincurrency(String sdetvcoincurrency) {
		this.sdetvcoincurrency = sdetvcoincurrency;
	}




	public BigDecimal getSdetdmountexchange() {
		return sdetdmountexchange;
	}




	public void setSdetdmountexchange(BigDecimal sdetdmountexchange) {
		this.sdetdmountexchange = sdetdmountexchange;
	}




	public BigDecimal getSdetdcurrencyconvers() {
		return sdetdcurrencyconvers;
	}




	public void setSdetdcurrencyconvers(BigDecimal sdetdcurrencyconvers) {
		this.sdetdcurrencyconvers = sdetdcurrencyconvers;
	}




	public Long getProdBident() {
		return prodBident;
	}




	public void setProdBident(Long prodBident) {
		this.prodBident = prodBident;
	}




	public Long getServBident() {
		return servBident;
	}




	public void setServBident(Long servBident) {
		this.servBident = servBident;
	}

	


	public Long getStoreBident() {
		return storeBident;
	}




	public void setStoreBident(Long storeBident) {
		this.storeBident = storeBident;
	}




	public String getSdetCflagNote() {
		return sdetCflagNote;
	}




	public void setSdetCflagNote(String sdetCflagNote) {
		this.sdetCflagNote = sdetCflagNote;
	}




	public BigDecimal getSdetDcantNote() {
		return sdetDcantNote;
	}




	public void setSdetDcantNote(BigDecimal sdetDcantNote) {
		this.sdetDcantNote = sdetDcantNote;
	}

	public String getSdetVclassSunat() {
		return sdetVclassSunat;
	}

	public void setSdetVclassSunat(String sdetVclassSunat) {
		this.sdetVclassSunat = sdetVclassSunat;
	}

	@Override
	public String toString() {
		return "TSalesDetailFilter [sdetvcommercialcode=" + sdetvcommercialcode + ", saleBident=" + saleBident + ", detailBident=" + detailBident
				+ ", sdetdgroostotal=" + sdetdgroostotal + ", sdetdmountexchange=" + sdetdmountexchange  + "]";
	}




	
}
