package pe.am.spring.entity;
//import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

//import static com.fasterxml.jackson.annotation.JsonInclude.Include.*;
//import static org.apache.commons.lang3.builder.ToStringBuilder.*;
//import static org.apache.commons.lang3.builder.ToStringStyle.*;

import java.math.*;
import java.util.*;


//
//import javax.validation.*;
//import javax.validation.constraints.*;
//
//import org.framework.entity.*;
//import org.framework.validation.*;
//
//import com.fasterxml.jackson.annotation.*;
//
//import io.swagger.annotations.*;
//
//@JsonInclude(NON_NULL)
public class TSalesFilter {

	// @Size(max = 30)
	String vperiod;

	// @ApiModelProperty(value = "Fecha de movimiento de venta")
	Date sdetTmovementDate;

	// @ApiModelProperty(value = "Tipo de doc voucher")
	// @Size(max = 10)
	String vtipdocvoucher;

	// @Size(max = 200)
	// @ApiModelProperty(value = "Descripcion de sucursal")
	String vOfficePlace;

	// @ApiModelProperty(value = "Serie de venta")
	// @Size(max = 4)
	String vserievoucher;

	// @ApiModelProperty(value = "Numero de documento de vena")
	// @Size(max = 11)
	String vnumbervoucher;

	// @ApiModelProperty(value = "Tipo de documento de cliente")
	// @Size(max = 2)
	String vtype_doc_clie;

	// @ApiModelProperty(value = "Numero de documento de cliente")
	// @Size(max = 15)
	String bnumber_doc_clie;

	// @ApiModelProperty(value = "Nombre de empresa de cliente")
	// @Size(max = 200)
	String vbusiname_clie;

	// @ApiModelProperty(value = "tipo de documento de vendedor")
	// @Size(max = 200)
	String vtype_doc_seller;

	// @ApiModelProperty(value = "numero de vendedor")
	// @Size(max = 15)
	String bnumber_doc_seller;

	// @ApiModelProperty(value = "Empresa de vendedor")
	// @Size(max = 200)
	String vbusiname_seller;

	// @ApiModelProperty(value = "Fecha de registro de venta")
	Date sdetTregistrationDate;

	// @Size(max = 100)
	// @ApiModelProperty(value = "Descripcion de forma de pago")
	String vwaypay_name;

	// @ApiModelProperty(value = "Fecha de expiración de venta")
	Date sdetTexpiryDate;
	Date sdetPaymentDate;
	// @ApiModelProperty(value = "Nombre de moneda")
	// @Size(max = 10)
	String vname_coin;

	// @ApiModelProperty(value = "Tipo de cambio")
	// @Size(max = 5)
	String dexchange_rate;
	BigDecimal dresult_dfree;
	// @ApiModelProperty(value = "Resultado total de operacion gravada")
	BigDecimal dresult_grav;

	// @ApiModelProperty(value = "Resultado total de operacion Inafecto")
	BigDecimal dresult_inf;

	// @ApiModelProperty(value = "Resultado total de operacion Exonerado")
	BigDecimal dresult_exo;

	// @ApiModelProperty(value = "Resultado total de operacion Exportacion")
	BigDecimal dresult_exporta;

	// @ApiModelProperty(value = "Resultado total de operacion Neto")
	BigDecimal dresult_neto;

	// @ApiModelProperty(value = "Resultado total de operacion Igv")
	BigDecimal dresult_igv;
	// @ApiModelProperty(value = "Resultado total de operacion Descuento
	// global")
	BigDecimal dresult_discountglobal;
	// @ApiModelProperty(value = "Resultado total de Total")
	BigDecimal dresult_total;

	// @Size(max = 300)
	// @ApiModelProperty(value = "Observacion o asunto")
	String dresult_affair;

	// @ApiModelProperty(value = "Titulo gratuito")
	// @Size(max = 2)
	String dresult_titlegratuito;

	// @Min(1)
	// @ApiModelProperty(value = "Clave foranea de tabla Empresa")
	Long busiBident;

	// @ApiModelProperty(value = "Estado venta")
	String saleCstate;

	// @Min(1)
	// @ApiModelProperty(value = "Clave foranea de tabla Cliente")
	Long clieBident;

	BigDecimal drconversion;

	// @Min(1)
	// @ApiModelProperty(value = "Clave foranea de tabla Persona")
	Long persBident;
	//
	Long saleBident;

	String sale_url_pdf;

	String vouc_estado_cdr;
	
//	@ApiModelProperty(value = "Fecha de referencia del documento de  venta")
	Date saleTdocRefereceDate;
	
//	@Size(max = 25)
//	@ApiModelProperty(value = "Tipo de comprobante")
	String saleVcodTipReferece;
	

//	@Size(max = 25)
//	@ApiModelProperty(value = "Serie de comprobante")
	String saleVserieDocReferece;
	
//	@Size(max = 25)
//	@ApiModelProperty(value = "Numero de comprobante")
	String saleVnumDocReferece;

	String user_vuser;
	
	Long offiBident;
	
	String codigo_vregistro;
	
//	 @Size(max = 500)
//		@ApiModelProperty(value = "Numero de Guia")
		String SaleVguide;
	  
//	  @Size(max = 250)
//		@ApiModelProperty(value = "Orden de Pedido")
		String SaleVorderpurchase;
	
		String saleVstateCash;
		BigDecimal saleBsaldoPending;
		
		
	public String getSaleVstateCash() {
			return saleVstateCash;
		}

		public void setSaleVstateCash(String saleVstateCash) {
			this.saleVstateCash = saleVstateCash;
		}

		public BigDecimal getSaleBsaldoPending() {
			return saleBsaldoPending;
		}

		public void setSaleBsaldoPending(BigDecimal saleBsaldoPending) {
			this.saleBsaldoPending = saleBsaldoPending;
		}

	public String getSaleVguide() {
			return SaleVguide;
		}

		public void setSaleVguide(String saleVguide) {
			SaleVguide = saleVguide;
		}

		public String getSaleVorderpurchase() {
			return SaleVorderpurchase;
		}

		public void setSaleVorderpurchase(String saleVorderpurchase) {
			SaleVorderpurchase = saleVorderpurchase;
		}

	public String getCodigo_vregistro() {
		return codigo_vregistro;
	}

	public void setCodigo_vregistro(String codigo_vregistro) {
		this.codigo_vregistro = codigo_vregistro;
	}

	public Long getOffiBident() {
		return offiBident;
	}

	public void setOffiBident(Long offiBident) {
		this.offiBident = offiBident;
	}

	public String getUser_vuser() {
		return user_vuser;
	}

	public void setUser_vuser(String user_vuser) {
		this.user_vuser = user_vuser;
	}

	public Date getSaleTdocRefereceDate() {
		return saleTdocRefereceDate;
	}

	public void setSaleTdocRefereceDate(Date saleTdocRefereceDate) {
		this.saleTdocRefereceDate = saleTdocRefereceDate;
	}

	public String getSaleVcodTipReferece() {
		return saleVcodTipReferece;
	}

	public void setSaleVcodTipReferece(String saleVcodTipReferece) {
		this.saleVcodTipReferece = saleVcodTipReferece;
	}

	public String getSaleVserieDocReferece() {
		return saleVserieDocReferece;
	}

	public void setSaleVserieDocReferece(String saleVserieDocReferece) {
		this.saleVserieDocReferece = saleVserieDocReferece;
	}

	public String getSaleVnumDocReferece() {
		return saleVnumDocReferece;
	}

	public void setSaleVnumDocReferece(String saleVnumDocReferece) {
		this.saleVnumDocReferece = saleVnumDocReferece;
	}


	public String getVouc_estado_cdr() {
		return vouc_estado_cdr;
	}

	public void setVouc_estado_cdr(String vouc_estado_cdr) {
		this.vouc_estado_cdr = vouc_estado_cdr;
	}

	public String getSale_url_pdf() {
		return sale_url_pdf;
	}

	public void setSale_url_pdf(String sale_url_pdf) {
		this.sale_url_pdf = sale_url_pdf;
	}

	public Date getSdetPaymentDate() {
		return sdetPaymentDate;
	}

	public void setSdetPaymentDate(Date sdetPaymentDate) {
		this.sdetPaymentDate = sdetPaymentDate;
	}

	public BigDecimal getDresult_dfree() {
		return dresult_dfree;
	}

	public void setDresult_dfree(BigDecimal dresult_dfree) {
		this.dresult_dfree = dresult_dfree;
	}

	public BigDecimal getDrconversion() {
		return drconversion;
	}

	public void setDrconversion(BigDecimal drconversion) {
		this.drconversion = drconversion;
	}

	public Long getSaleBident() {
		return saleBident;
	}

	public void setSaleBident(Long saleBident) {
		this.saleBident = saleBident;
	}

	public Long getPersBident() {
		return persBident;
	}

	public void setPersBident(Long persBident) {
		this.persBident = persBident;
	}

	public Long getClieBident() {
		return clieBident;
	}

	public void setClieBident(Long clieBident) {
		this.clieBident = clieBident;
	}

	public String getVperiod() {
		return vperiod;
	}

	public void setVperiod(String vperiod) {
		this.vperiod = vperiod;
	}

	public Date getSdetTmovementDate() {
		return sdetTmovementDate;
	}

	public void setSdetTmovementDate(Date sdetTmovementDate) {
		this.sdetTmovementDate = sdetTmovementDate;
	}

	public String getVtipdocvoucher() {
		return vtipdocvoucher;
	}

	public void setVtipdocvoucher(String vtipdocvoucher) {
		this.vtipdocvoucher = vtipdocvoucher;
	}

	public String getvOfficePlace() {
		return vOfficePlace;
	}

	public void setvOfficePlace(String vOfficePlace) {
		this.vOfficePlace = vOfficePlace;
	}

	public String getVserievoucher() {
		return vserievoucher;
	}

	public void setVserievoucher(String vserievoucher) {
		this.vserievoucher = vserievoucher;
	}

	public String getVnumbervoucher() {
		return vnumbervoucher;
	}

	public void setVnumbervoucher(String vnumbervoucher) {
		this.vnumbervoucher = vnumbervoucher;
	}

	public String getVtype_doc_clie() {
		return vtype_doc_clie;
	}

	public void setVtype_doc_clie(String vtype_doc_clie) {
		this.vtype_doc_clie = vtype_doc_clie;
	}

	public String getBnumber_doc_clie() {
		return bnumber_doc_clie;
	}

	public void setBnumber_doc_clie(String bnumber_doc_clie) {
		this.bnumber_doc_clie = bnumber_doc_clie;
	}

	public String getVbusiname_clie() {
		return vbusiname_clie;
	}

	public void setVbusiname_clie(String vbusiname_clie) {
		this.vbusiname_clie = vbusiname_clie;
	}

	public String getVtype_doc_seller() {
		return vtype_doc_seller;
	}

	public void setVtype_doc_seller(String vtype_doc_seller) {
		this.vtype_doc_seller = vtype_doc_seller;
	}

	public String getBnumber_doc_seller() {
		return bnumber_doc_seller;
	}

	public void setBnumber_doc_seller(String bnumber_doc_seller) {
		this.bnumber_doc_seller = bnumber_doc_seller;
	}

	public String getVbusiname_seller() {
		return vbusiname_seller;
	}

	public void setVbusiname_seller(String vbusiname_seller) {
		this.vbusiname_seller = vbusiname_seller;
	}

	public Date getSdetTregistrationDate() {
		return sdetTregistrationDate;
	}

	public void setSdetTregistrationDate(Date sdetTregistrationDate) {
		this.sdetTregistrationDate = sdetTregistrationDate;
	}

	public String getVwaypay_name() {
		return vwaypay_name;
	}

	public void setVwaypay_name(String vwaypay_name) {
		this.vwaypay_name = vwaypay_name;
	}

	public Date getSdetTexpiryDate() {
		return sdetTexpiryDate;
	}

	public void setSdetTexpiryDate(Date sdetTexpiryDate) {
		this.sdetTexpiryDate = sdetTexpiryDate;
	}

	public String getVname_coin() {
		return vname_coin;
	}

	public void setVname_coin(String vname_coin) {
		this.vname_coin = vname_coin;
	}

	public String getDexchange_rate() {
		return dexchange_rate;
	}

	public void setDexchange_rate(String dexchange_rate) {
		this.dexchange_rate = dexchange_rate;
	}

	public BigDecimal getDresult_grav() {
		return dresult_grav;
	}

	public void setDresult_grav(BigDecimal dresult_grav) {
		this.dresult_grav = dresult_grav;
	}

	public BigDecimal getDresult_inf() {
		return dresult_inf;
	}

	public void setDresult_inf(BigDecimal dresult_inf) {
		this.dresult_inf = dresult_inf;
	}

	public BigDecimal getDresult_exo() {
		return dresult_exo;
	}

	public void setDresult_exo(BigDecimal dresult_exo) {
		this.dresult_exo = dresult_exo;
	}

	public BigDecimal getDresult_exporta() {
		return dresult_exporta;
	}

	public void setDresult_exporta(BigDecimal dresult_exporta) {
		this.dresult_exporta = dresult_exporta;
	}

	public BigDecimal getDresult_neto() {
		return dresult_neto;
	}

	public void setDresult_neto(BigDecimal dresult_neto) {
		this.dresult_neto = dresult_neto;
	}

	public BigDecimal getDresult_igv() {
		return dresult_igv;
	}

	public void setDresult_igv(BigDecimal dresult_igv) {
		this.dresult_igv = dresult_igv;
	}

	public BigDecimal getDresult_discountglobal() {
		return dresult_discountglobal;
	}

	public void setDresult_discountglobal(BigDecimal dresult_discountglobal) {
		this.dresult_discountglobal = dresult_discountglobal;
	}

	public BigDecimal getDresult_total() {
		return dresult_total;
	}

	public void setDresult_total(BigDecimal dresult_total) {
		this.dresult_total = dresult_total;
	}

	public String getDresult_affair() {
		return dresult_affair;
	}

	public void setDresult_affair(String dresult_affair) {
		this.dresult_affair = dresult_affair;
	}

	public String getDresult_titlegratuito() {
		return dresult_titlegratuito;
	}

	public void setDresult_titlegratuito(String dresult_titlegratuito) {
		this.dresult_titlegratuito = dresult_titlegratuito;
	}

	public Long getBusiBident() {
		return busiBident;
	}

	public void setBusiBident(Long busiBident) {
		this.busiBident = busiBident;
	}

	public String getSaleCstate() {
		return saleCstate;
	}

	public void setSaleCstate(String saleCstate) {
		this.saleCstate = saleCstate;
	}

	@Override
	public String toString() {
		return "TSalesFilter [vperiod=" + vperiod + ", sdetTmovementDate=" + sdetTmovementDate + ", vtipdocvoucher="
				+ vtipdocvoucher + ", vOfficePlace=" + vOfficePlace + ", vserievoucher=" + vserievoucher
				+ ", vnumbervoucher=" + vnumbervoucher + ", vtype_doc_clie=" + vtype_doc_clie + ", bnumber_doc_clie="
				+ bnumber_doc_clie + ", vbusiname_clie=" + vbusiname_clie + ", vtype_doc_seller=" + vtype_doc_seller
				+ ", bnumber_doc_seller=" + bnumber_doc_seller + ", vbusiname_seller=" + vbusiname_seller
				+ ", sdetTregistrationDate=" + sdetTregistrationDate + ", vwaypay_name=" + vwaypay_name
				+ ", sdetTexpiryDate=" + sdetTexpiryDate + ", sdetPaymentDate=" + sdetPaymentDate + ", vname_coin="
				+ vname_coin + ", dexchange_rate=" + dexchange_rate + ", dresult_dfree=" + dresult_dfree
				+ ", dresult_grav=" + dresult_grav + ", dresult_inf=" + dresult_inf + ", dresult_exo=" + dresult_exo
				+ ", dresult_exporta=" + dresult_exporta + ", dresult_neto=" + dresult_neto + ", dresult_igv="
				+ dresult_igv + ", dresult_discountglobal=" + dresult_discountglobal + ", dresult_total="
				+ dresult_total + ", dresult_affair=" + dresult_affair + ", dresult_titlegratuito="
				+ dresult_titlegratuito + ", busiBident=" + busiBident + ", saleCstate=" + saleCstate + ", clieBident="
				+ clieBident + ", drconversion=" + drconversion + ", persBident=" + persBident + ", saleBident="
				+ saleBident + ", sale_url_pdf=" + sale_url_pdf + ", vouc_estado_cdr=" + vouc_estado_cdr
				+ ", saleTdocRefereceDate=" + saleTdocRefereceDate + ", saleVcodTipReferece=" + saleVcodTipReferece
				+ ", saleVserieDocReferece=" + saleVserieDocReferece + ", saleVnumDocReferece=" + saleVnumDocReferece
				+ ", user_vuser=" + user_vuser + ", offiBident=" + offiBident + ", codigo_vregistro=" + codigo_vregistro
				+ ", SaleVguide=" + SaleVguide + ", SaleVorderpurchase=" + SaleVorderpurchase + ", saleVstateCash="
				+ saleVstateCash + ", saleBsaldoPending=" + saleBsaldoPending + "]";
	}

}
