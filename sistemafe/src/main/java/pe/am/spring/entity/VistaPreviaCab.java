package pe.am.spring.entity;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.*;
import static org.apache.commons.lang3.builder.ToStringBuilder.*;
import static org.apache.commons.lang3.builder.ToStringStyle.*;

import java.math.*;
import java.util.*;

import com.fasterxml.jackson.annotation.*;



/**
 * <strong>t_sales</strong><br>
 * Tabla de ventas
 */
@JsonInclude(NON_NULL)
public class VistaPreviaCab {
	
	List<VistaPreviaDet> detalle;


public List<VistaPreviaDet> getDetalle() {
		return detalle;
	}




	public void setDetalle(List<VistaPreviaDet> detalle) {
		this.detalle = detalle;
	}




	//	@NotNull(groups = { OperacionPut.class })
//	  @Null(groups = { OperacionPost.class })
//	  @Min(1)
//	  @ApiModelProperty(value = "Clave primaria de ventas")
	  Long saleBident;

	  /**
	   * <strong>office_bident character varying</strong><br>
	   * Descripcion de sucursal
	   */
//	  @Size(max = 200)
//	  @ApiModelProperty(value = "Descripcion de sucursal")
	  String officeBident;

	  /**
	   * <strong>waypay_bident character varying</strong><br>
	   * Descripcion de forma de pago
	   */
//	  @Size(max = 100)
//	  @ApiModelProperty(value = "Descripcion de forma de pago")
	  String waypayBident;

	  /**
	   * <strong>coin_bident character varying</strong><br>
	   * Descripcion de moneda
	   */
//	  @Size(max =cue = "Descripcion de moneda")
	  String coinBident;

	  /**
	   * <strong>sale_vperiod character varying</strong><br>
	   * Periodo de venta en meses
	   */
//	  @Size(max = 100)
//	  @ApiModelProperty(value = "Periodo de venta en meses")
	  String saleVperiod;

	  /**
	   * <strong>sale_tmovement_date timestamp without time zone</strong><br>
	   * Fecha de movimiento de venta
	   */
//	  @ApiModelProperty(value = "Fecha de movimiento de venta")
	  Date saleTmovementDate;

	  /**
	   * <strong>sale_texchange_rate character varying</strong><br>
	   * Tipo de cambio para monto
	   */
//	  @Size(max =ccccalue = "Tipo de cambio para monto")
	  String saleTexchangeRate;

	  /**
	   * <strong>sale_voperation_register_number character varying</strong><br>
	   * Numero de registro de de operacion
	   */
//	  @Size(max = 100)
//	  @ApiModelProperty(value = "Numero de registro de de operacion")
	  String saleVoperationRegisterNumber;

	  /**
	   * <strong>sale_bnumber_day bigint</strong><br>
	   * Numero de dias de ventas
	   */
//	  @ApiModelProperty(value = "Numero de dias de ventas")
	  Long saleBnumberDay;

	  /**
	   * <strong>sale_tpayment_date timestamp without time zone</strong><br>
	   * Fecha de pago y cobro de venta
	   */
//	  @ApiModelProperty(value = "Fecha de pago y cobro de venta")
	  Date saleTpaymentDate;

	  /**
	   * <strong>sale_tdate_expiry timestamp without time zone</strong><br>
	   * Fecha de caducidad de la venta
	   */
//	  @ApiModelProperty(value = "Fecha de caducidad de la venta")
	  Date saleTdateExpiry;

	  /**
	   * <strong>sale_vtype_voucher character varying</strong><br>
	   * Tipo de comprobante
	   */
//	  @Size(max = 100)
//	  @ApiModelProperty(value = "Tipo de comprobante")
	  String saleVtypeVoucher;

	  /**
	   * <strong>sale_vserie_voucher character varying</strong><br>
	   * Numero de serie de comprobante
	   */
//	  @Size(max = 200)
//	  @ApiModelProperty(value = "Numero de serie de comprobante")
	  String saleVserieVoucher;

	  /**
	   * <strong>sale_vnumber_voucher character varying</strong><br>
	   * Numero de comprobante
	   */
//	  @Size(max = 500)
//	  @ApiModelProperty(value = "Numero de comprobante")
	  String saleVnumberVoucher;

	  /**
	   * <strong>sale_vtype_doc_clie character varying</strong><br>
	   * Tipo de documento del cliente
	   */
//	  @Size(max = 30)
//	  @ApiModelProperty(value = "Tipo de documento del cliente")
	  String saleVtypeDocClie;

	  /**
	   * <strong>sale_bnumber_doc_clie character varying</strong><br>
	   * Numero de documento del cliente
	   */
//	  @Size(max = 100)
//	  @ApiModelProperty(value = "Numero de documento del cliente")
	  String saleBnumberDocClie;

	  /**
	   * <strong>sale_vbusiname_client character varying</strong><br>
	   * Razon social del cliente
	   */
//	  @Size(max = 200)
//	  @ApiModelProperty(value = "Razon social del cliente")
	  String saleVbusinameClient;

	  /**
	   * <strong>sale_vaddress_client character varying</strong>
	   */
//	  @Size(max = 200)
	  String saleVaddressClient;

	  /**
	   * <strong>sale_vtype_doc_seller character varying</strong><br>
	   * Tipo de documento de vendedor
	   */
//	  @Size(max = 30)
//	  @ApiModelProperty(value = "Tipo de documento de vendedor")
	  String saleVtypeDocSeller;

	  /**
	   * <strong>sale_bnumber_doc_seller character varying</strong><br>
	   * Numero de documento de vendedor
	   */
//	  @Size(max = 100)
//	  @ApiModelProperty(value = "Numero de documento de vendedor")
	  String saleBnumberDocSeller;

	  /**
	   * <strong>sale_vbusiname_seller character varying</strong><br>
	   * Razon social o nombre de vendedor
	   */
//	  @Size(max = 200)
//	  @ApiModelProperty(value = "Razon social o nombre de vendedor")
	  String saleVbusinameSeller;

	  /**
	   * <strong>sale_vaffair character varying</strong><br>
	   * Asunto de venta
	   */
//	  @Size(max = 200)
//	  @ApiModelProperty(value = "Asunto de venta")
	  String saleVaffair;

	  /**
	   * <strong>sale_cstate_purchaseorder character</strong><br>
	   * Estado de orden de pedido o venta
	   */
//	  @Size(max = 2)
//	  @ApiModelProperty(value = "Estado de orden de pedido o venta")
	  String saleCstatePurchaseorder;

	  /**
	   * <strong>sale_tregistration_date timestamp without time zone</strong><br>
	   * Fecha de creacion de ventas
	   */
//	  @ApiModelProperty(value = "Fecha de creacion de ventas")
	  Date saleTregistrationDate;

	  /**
	   * <strong>sale_tdate_update timestamp without time zone</strong><br>
	   * Fecha de actualizacion de ventas
	   */
//	  @ApiModelProperty(value = "Fecha de actualizacion de ventas")
	  Date saleTdateUpdate;

	  /**
	   * <strong>sale_buser_create character varying</strong><br>
	   * Codigo de usuario que crea la venta
	   */
//	  @Size(max = 100)
//	  @ApiModelProperty(value = "Codigo de usuario que crea la venta")
	  String saleBuserCreate;

	  /**
	   * <strong>sale_buser_modify character varying</strong><br>
	   * Codigo deusuario que modifica la venta
	   */
//	  @Size(max = 100)
//	  @ApiModelProperty(value = "Codigo deusuario que modifica la venta")
	  String saleBuserModify;

	  /**
	   * <strong>sale_bdoc_advance character</strong><br>
	   * Documento de anticipo para la venta
	   */
//	  @Size(max = 2)
//	  @ApiModelProperty(value = "Documento de anticipo para la venta")
	  String saleBdocAdvance;

	  /**
	   * <strong>sale_vtype_indicator_afecto character varying</strong><br>
	   * Tipo de indicador afecto
	   */
//	  @Size(max = 100)
//	  @ApiModelProperty(value = "Tipo de indicador afecto")
	  String saleVtypeIndicatorAfecto;

	  /**
	   * <strong>sale_vsale_title_free character</strong><br>
	   * Venta a titulo gratuito
	   */
//	  @Size(max = 2)
//	  @ApiModelProperty(value = "Venta a titulo gratuito")
	  String saleVsaleTitleFree;

	  /**
	   * <strong>sale_vindicator_afecto character varying</strong><br>
	   * Indicador afecto
	   */
//	  @Size(max = 100)
//	  @ApiModelProperty(value = "Indicador afecto")
	  String saleVindicatorAfecto;

	  /**
	   * <strong>type_bident bigint</strong><br>
	   * Clave foranea de tabla tipo de cambio
	   */
//	  @Min(1)
//	  @ApiModelProperty(value = "Clave foranea de tabla tipo de cambio")
	  Long typeBident;

	  /**
	   * <strong>empl_bident bigint</strong><br>
	   * Clave foranea de tabla empleado
	   */
//	  @Min(1)
//	  @ApiModelProperty(value = "Clave foranea de tabla empleado")
	  Long emplBident;

	  /**
	   * <strong>clie_bident bigint</strong><br>
	   * Clave foranea de tabla cliente
	   */
//	  @Min(1)
//	  @ApiModelProperty(value = "Clave foranea de tabla cliente")
	  Long clieBident;

	  /**
	   * <strong>sale_dunaffected numeric</strong><br>
	   * total inafecto de resultados de venta de producto o servicios
	   */
//	  @ApiModelProperty(value = "total inafecto de resultados de venta de producto o servicios")
	  BigDecimal saleDunaffected;
	  
	  /**
	   * <strong>sale_dexonerated numeric</strong><br>
	   * total exonerada de resultados de venta de producto o servicios
	   */
//	  @ApiModelProperty(value = "total exonerada de resultados de venta de producto o servicios")
	  BigDecimal saleDexonerated;
	  
	  /**
	   * <strong>sale_dtaxed_bim numeric</strong><br>
	   * total gravado de base imponible  en resultados de venta de producto o servicios
	   */
//	  @ApiModelProperty(value = "total gravado de base imponible  en resultados de venta de producto o servicios")
	  BigDecimal saleDtaxedBim;
	  
	  /**
	   * <strong>sale_dexport numeric</strong><br>
	   * total exportacion en resultados de venta de producto o servicios
	   */
//	  @ApiModelProperty(value = "total exportacion en resultados de venta de producto o servicios")
	  BigDecimal saleDexport;
	  
	  /**
	   * <strong>sale_dfree_amount numeric</strong><br>
	   * total monto de venta gratuita en resultados de venta de producto o servicios
	   */
//	  @ApiModelProperty(value = "total monto de venta gratuita en resultados de venta de producto o servicios")
	  BigDecimal saleDfreeAmount;
	  
	  /**
	   * <strong>sale_dnet numeric</strong><br>
	   * total neto en resultados de venta de producto o servicios
	   */
//	  @ApiModelProperty(value = "total neto en resultados de venta de producto o servicios")
	  BigDecimal saleDnet;
	  
	  /**
	   * <strong>sale_digv numeric</strong><br>
	   * total igv en resultados de venta de producto o servicios
	   */
//	  @ApiModelProperty(value = "total igv en resultados de venta de producto o servicios")
	  BigDecimal saleDigv;
	  
	  /**
	   * <strong>sale_ddiscount numeric</strong><br>
	   * total de descuento en resultados de venta de producto o servicios
	   */
//	  @ApiModelProperty(value = "total de descuento en resultados de venta de producto o servicios")
	  BigDecimal saleDdiscount;
	  
	  /**
	  * <strong>sale_dtotal numeric</strong><br>
	  * total en resultados de venta de producto o servicios
	  */
//	  @ApiModelProperty(value = "total en resultados de venta de producto o servicios")
	  BigDecimal saleDtotal;
	 
		 /**
		 * <strong>sale_dconversion numeric</strong><br>
		 * total de conversion de moneda origen a destino en resultados de venta de producto o servicios
		 */
//		@ApiModelProperty(value = "total de conversion de moneda origen a destino en resultados de venta de producto o servicios")
		BigDecimal saleDconversion;
	 
		 /**
		 * <strong>sale_dtotal_amount_letters numeric</strong><br>
		 * total monto en letras en resultados de venta de producto o servicios
		 */
//		  @Size(max = 300)
//		@ApiModelProperty(value = "total monto en letras en resultados de venta de producto o servicios")
		String SaleVtotalAmountLetters;
	 
		  
		  /**
			 * <strong>busi_bident bigint</strong><br>
			 * Clave foranea de tabla Empresa
			 */
//		  @Min(1)
//		  @ApiModelProperty(value = "Clave foranea de tabla Empresa")
		  Long busiBident;
		
		  /**
				 * <strong>sale_banulate boolean</strong><br>
				 * Estado anulado
				 */
//		  @ApiModelProperty(value = "Estado venta")
		  String saleCstate;

		  String saleUrlPdf;
//		  @ApiModelProperty(value = "Valor total en resultados de venta de producto o servicios sin descuento")
		  BigDecimal saleDvaluetotal;
		  
		  String saleBcodMotivoNotaCredito;
		  String saleBcodMotivoNotaDebito;
		  String saleVcodTipReferece;
		  String saleVserieDocReferece;
		  String saleVnumDocReferece;
		  Date saleTdocRefereceDate;
		  
		  String saleVexercise;
		  Long repoBident;
		  
		  
//		  @Size(max = 500)
//			@ApiModelProperty(value = "Numero de Guia")
			String SaleVguide;
		  
//		  @Size(max = 250)
//			@ApiModelProperty(value = "Orden de Pedido")
			String SaleVorderpurchase;
		  

			
			
			
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




public BigDecimal getSaleDvaluetotal() {
			return saleDvaluetotal;
		}




		public void setSaleDvaluetotal(BigDecimal saleDvaluetotal) {
			this.saleDvaluetotal = saleDvaluetotal;
		}




public Long getSaleBident() {
			return saleBident;
		}




		public void setSaleBident(Long saleBident) {
			this.saleBident = saleBident;
		}




		public String getOfficeBident() {
			return officeBident;
		}




		public void setOfficeBident(String officeBident) {
			this.officeBident = officeBident;
		}




		public String getWaypayBident() {
			return waypayBident;
		}




		public void setWaypayBident(String waypayBident) {
			this.waypayBident = waypayBident;
		}




		public String getCoinBident() {
			return coinBident;
		}




		public void setCoinBident(String coinBident) {
			this.coinBident = coinBident;
		}




		public String getSaleVperiod() {
			return saleVperiod;
		}




		public void setSaleVperiod(String saleVperiod) {
			this.saleVperiod = saleVperiod;
		}




		public Date getSaleTmovementDate() {
			return saleTmovementDate;
		}




		public void setSaleTmovementDate(Date saleTmovementDate) {
			this.saleTmovementDate = saleTmovementDate;
		}




		public String getSaleTexchangeRate() {
			return saleTexchangeRate;
		}




		public void setSaleTexchangeRate(String saleTexchangeRate) {
			this.saleTexchangeRate = saleTexchangeRate;
		}




		public String getSaleVoperationRegisterNumber() {
			return saleVoperationRegisterNumber;
		}




		public void setSaleVoperationRegisterNumber(String saleVoperationRegisterNumber) {
			this.saleVoperationRegisterNumber = saleVoperationRegisterNumber;
		}




		public Long getSaleBnumberDay() {
			return saleBnumberDay;
		}




		public void setSaleBnumberDay(Long saleBnumberDay) {
			this.saleBnumberDay = saleBnumberDay;
		}




		public Date getSaleTpaymentDate() {
			return saleTpaymentDate;
		}




		public void setSaleTpaymentDate(Date saleTpaymentDate) {
			this.saleTpaymentDate = saleTpaymentDate;
		}




		public Date getSaleTdateExpiry() {
			return saleTdateExpiry;
		}




		public void setSaleTdateExpiry(Date saleTdateExpiry) {
			this.saleTdateExpiry = saleTdateExpiry;
		}




		public String getSaleVtypeVoucher() {
			return saleVtypeVoucher;
		}




		public void setSaleVtypeVoucher(String saleVtypeVoucher) {
			this.saleVtypeVoucher = saleVtypeVoucher;
		}




		public String getSaleVserieVoucher() {
			return saleVserieVoucher;
		}




		public void setSaleVserieVoucher(String saleVserieVoucher) {
			this.saleVserieVoucher = saleVserieVoucher;
		}




		public String getSaleVnumberVoucher() {
			return saleVnumberVoucher;
		}




		public void setSaleVnumberVoucher(String saleVnumberVoucher) {
			this.saleVnumberVoucher = saleVnumberVoucher;
		}




		public String getSaleVtypeDocClie() {
			return saleVtypeDocClie;
		}




		public void setSaleVtypeDocClie(String saleVtypeDocClie) {
			this.saleVtypeDocClie = saleVtypeDocClie;
		}




		public String getSaleBnumberDocClie() {
			return saleBnumberDocClie;
		}




		public void setSaleBnumberDocClie(String saleBnumberDocClie) {
			this.saleBnumberDocClie = saleBnumberDocClie;
		}




		public String getSaleVbusinameClient() {
			return saleVbusinameClient;
		}




		public void setSaleVbusinameClient(String saleVbusinameClient) {
			this.saleVbusinameClient = saleVbusinameClient;
		}




		public String getSaleVaddressClient() {
			return saleVaddressClient;
		}




		public void setSaleVaddressClient(String saleVaddressClient) {
			this.saleVaddressClient = saleVaddressClient;
		}




		public String getSaleVtypeDocSeller() {
			return saleVtypeDocSeller;
		}




		public void setSaleVtypeDocSeller(String saleVtypeDocSeller) {
			this.saleVtypeDocSeller = saleVtypeDocSeller;
		}




		public String getSaleBnumberDocSeller() {
			return saleBnumberDocSeller;
		}




		public void setSaleBnumberDocSeller(String saleBnumberDocSeller) {
			this.saleBnumberDocSeller = saleBnumberDocSeller;
		}




		public String getSaleVbusinameSeller() {
			return saleVbusinameSeller;
		}




		public void setSaleVbusinameSeller(String saleVbusinameSeller) {
			this.saleVbusinameSeller = saleVbusinameSeller;
		}




		public String getSaleVaffair() {
			return saleVaffair;
		}




		public void setSaleVaffair(String saleVaffair) {
			this.saleVaffair = saleVaffair;
		}




		public String getSaleCstatePurchaseorder() {
			return saleCstatePurchaseorder;
		}




		public void setSaleCstatePurchaseorder(String saleCstatePurchaseorder) {
			this.saleCstatePurchaseorder = saleCstatePurchaseorder;
		}




		public Date getSaleTregistrationDate() {
			return saleTregistrationDate;
		}




		public void setSaleTregistrationDate(Date saleTregistrationDate) {
			this.saleTregistrationDate = saleTregistrationDate;
		}




		public Date getSaleTdateUpdate() {
			return saleTdateUpdate;
		}




		public void setSaleTdateUpdate(Date saleTdateUpdate) {
			this.saleTdateUpdate = saleTdateUpdate;
		}




		public String getSaleBuserCreate() {
			return saleBuserCreate;
		}




		public void setSaleBuserCreate(String saleBuserCreate) {
			this.saleBuserCreate = saleBuserCreate;
		}




		public String getSaleBuserModify() {
			return saleBuserModify;
		}




		public void setSaleBuserModify(String saleBuserModify) {
			this.saleBuserModify = saleBuserModify;
		}




		public String getSaleBdocAdvance() {
			return saleBdocAdvance;
		}




		public void setSaleBdocAdvance(String saleBdocAdvance) {
			this.saleBdocAdvance = saleBdocAdvance;
		}




		public String getSaleVtypeIndicatorAfecto() {
			return saleVtypeIndicatorAfecto;
		}




		public void setSaleVtypeIndicatorAfecto(String saleVtypeIndicatorAfecto) {
			this.saleVtypeIndicatorAfecto = saleVtypeIndicatorAfecto;
		}




		public String getSaleVsaleTitleFree() {
			return saleVsaleTitleFree;
		}




		public void setSaleVsaleTitleFree(String saleVsaleTitleFree) {
			this.saleVsaleTitleFree = saleVsaleTitleFree;
		}




		public String getSaleVindicatorAfecto() {
			return saleVindicatorAfecto;
		}




		public void setSaleVindicatorAfecto(String saleVindicatorAfecto) {
			this.saleVindicatorAfecto = saleVindicatorAfecto;
		}




		public Long getTypeBident() {
			return typeBident;
		}




		public void setTypeBident(Long typeBident) {
			this.typeBident = typeBident;
		}




		public Long getEmplBident() {
			return emplBident;
		}




		public void setEmplBident(Long emplBident) {
			this.emplBident = emplBident;
		}




		public Long getClieBident() {
			return clieBident;
		}




		public void setClieBident(Long clieBident) {
			this.clieBident = clieBident;
		}




		public BigDecimal getSaleDunaffected() {
			return saleDunaffected;
		}




		public void setSaleDunaffected(BigDecimal saleDunaffected) {
			this.saleDunaffected = saleDunaffected;
		}




		public BigDecimal getSaleDexonerated() {
			return saleDexonerated;
		}




		public void setSaleDexonerated(BigDecimal saleDexonerated) {
			this.saleDexonerated = saleDexonerated;
		}




		public BigDecimal getSaleDtaxedBim() {
			return saleDtaxedBim;
		}




		public void setSaleDtaxedBim(BigDecimal saleDtaxedBim) {
			this.saleDtaxedBim = saleDtaxedBim;
		}




		public BigDecimal getSaleDexport() {
			return saleDexport;
		}




		public void setSaleDexport(BigDecimal saleDexport) {
			this.saleDexport = saleDexport;
		}




		public BigDecimal getSaleDfreeAmount() {
			return saleDfreeAmount;
		}




		public void setSaleDfreeAmount(BigDecimal saleDfreeAmount) {
			this.saleDfreeAmount = saleDfreeAmount;
		}




		public BigDecimal getSaleDnet() {
			return saleDnet;
		}




		public void setSaleDnet(BigDecimal saleDnet) {
			this.saleDnet = saleDnet;
		}




		public BigDecimal getSaleDigv() {
			return saleDigv;
		}




		public void setSaleDigv(BigDecimal saleDigv) {
			this.saleDigv = saleDigv;
		}




		public BigDecimal getSaleDdiscount() {
			return saleDdiscount;
		}




		public void setSaleDdiscount(BigDecimal saleDdiscount) {
			this.saleDdiscount = saleDdiscount;
		}




		public BigDecimal getSaleDtotal() {
			return saleDtotal;
		}




		public void setSaleDtotal(BigDecimal saleDtotal) {
			this.saleDtotal = saleDtotal;
		}




		public BigDecimal getSaleDconversion() {
			return saleDconversion;
		}




		public void setSaleDconversion(BigDecimal saleDconversion) {
			this.saleDconversion = saleDconversion;
		}




		public String getSaleVtotalAmountLetters() {
			return SaleVtotalAmountLetters;
		}




		public void setSaleVtotalAmountLetters(String saleVtotalAmountLetters) {
			SaleVtotalAmountLetters = saleVtotalAmountLetters;
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




public String getSaleUrlPdf() {
			return saleUrlPdf;
		}




		public void setSaleUrlPdf(String saleUrlPdf) {
			this.saleUrlPdf = saleUrlPdf;
		}
		
		
		
		public String getSaleBcodMotivoNotaCredito() {
			return saleBcodMotivoNotaCredito;
		}




		public void setSaleBcodMotivoNotaCredito(String saleBcodMotivoNotaCredito) {
			this.saleBcodMotivoNotaCredito = saleBcodMotivoNotaCredito;
		}




		public String getSaleBcodMotivoNotaDebito() {
			return saleBcodMotivoNotaDebito;
		}




		public void setSaleBcodMotivoNotaDebito(String saleBcodMotivoNotaDebito) {
			this.saleBcodMotivoNotaDebito = saleBcodMotivoNotaDebito;
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




		public Date getSaleTdocRefereceDate() {
			return saleTdocRefereceDate;
		}




		public void setSaleTdocRefereceDate(Date saleTdocRefereceDate) {
			this.saleTdocRefereceDate = saleTdocRefereceDate;
		}


		

		public String getSaleVexercise() {
			return saleVexercise;
		}




		public void setSaleVexercise(String saleVexercise) {
			this.saleVexercise = saleVexercise;
		}




		public Long getRepoBident() {
			return repoBident;
		}




		public void setRepoBident(Long repoBident) {
			this.repoBident = repoBident;
		}




@Override
  public String toString() {
    return reflectionToString(this, SHORT_PREFIX_STYLE);
  }
}