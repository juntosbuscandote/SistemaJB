package pe.am.spring.entity;

import java.math.*;
import java.util.*;


/**
 * <strong>t_sale_detail</strong><br>
 * Tabla de detalle de ventas
 */
//@JsonInclude(NON_NULL)
public class VistaPreviaDet {

	  /**s
	   * <strong>sdet_bident bigint NOT NULL</strong><br>
	   * Clave primaria de la tabla detalle de venta
	   */
//	  @NotNull(groups = { OperacionPut.class })
//	  @Null(groups = { OperacionPost.class })
//	  @Min(1)
//	  @ApiModelProperty(value = "Clave primaria de la tabla detalle de venta")
	  Long sdetBident;

	  /**
	   * <strong>sdet_dsubtotal numeric</strong><br>
	   * Subtotal de moto de venta
	   */
//	  @ApiModelProperty(value = "Subtotal de moto de venta")
	  BigDecimal sdetDsubtotal;

	  /**
	   * <strong>sdet_dconversion numeric</strong><br>
	   * Conversion de moneda
	   */
//	  @ApiModelProperty(value = "Conversion de moneda")
	  BigDecimal sdetDconversion;

	  /**
	   * <strong>sdet_bnumber bigint</strong><br>
	   * Numero de venta
	   */
//	  @ApiModelProperty(value = "Numero de venta")
	  Long sdetBnumber;

	  /**
	   * <strong>sdet_vcode character varying</strong><br>
	   * Codigo de venta
	   */
//	  @Size(max = 200)
//	  @ApiModelProperty(value = "Codigo de venta")
	  String sdetVcode;

	  /**
	   * <strong>sdet_vcommercial_code character varying</strong><br>
	   * Codigo comercial
	   */
//	  @Size(max = 200)
//	  @ApiModelProperty(value = "Codigo comercial")
	  String sdetVcommercialCode;

	  /**
	   * <strong>sdet_vconcept character varying</strong><br>
	   * Concepto de venta
	   */
//	  @Size(max = 200)
//	  @ApiModelProperty(value = "Concepto de venta")
	  String sdetVconcept;

	  /**
	   * <strong>sdet_vmeassure_unity character varying</strong><br>
	   * Undidad de medida de productos y servicio
	   */
//	  @Size(max = 200)
//	  @ApiModelProperty(value = "Undidad de medida de productos y servicio")
	  String sdetVmeassureUnity;

	  /**
	   * <strong>sdet_dquantity numeric</strong><br>
	   * Cantida de productos y servicios
	   */
//	  @ApiModelProperty(value = "Cantida de productos y servicios")
	  BigDecimal sdetDquantity;

	  /**
	   * <strong>sdet_dunit_value numeric</strong><br>
	   * Valor unitario de producto y servicio
	   */
//	  @ApiModelProperty(value = "Valor unitario de producto y servicio")
	  BigDecimal sdetDunitValue;

	  /**
	   * <strong>sdet_digv_unit numeric</strong><br>
	   * Igv del precio unitario de producto y servicio
	   */
//	  @ApiModelProperty(value = "Igv del precio unitario de producto y servicio")
	  BigDecimal sdetDigvUnit;

	  /**
	   * <strong>sdet_dprice_unit numeric</strong><br>
	   * Precio unitario de producto y servicio
	   */
//	  @ApiModelProperty(value = "Precio unitario de producto y servicio")
	  BigDecimal sdetDpriceUnit;

	  /**
	   * <strong>sdet_dvalue_sale numeric</strong><br>
	   * Valor de venta de producto y servicio
	   */
//	  @ApiModelProperty(value = "Valor de venta de producto y servicio")
	  BigDecimal sdetDvalueSale;

	  /**
	   * <strong>sdet_ddesc_porcentage numeric</strong><br>
	   * Descuento por porcentaje
	   */
//	  @ApiModelProperty(value = "Descuento por porcentaje")
	  BigDecimal sdetDdescPorcentage;

	  /**
	   * <strong>sdet_ddesc_import numeric</strong><br>
	   * Importe descuento
	   */
//	  @ApiModelProperty(value = "Importe descuento")
	  BigDecimal sdetDdescImport;

	  /**
	   * <strong>sdet_dtax_base numeric</strong><br>
	   * Base imponible
	   */
//	  @ApiModelProperty(value = "Base imponible")
	  BigDecimal sdetDtaxBase;

	  /**
	   * <strong>sdet_binclude_igv boolean</strong><br>
	   * Incluir igv
	   */
//	  @ApiModelProperty(value = "Incluir igv")
	  Boolean sdetBincludeIgv;

	  /**
	   * <strong>sdet_digv numeric</strong><br>
	   * Igv del monto total
	   */
//	  @ApiModelProperty(value = "Igv del monto total")
	  BigDecimal sdetDigv;

	  /**
	   * <strong>sdet_dgross_total numeric</strong><br>
	   * Total bruto
	   */
//	  @ApiModelProperty(value = "Total bruto")
	  BigDecimal sdetDgrossTotal;

	  /**
	   * <strong>sdet_dnet_total numeric</strong><br>
	   * Total neto
	   */
//	  @ApiModelProperty(value = "Total neto")
	  BigDecimal sdetDnetTotal;

	  /**
	   * <strong>sdet_vaffection_indicator character varying</strong><br>
	   * Indicador afecto
	   */
//	  @Size(max = 50)
//	  @ApiModelProperty(value = "Indicador afecto")
	  String sdetVaffectionIndicator;

	  /**
	   * <strong>sdet_vtype_affection_indicator character varying</strong><br>
	   * Tipo de indicador  afecto
	   */
//	  @Size(max = 100)
//	  @ApiModelProperty(value = "Tipo de indicador  afecto")
	  String sdetVtypeAffectionIndicator;

	  /**
	   * <strong>sdet_vdescrip_typ_affec_ind character varying</strong><br>
	   * Descripcion de tipo de indicador afecto
	   */
//	  @Size(max = 100)
//	  @ApiModelProperty(value = "Descripcion de tipo de indicador afecto")
	  String sdetVdescripTypAffecInd;
	  
	  /**
	   * <strong>sdet_vobservation character varying</strong><br>
	   * Observacion de la venta
	   */
//	  @Size(max = 200)
//	  @ApiModelProperty(value = "Observacion de la venta")
	  String sdetVobservation;

	  /**
	   * <strong>sdet_vfree_transfer character varying</strong><br>
	   * Transferencia libre
	   */
//	  @Size(max = 50)
//	  @ApiModelProperty(value = "Transferencia libre")
	  String sdetVfreeTransfer;

	  /**
	   * <strong>sdet_disc numeric</strong><br>
	   * Impuesto selectivo al consumo
	   */
//	  @ApiModelProperty(value = "Impuesto selectivo al consumo")
	  BigDecimal sdetDisc;

	  /**
	   * <strong>sdet_tregistration_date timestamp without time zone</strong><br>
	   * Fecha de regustro de  venta
	   */
//	  @ApiModelProperty(value = "Fecha de regustro de  venta")
	  Date sdetTregistrationDate;

	  /**
	   * <strong>sdet_tdate_update timestamp without time zone</strong><br>
	   * Fecha de actualizacion de detalle de ventas
	   */
//	  @ApiModelProperty(value = "Fecha de actualizacion de detalle de ventas")
	  Date sdetTdateUpdate;

	  /**
	   * <strong>sdet_buser_create bigint</strong><br>
	   * Codigo de usuario que crea detalle de venta
	   */
//	  @ApiModelProperty(value = "Codigo de usuario que crea detalle de venta")
	  Long sdetBuserCreate;

	  /**
	   * <strong>sdet_buser_modify bigint</strong><br>
	   * Codigo de usuario que modifica el detalle de ventas
	   */
//	  @ApiModelProperty(value = "Codigo de usuario que modifica el detalle de ventas")
	  Long sdetBuserModify;

	  /**
	   * <strong>sdet_dporcentage_perception numeric</strong><br>
	   * Porcentaje de percepcion
	   */
//	  @ApiModelProperty(value = "Porcentaje de percepcion")
	  BigDecimal sdetDporcentagePerception;

	  /**
	   * <strong>sdet_dimporte_perception numeric</strong><br>
	   * Importe de percepion
	   */
//	  @ApiModelProperty(value = "Importe de percepion")
	  BigDecimal sdetDimportePerception;

	  /**
	   * <strong>sdet_vexonerate numeric</strong><br>
	   * Valor exonerado
	   */
//	  @ApiModelProperty(value = "Valor exonerado")
	  BigDecimal sdetVexonerate;

	  /**
	   * <strong>sdet_dvalue_exportation numeric</strong>
	   */
	  BigDecimal sdetDvalueExportation;

	  /**
	   * <strong>sdet_dvalue_title_free numeric</strong><br>
	   * Valor a titulo gratuito
	   */
//	  @ApiModelProperty(value = "Valor a titulo gratuito")
	  BigDecimal sdetDvalueTitleFree;

	  /**
	   * <strong>sdet_vshortname_prod character varying</strong><br>
	   * Nombre corto de producto
	   */
//	  @Size(max = 10)
//	  @ApiModelProperty(value = "Nombre corto de producto")
	  String sdetVshortnameProd;

	  /**
	   * <strong>sdet_vdescription_prod character varying</strong><br>
	   * Descripcion de producto
	   */
//	  @Size(max = 200)
//	  @ApiModelProperty(value = "Descripcion de producto")
	  String sdetVdescriptionProd;

	  /**
	   * <strong>sdet_vshortname_serv character varying</strong><br>
	   * Nombre corto de servicio
	   */
//	  @Size(max = 10)
//	  @ApiModelProperty(value = "Nombre corto de servicio")
	  String sdetVshortnameServ;

	  /**
	   * <strong>sdet_vdescription_serv character varying</strong><br>
	   * Descripcion de servicio
	   */
//	  @Size(max = 200)
//	  @ApiModelProperty(value = "Descripcion de servicio")
	  String sdetVdescriptionServ;

	  /**
	   * <strong>sdet_vdescription_price character varying</strong><br>
	   * Descripcion de precio
	   */
//	  @Size(max = 100)
//	  @ApiModelProperty(value = "Descripcion de precio")
	  String sdetVdescriptionPrice;

	  /**
	   * <strong>sdet_vdescription_coin_price character varying</strong><br>
	   * Descripcion de moneda para precio
	   */
//	  @Size(max = 30)
//	  @ApiModelProperty(value = "Descripcion de moneda para precio")
	  String sdetVdescriptionCoinPrice;

	  /**
	   * <strong>sdet_dsale_value_price numeric</strong><br>
	   * Valor de venta de precio
	   */
//	  @ApiModelProperty(value = "Valor de venta de precio")
	  BigDecimal sdetDsaleValuePrice;

	  /**
	   * <strong>sdet_bigv_includes_price boolean</strong><br>
	   * Incluir igv en precio
	   */
//	  @ApiModelProperty(value = "Incluir igv en precio")
	  Boolean sdetBigvIncludesPrice;

	  /**
	   * <strong>sdet_bexonerated_price boolean</strong><br>
	   * Exonerado de pagar impuesto
	   */
//	  @ApiModelProperty(value = "Exonerado de pagar impuesto")
	  Boolean sdetBexoneratedPrice;

	  /**
	   * <strong>sdet_ddiscount_amount_price numeric</strong><br>
	   * Descuento por importe en precio
	   */
//	  @ApiModelProperty(value = "Descuento por importe en precio")
	  BigDecimal sdetDdiscountAmountPrice;

	  /**
	   * <strong>sdet_dporcentage_discount_price numeric</strong><br>
	   * Descuento por porcentaje en precio
	   */
//	  @ApiModelProperty(value = "Descuento por porcentaje en precio")
	  BigDecimal sdetDporcentageDiscountPrice;

	  /**
	   * <strong>sdet_dsale_price numeric</strong><br>
	   * Precio de venta
	   */
//	  @ApiModelProperty(value = "Precio de venta")
	  BigDecimal sdetDsalePrice;

	  /**
	   * <strong>sdet_bmain_price boolean</strong><br>
	   * Precio principal
	   */
//	  @ApiModelProperty(value = "Precio principal")
	  Boolean sdetBmainPrice;

	  /**
	   * <strong>sdet_vname_brand character varying</strong><br>
	   * Nombre de producto
	   */
//	  @Size(max = 200)
//	  @ApiModelProperty(value = "Nombre de producto")
	  String sdetVnameBrand;

	  /**
	   * <strong>sdet_vshortname_brand character varying</strong><br>
	   * Nombre corto de marca
	   */
//	  @Size(max = 10)
//	  @ApiModelProperty(value = "Nombre corto de marca")
	  String sdetVshortnameBrand;

	  /**
	   * <strong>sdet_vdescription_brand character varying</strong><br>
	   * Descripcion de marca
	   */
//	  @Size(max = 200)
//	  @ApiModelProperty(value = "Descripcion de marca")
	  String sdetVdescriptionBrand;

	  /**
	   * <strong>sale_bident bigint</strong><br>
	   * Clave foranea de tabla ventas cabecera
	   */
//	  @ApiModelProperty(value = "Clave foranea de tabla ventas cabecera")
	  Long saleBident;

	  /**
	   * <strong>prod_bident bigint</strong><br>
	   * Clave foranea de tabla producto
	   */
//	  @Min(1)
//	  @ApiModelProperty(value = "Clave foranea de tabla producto")
	  Long prodBident;

	  /**
	   * <strong>serv_bident bigint</strong><br>
	   * Clave foranea de tabla servicio
	   */
//	  @Min(1)
//	  @ApiModelProperty(value = "Clave foranea de tabla servicio")
	  Long servBident;

	  /**
	   * <strong>sdet_ndiscount_value_pric numeric</strong><br>
	   * Almacena el valor de venta con descuento
	   */
//	  @ApiModelProperty(value = "Almacena el valor de venta con descuento")
	  BigDecimal sdetNdiscountValuePric;
	  
	  /**
	   * <strong>sdet_nigvdescu_pric numeric</strong><br>
	   * Almacena el valor del IGV con descuento
	   */
//	  @ApiModelProperty(value = "Almacena el valor del IGV con descuento")
	  BigDecimal sdetNigvdescuPric;
	  
	  /**
	   * <strong>sdet_nigvdescu_pric numeric</strong><br>
	   * Almacena el valor del IGV con descuento
	   */
//	  @ApiModelProperty(value = "Almacena el precio de venta con descuento")
	  BigDecimal sdetNdiscountPrice;
	  
	  /**
	   * <strong>type_vtype_coin_origin character varying</strong><br>
	   * Tipo de moneda origen
	   */
//	  @Size(max = 100)
//	  @ApiModelProperty(value = "Tipo de moneda origen")
	  String sdetVtypeCoinOrigin;

	  /**
	   * <strong>type_vtype_coin_currency character varying</strong><br>
	   * Tipo de moneda destino
	   */
//	  @Size(max = 100)
//	  @ApiModelProperty(value = "Tipo de moneda destino")
	  String sdetVtypeCoinCurrency;
	  
	  /**
	   * <strong>type_damount_exchange_sales numeric</strong><br>
	   * Monto de cambio de moneda venta
	   */
//	  @ApiModelProperty(value = "Monto de cambio de moneda venta")
	  BigDecimal sdetDamountExchangeSales;
	  
	  /**
	   * <strong>sdet_dcurrency_conversion numeric</strong><br>
	   * Conversion de moneda
	   */
//	  @ApiModelProperty(value = "Conversion de moneda")
	  BigDecimal sdetDcurrencyConversion;
	  
	  /**
	   * <strong>sdet_dtotal_discount numeric</strong><br>
	   * total descuento de venta
	   */
//	  @ApiModelProperty(value = "total descuento de venta")
	  BigDecimal sdetDtotalDiscount;
	  
	  Long storeBident;
	  String sdetCflagNote;
	  BigDecimal sdetDcantNote;
	  String sdetVclassSunat;
	  

	/**
	   * <strong>sdet_bident bigint NOT NULL</strong><br>
	   * Clave primaria de la tabla detalle de venta
	   */
	  public void setSdetBident(Long sdetBident) {
	    this.sdetBident = sdetBident;
	  }

	  /**
	   * <strong>sdet_bident bigint NOT NULL</strong><br>
	   * Clave primaria de la tabla detalle de venta
	   */
	  public Long getSdetBident() {
	    return sdetBident;
	  }

	  /**
	   * <strong>sdet_dsubtotal numeric</strong><br>
	   * Subtotal de moto de venta
	   */
	  public void setSdetDsubtotal(BigDecimal sdetDsubtotal) {
	    this.sdetDsubtotal = sdetDsubtotal;
	  }

	  /**
	   * <strong>sdet_dsubtotal numeric</strong><br>
	   * Subtotal de moto de venta
	   */
	  public BigDecimal getSdetDsubtotal() {
	    return sdetDsubtotal;
	  }

	  /**
	   * <strong>sdet_dconversion numeric</strong><br>
	   * Conversion de moneda
	   */
	  public void setSdetDconversion(BigDecimal sdetDconversion) {
	    this.sdetDconversion = sdetDconversion;
	  }

	  /**
	   * <strong>sdet_dconversion numeric</strong><br>
	   * Conversion de moneda
	   */
	  public BigDecimal getSdetDconversion() {
	    return sdetDconversion;
	  }

	  /**
	   * <strong>sdet_bnumber bigint</strong><br>
	   * Numero de venta
	   */
	  public void setSdetBnumber(Long sdetBnumber) {
	    this.sdetBnumber = sdetBnumber;
	  }

	  /**
	   * <strong>sdet_bnumber bigint</strong><br>
	   * Numero de venta
	   */
	  public Long getSdetBnumber() {
	    return sdetBnumber;
	  }

	  /**
	   * <strong>sdet_vcode character varying</strong><br>
	   * Codigo de venta
	   */
	  public void setSdetVcode(String sdetVcode) {
	    this.sdetVcode = sdetVcode;
	  }

	  /**
	   * <strong>sdet_vcode character varying</strong><br>
	   * Codigo de venta
	   */
	  public String getSdetVcode() {
	    return sdetVcode;
	  }

	  /**
	   * <strong>sdet_vcommercial_code character varying</strong><br>
	   * Codigo comercial
	   */
	  public void setSdetVcommercialCode(String sdetVcommercialCode) {
	    this.sdetVcommercialCode = sdetVcommercialCode;
	  }

	  /**
	   * <strong>sdet_vcommercial_code character varying</strong><br>
	   * Codigo comercial
	   */
	  public String getSdetVcommercialCode() {
	    return sdetVcommercialCode;
	  }

	  /**
	   * <strong>sdet_vconcept character varying</strong><br>
	   * Concepto de venta
	   */
	  public void setSdetVconcept(String sdetVconcept) {
	    this.sdetVconcept = sdetVconcept;
	  }

	  /**
	   * <strong>sdet_vconcept character varying</strong><br>
	   * Concepto de venta
	   */
	  public String getSdetVconcept() {
	    return sdetVconcept;
	  }

	  /**
	   * <strong>sdet_vmeassure_unity character varying</strong><br>
	   * Undidad de medida de productos y servicio
	   */
	  public void setSdetVmeassureUnity(String sdetVmeassureUnity) {
	    this.sdetVmeassureUnity = sdetVmeassureUnity;
	  }

	  /**
	   * <strong>sdet_vmeassure_unity character varying</strong><br>
	   * Undidad de medida de productos y servicio
	   */
	  public String getSdetVmeassureUnity() {
	    return sdetVmeassureUnity;
	  }

	  /**
	   * <strong>sdet_dquantity numeric</strong><br>
	   * Cantida de productos y servicios
	   */
	  public void setSdetDquantity(BigDecimal sdetDquantity) {
	    this.sdetDquantity = sdetDquantity;
	  }

	  /**
	   * <strong>sdet_dquantity numeric</strong><br>
	   * Cantida de productos y servicios
	   */
	  public BigDecimal getSdetDquantity() {
	    return sdetDquantity;
	  }

	  /**
	   * <strong>sdet_dunit_value numeric</strong><br>
	   * Valor unitario de producto y servicio
	   */
	  public void setSdetDunitValue(BigDecimal sdetDunitValue) {
	    this.sdetDunitValue = sdetDunitValue;
	  }

	  /**
	   * <strong>sdet_dunit_value numeric</strong><br>
	   * Valor unitario de producto y servicio
	   */
	  public BigDecimal getSdetDunitValue() {
	    return sdetDunitValue;
	  }

	  /**
	   * <strong>sdet_digv_unit numeric</strong><br>
	   * Igv del precio unitario de producto y servicio
	   */
	  public void setSdetDigvUnit(BigDecimal sdetDigvUnit) {
	    this.sdetDigvUnit = sdetDigvUnit;
	  }

	  /**
	   * <strong>sdet_digv_unit numeric</strong><br>
	   * Igv del precio unitario de producto y servicio
	   */
	  public BigDecimal getSdetDigvUnit() {
	    return sdetDigvUnit;
	  }

	  /**
	   * <strong>sdet_dprice_unit numeric</strong><br>
	   * Precio unitario de producto y servicio
	   */
	  public void setSdetDpriceUnit(BigDecimal sdetDpriceUnit) {
	    this.sdetDpriceUnit = sdetDpriceUnit;
	  }

	  /**
	   * <strong>sdet_dprice_unit numeric</strong><br>
	   * Precio unitario de producto y servicio
	   */
	  public BigDecimal getSdetDpriceUnit() {
	    return sdetDpriceUnit;
	  }

	  /**
	   * <strong>sdet_dvalue_sale numeric</strong><br>
	   * Valor de venta de producto y servicio
	   */
	  public void setSdetDvalueSale(BigDecimal sdetDvalueSale) {
	    this.sdetDvalueSale = sdetDvalueSale;
	  }

	  /**
	   * <strong>sdet_dvalue_sale numeric</strong><br>
	   * Valor de venta de producto y servicio
	   */
	  public BigDecimal getSdetDvalueSale() {
	    return sdetDvalueSale;
	  }

	  /**
	   * <strong>sdet_ddesc_porcentage numeric</strong><br>
	   * Descuento por porcentaje
	   */
	  public void setSdetDdescPorcentage(BigDecimal sdetDdescPorcentage) {
	    this.sdetDdescPorcentage = sdetDdescPorcentage;
	  }

	  /**
	   * <strong>sdet_ddesc_porcentage numeric</strong><br>
	   * Descuento por porcentaje
	   */
	  public BigDecimal getSdetDdescPorcentage() {
	    return sdetDdescPorcentage;
	  }

	  /**
	   * <strong>sdet_ddesc_import numeric</strong><br>
	   * Importe descuento
	   */
	  public void setSdetDdescImport(BigDecimal sdetDdescImport) {
	    this.sdetDdescImport = sdetDdescImport;
	  }

	  /**
	   * <strong>sdet_ddesc_import numeric</strong><br>
	   * Importe descuento
	   */
	  public BigDecimal getSdetDdescImport() {
	    return sdetDdescImport;
	  }

	  /**
	   * <strong>sdet_dtax_base numeric</strong><br>
	   * Base imponible
	   */
	  public void setSdetDtaxBase(BigDecimal sdetDtaxBase) {
	    this.sdetDtaxBase = sdetDtaxBase;
	  }

	  /**
	   * <strong>sdet_dtax_base numeric</strong><br>
	   * Base imponible
	   */
	  public BigDecimal getSdetDtaxBase() {
	    return sdetDtaxBase;
	  }

	  /**
	   * <strong>sdet_binclude_igv boolean</strong><br>
	   * Incluir igv
	   */
	  public void setSdetBincludeIgv(Boolean sdetBincludeIgv) {
	    this.sdetBincludeIgv = sdetBincludeIgv;
	  }

	  /**
	   * <strong>sdet_binclude_igv boolean</strong><br>
	   * Incluir igv
	   */
	  public Boolean getSdetBincludeIgv() {
	    return sdetBincludeIgv;
	  }

	  /**
	   * <strong>sdet_digv numeric</strong><br>
	   * Igv del monto total
	   */
	  public void setSdetDigv(BigDecimal sdetDigv) {
	    this.sdetDigv = sdetDigv;
	  }

	  /**
	   * <strong>sdet_digv numeric</strong><br>
	   * Igv del monto total
	   */
	  public BigDecimal getSdetDigv() {
	    return sdetDigv;
	  }

	  /**
	   * <strong>sdet_dgross_total numeric</strong><br>
	   * Total bruto
	   */
	  public void setSdetDgrossTotal(BigDecimal sdetDgrossTotal) {
	    this.sdetDgrossTotal = sdetDgrossTotal;
	  }

	  /**
	   * <strong>sdet_dgross_total numeric</strong><br>
	   * Total bruto
	   */
	  public BigDecimal getSdetDgrossTotal() {
	    return sdetDgrossTotal;
	  }

	  /**
	   * <strong>sdet_dnet_total numeric</strong><br>
	   * Total neto
	   */
	  public void setSdetDnetTotal(BigDecimal sdetDnetTotal) {
	    this.sdetDnetTotal = sdetDnetTotal;
	  }

	  /**
	   * <strong>sdet_dnet_total numeric</strong><br>
	   * Total neto
	   */
	  public BigDecimal getSdetDnetTotal() {
	    return sdetDnetTotal;
	  }

	  /**
	   * <strong>sdet_vaffection_indicator character varying</strong><br>
	   * Indicador afecto
	   */
	  public void setSdetVaffectionIndicator(String sdetVaffectionIndicator) {
	    this.sdetVaffectionIndicator = sdetVaffectionIndicator;
	  }

	  /**
	   * <strong>sdet_vaffection_indicator character varying</strong><br>
	   * Indicador afecto
	   */
	  public String getSdetVaffectionIndicator() {
	    return sdetVaffectionIndicator;
	  }

	  /**
	   * <strong>sdet_vtype_affection_indicator character varying</strong><br>
	   * Tipo de indicador  afecto
	   */
	  public void setSdetVtypeAffectionIndicator(String sdetVtypeAffectionIndicator) {
	    this.sdetVtypeAffectionIndicator = sdetVtypeAffectionIndicator;
	  }

	  /**
	   * <strong>sdet_vtype_affection_indicator character varying</strong><br>
	   * Tipo de indicador  afecto
	   */
	  public String getSdetVtypeAffectionIndicator() {
	    return sdetVtypeAffectionIndicator;
	  }  
	  
	  /**
	   * <strong>sdet_getVdescrip_typ_affec_ind character varying</strong><br>
	   * descripcion de tipo de indicador  afecto
	   */
		public void setSdetVdescripTypAffecInd(String sdetVdescripTypAffecInd) {
			this.sdetVdescripTypAffecInd = sdetVdescripTypAffecInd;
		}

	  /**
	   * <strong>sdet_getVdescrip_typ_affec_ind character varying</strong><br>
	   * descripcion de tipo de indicador  afecto
	   */
	  public String getSdetVdescripTypAffecInd() {
		return sdetVdescripTypAffecInd;
	  }

	/**
	   * <strong>sdet_vobservation character varying</strong><br>
	   * Observacion de la venta
	   */
	  public void setSdetVobservation(String sdetVobservation) {
	    this.sdetVobservation = sdetVobservation;
	  }

	  /**
	   * <strong>sdet_vobservation character varying</strong><br>
	   * Observacion de la venta
	   */
	  public String getSdetVobservation() {
	    return sdetVobservation;
	  }

	  /**
	   * <strong>sdet_vfree_transfer character varying</strong><br>
	   * Transferencia libre
	   */
	  public void setSdetVfreeTransfer(String sdetVfreeTransfer) {
	    this.sdetVfreeTransfer = sdetVfreeTransfer;
	  }

	  /**
	   * <strong>sdet_vfree_transfer character varying</strong><br>
	   * Transferencia libre
	   */
	  public String getSdetVfreeTransfer() {
	    return sdetVfreeTransfer;
	  }

	  /**
	   * <strong>sdet_disc numeric</strong><br>
	   * Impuesto selectivo al consumo
	   */
	  public void setSdetDisc(BigDecimal sdetDisc) {
	    this.sdetDisc = sdetDisc;
	  }

	  /**
	   * <strong>sdet_disc numeric</strong><br>
	   * Impuesto selectivo al consumo
	   */
	  public BigDecimal getSdetDisc() {
	    return sdetDisc;
	  }

	  /**
	   * <strong>sdet_tregistration_date timestamp without time zone</strong><br>
	   * Fecha de regustro de  venta
	   */
	  public void setSdetTregistrationDate(Date sdetTregistrationDate) {
	    this.sdetTregistrationDate = sdetTregistrationDate;
	  }

	  /**
	   * <strong>sdet_tregistration_date timestamp without time zone</strong><br>
	   * Fecha de regustro de  venta
	   */
	  public Date getSdetTregistrationDate() {
	    return sdetTregistrationDate;
	  }

	  /**
	   * <strong>sdet_tdate_update timestamp without time zone</strong><br>
	   * Fecha de actualizacion de detalle de ventas
	   */
	  public void setSdetTdateUpdate(Date sdetTdateUpdate) {
	    this.sdetTdateUpdate = sdetTdateUpdate;
	  }

	  /**
	   * <strong>sdet_tdate_update timestamp without time zone</strong><br>
	   * Fecha de actualizacion de detalle de ventas
	   */
	  public Date getSdetTdateUpdate() {
	    return sdetTdateUpdate;
	  }

	  /**
	   * <strong>sdet_buser_create bigint</strong><br>
	   * Codigo de usuario que crea detalle de venta
	   */
	  public void setSdetBuserCreate(Long sdetBuserCreate) {
	    this.sdetBuserCreate = sdetBuserCreate;
	  }

	  /**
	   * <strong>sdet_buser_create bigint</strong><br>
	   * Codigo de usuario que crea detalle de venta
	   */
	  public Long getSdetBuserCreate() {
	    return sdetBuserCreate;
	  }

	  /**
	   * <strong>sdet_buser_modify bigint</strong><br>
	   * Codigo de usuario que modifica el detalle de ventas
	   */
	  public void setSdetBuserModify(Long sdetBuserModify) {
	    this.sdetBuserModify = sdetBuserModify;
	  }

	  /**
	   * <strong>sdet_buser_modify bigint</strong><br>
	   * Codigo de usuario que modifica el detalle de ventas
	   */
	  public Long getSdetBuserModify() {
	    return sdetBuserModify;
	  }

	  /**
	   * <strong>sdet_dporcentage_perception numeric</strong><br>
	   * Porcentaje de percepcion
	   */
	  public void setSdetDporcentagePerception(BigDecimal sdetDporcentagePerception) {
	    this.sdetDporcentagePerception = sdetDporcentagePerception;
	  }

	  /**
	   * <strong>sdet_dporcentage_perception numeric</strong><br>
	   * Porcentaje de percepcion
	   */
	  public BigDecimal getSdetDporcentagePerception() {
	    return sdetDporcentagePerception;
	  }

	  /**
	   * <strong>sdet_dimporte_perception numeric</strong><br>
	   * Importe de percepion
	   */
	  public void setSdetDimportePerception(BigDecimal sdetDimportePerception) {
	    this.sdetDimportePerception = sdetDimportePerception;
	  }

	  /**
	   * <strong>sdet_dimporte_perception numeric</strong><br>
	   * Importe de percepion
	   */
	  public BigDecimal getSdetDimportePerception() {
	    return sdetDimportePerception;
	  }

	  /**
	   * <strong>sdet_vexonerate numeric</strong><br>
	   * Valor exonerado
	   */
	  public void setSdetVexonerate(BigDecimal sdetVexonerate) {
	    this.sdetVexonerate = sdetVexonerate;
	  }

	  /**
	   * <strong>sdet_vexonerate numeric</strong><br>
	   * Valor exonerado
	   */
	  public BigDecimal getSdetVexonerate() {
	    return sdetVexonerate;
	  }

	  /**
	   * <strong>sdet_dvalue_exportation numeric</strong>
	   */
	  public void setSdetDvalueExportation(BigDecimal sdetDvalueExportation) {
	    this.sdetDvalueExportation = sdetDvalueExportation;
	  }

	  /**
	   * <strong>sdet_dvalue_exportation numeric</strong>
	   */
	  public BigDecimal getSdetDvalueExportation() {
	    return sdetDvalueExportation;
	  }

	  /**
	   * <strong>sdet_dvalue_title_free numeric</strong><br>
	   * Valor a titulo gratuito
	   */
	  public void setSdetDvalueTitleFree(BigDecimal sdetDvalueTitleFree) {
	    this.sdetDvalueTitleFree = sdetDvalueTitleFree;
	  }

	  /**
	   * <strong>sdet_dvalue_title_free numeric</strong><br>
	   * Valor a titulo gratuito
	   */
	  public BigDecimal getSdetDvalueTitleFree() {
	    return sdetDvalueTitleFree;
	  }

	  /**
	   * <strong>sdet_vshortname_prod character varying</strong><br>
	   * Nombre corto de producto
	   */
	  public void setSdetVshortnameProd(String sdetVshortnameProd) {
	    this.sdetVshortnameProd = sdetVshortnameProd;
	  }

	  /**
	   * <strong>sdet_vshortname_prod character varying</strong><br>
	   * Nombre corto de producto
	   */
	  public String getSdetVshortnameProd() {
	    return sdetVshortnameProd;
	  }

	  /**
	   * <strong>sdet_vdescription_prod character varying</strong><br>
	   * Descripcion de producto
	   */
	  public void setSdetVdescriptionProd(String sdetVdescriptionProd) {
	    this.sdetVdescriptionProd = sdetVdescriptionProd;
	  }

	  /**
	   * <strong>sdet_vdescription_prod character varying</strong><br>
	   * Descripcion de producto
	   */
	  public String getSdetVdescriptionProd() {
	    return sdetVdescriptionProd;
	  }

	  /**
	   * <strong>sdet_vshortname_serv character varying</strong><br>
	   * Nombre corto de servicio
	   */
	  public void setSdetVshortnameServ(String sdetVshortnameServ) {
	    this.sdetVshortnameServ = sdetVshortnameServ;
	  }

	  /**
	   * <strong>sdet_vshortname_serv character varying</strong><br>
	   * Nombre corto de servicio
	   */
	  public String getSdetVshortnameServ() {
	    return sdetVshortnameServ;
	  }

	  /**
	   * <strong>sdet_vdescription_serv character varying</strong><br>
	   * Descripcion de servicio
	   */
	  public void setSdetVdescriptionServ(String sdetVdescriptionServ) {
	    this.sdetVdescriptionServ = sdetVdescriptionServ;
	  }

	  /**
	   * <strong>sdet_vdescription_serv character varying</strong><br>
	   * Descripcion de servicio
	   */
	  public String getSdetVdescriptionServ() {
	    return sdetVdescriptionServ;
	  }

	  /**
	   * <strong>sdet_vdescription_price character varying</strong><br>
	   * Descripcion de precio
	   */
	  public void setSdetVdescriptionPrice(String sdetVdescriptionPrice) {
	    this.sdetVdescriptionPrice = sdetVdescriptionPrice;
	  }

	  /**
	   * <strong>sdet_vdescription_price character varying</strong><br>
	   * Descripcion de precio
	   */
	  public String getSdetVdescriptionPrice() {
	    return sdetVdescriptionPrice;
	  }

	  /**
	   * <strong>sdet_vdescription_coin_price character varying</strong><br>
	   * Descripcion de moneda para precio
	   */
	  public void setSdetVdescriptionCoinPrice(String sdetVdescriptionCoinPrice) {
	    this.sdetVdescriptionCoinPrice = sdetVdescriptionCoinPrice;
	  }

	  /**
	   * <strong>sdet_vdescription_coin_price character varying</strong><br>
	   * Descripcion de moneda para precio
	   */
	  public String getSdetVdescriptionCoinPrice() {
	    return sdetVdescriptionCoinPrice;
	  }

	  /**
	   * <strong>sdet_dsale_value_price numeric</strong><br>
	   * Valor de venta de precio
	   */
	  public void setSdetDsaleValuePrice(BigDecimal sdetDsaleValuePrice) {
	    this.sdetDsaleValuePrice = sdetDsaleValuePrice;
	  }

	  /**
	   * <strong>sdet_dsale_value_price numeric</strong><br>
	   * Valor de venta de precio
	   */
	  public BigDecimal getSdetDsaleValuePrice() {
	    return sdetDsaleValuePrice;
	  }

	  /**
	   * <strong>sdet_bigv_includes_price boolean</strong><br>
	   * Incluir igv en precio
	   */
	  public void setSdetBigvIncludesPrice(Boolean sdetBigvIncludesPrice) {
	    this.sdetBigvIncludesPrice = sdetBigvIncludesPrice;
	  }

	  /**
	   * <strong>sdet_bigv_includes_price boolean</strong><br>
	   * Incluir igv en precio
	   */
	  public Boolean getSdetBigvIncludesPrice() {
	    return sdetBigvIncludesPrice;
	  }

	  /**
	   * <strong>sdet_bexonerated_price boolean</strong><br>
	   * Exonerado de pagar impuesto
	   */
	  public void setSdetBexoneratedPrice(Boolean sdetBexoneratedPrice) {
	    this.sdetBexoneratedPrice = sdetBexoneratedPrice;
	  }

	  /**
	   * <strong>sdet_bexonerated_price boolean</strong><br>
	   * Exonerado de pagar impuesto
	   */
	  public Boolean getSdetBexoneratedPrice() {
	    return sdetBexoneratedPrice;
	  }

	  /**
	   * <strong>sdet_ddiscount_amount_price numeric</strong><br>
	   * Descuento por importe en precio
	   */
	  public void setSdetDdiscountAmountPrice(BigDecimal sdetDdiscountAmountPrice) {
	    this.sdetDdiscountAmountPrice = sdetDdiscountAmountPrice;
	  }

	  /**
	   * <strong>sdet_ddiscount_amount_price numeric</strong><br>
	   * Descuento por importe en precio
	   */
	  public BigDecimal getSdetDdiscountAmountPrice() {
	    return sdetDdiscountAmountPrice;
	  }

	  /**
	   * <strong>sdet_dporcentage_discount_price numeric</strong><br>
	   * Descuento por porcentaje en precio
	   */
	  public void setSdetDporcentageDiscountPrice(BigDecimal sdetDporcentageDiscountPrice) {
	    this.sdetDporcentageDiscountPrice = sdetDporcentageDiscountPrice;
	  }

	  /**
	   * <strong>sdet_dporcentage_discount_price numeric</strong><br>
	   * Descuento por porcentaje en precio
	   */
	  public BigDecimal getSdetDporcentageDiscountPrice() {
	    return sdetDporcentageDiscountPrice;
	  }

	  /**
	   * <strong>sdet_dsale_price numeric</strong><br>
	   * Precio de venta
	   */
	  public void setSdetDsalePrice(BigDecimal sdetDsalePrice) {
	    this.sdetDsalePrice = sdetDsalePrice;
	  }

	  /**
	   * <strong>sdet_dsale_price numeric</strong><br>
	   * Precio de venta
	   */
	  public BigDecimal getSdetDsalePrice() {
	    return sdetDsalePrice;
	  }

	  /**
	   * <strong>sdet_bmain_price boolean</strong><br>
	   * Precio principal
	   */
	  public void setSdetBmainPrice(Boolean sdetBmainPrice) {
	    this.sdetBmainPrice = sdetBmainPrice;
	  }

	  /**
	   * <strong>sdet_bmain_price boolean</strong><br>
	   * Precio principal
	   */
	  public Boolean getSdetBmainPrice() {
	    return sdetBmainPrice;
	  }

	  /**
	   * <strong>sdet_vname_brand character varying</strong><br>
	   * Nombre de producto
	   */
	  public void setSdetVnameBrand(String sdetVnameBrand) {
	    this.sdetVnameBrand = sdetVnameBrand;
	  }

	  /**
	   * <strong>sdet_vname_brand character varying</strong><br>
	   * Nombre de producto
	   */
	  public String getSdetVnameBrand() {
	    return sdetVnameBrand;
	  }

	  /**
	   * <strong>sdet_vshortname_brand character varying</strong><br>
	   * Nombre corto de marca
	   */
	  public void setSdetVshortnameBrand(String sdetVshortnameBrand) {
	    this.sdetVshortnameBrand = sdetVshortnameBrand;
	  }

	  /**
	   * <strong>sdet_vshortname_brand character varying</strong><br>
	   * Nombre corto de marca
	   */
	  public String getSdetVshortnameBrand() {
	    return sdetVshortnameBrand;
	  }

	  /**
	   * <strong>sdet_vdescription_brand character varying</strong><br>
	   * Descripcion de marca
	   */
	  public void setSdetVdescriptionBrand(String sdetVdescriptionBrand) {
	    this.sdetVdescriptionBrand = sdetVdescriptionBrand;
	  }

	  /**
	   * <strong>sdet_vdescription_brand character varying</strong><br>
	   * Descripcion de marca
	   */
	  public String getSdetVdescriptionBrand() {
	    return sdetVdescriptionBrand;
	  }

	  /**
	   * <strong>sale_bident bigint</strong><br>
	   * Clave foranea de tabla ventas cabecera
	   */
	  public void setSaleBident(Long saleBident) {
	    this.saleBident = saleBident;
	  }

	  /**
	   * <strong>sale_bident bigint</strong><br>
	   * Clave foranea de tabla ventas cabecera
	   */
	  public Long getSaleBident() {
	    return saleBident;
	  }

	  /**
	   * <strong>prod_bident bigint</strong><br>
	   * Clave foranea de tabla producto
	   */
	  public void setProdBident(Long prodBident) {
	    this.prodBident = prodBident;
	  }

	  /**
	   * <strong>prod_bident bigint</strong><br>
	   * Clave foranea de tabla producto
	   */
	  public Long getProdBident() {
	    return prodBident;
	  }

	  /**
	   * <strong>serv_bident bigint</strong><br>
	   * Clave foranea de tabla servicio
	   */
	  public void setServBident(Long servBident) {
	    this.servBident = servBident;
	  }

	  /**
	   * <strong>serv_bident bigint</strong><br>
	   * Clave foranea de tabla servicio
	   */
	  public Long getServBident() {
	    return servBident;
	  }
	  
		/**
		 * <strong>sdet_ndiscount_value_pric numeric</strong><br>
		 * Almacena el valor de venta con descuento
		 */
		public BigDecimal getSdetNdiscountValuePric() {
			return sdetNdiscountValuePric;
		}
		
		/**
		 * <strong>sdet_ndiscount_value_pric numeric</strong><br>
		 * Almacena el valor de venta con descuento
		 */
		public void setSdetNdiscountValuePric(BigDecimal sdetNdiscountValuePric) {
			this.sdetNdiscountValuePric = sdetNdiscountValuePric;
		}
	  
	  /**
	   * <strong>sdet_nigvdescu_pric numeric</strong><br>
	   * Almacena el valor del IGV con descuento
	   */	
		public BigDecimal getSdetNigvdescuPric() {
			return sdetNigvdescuPric;
		}

	  /**
	   * <strong>sdet_nigvdescu_pric numeric</strong><br>
	   * Almacena el valor del IGV con descuento
	   */
		public void setSdetNigvdescuPric(BigDecimal sdetNigvdescuPric) {
			this.sdetNigvdescuPric = sdetNigvdescuPric;
		}
		
		/**
		   * <strong>sdet_ndiscount_value_pric numeric</strong><br>
		   * Almacena el valor de venta con descuento
		   */
		public BigDecimal getSdetNdiscountPrice() {
			return sdetNdiscountPrice;
		}
		
		/**
		   * <strong>sdet_ndiscount_value_pric numeric</strong><br>
		   * Almacena el valor de venta con descuento
		   */
		public void setSdetNdiscountPrice(BigDecimal sdetNdiscountPrice) {
			this.sdetNdiscountPrice = sdetNdiscountPrice;
		}
		
		
		
		/**
		 * <strong>type_vtype_coin_origin character varying</strong><br>
		 * Tipo de moneda origen
		 */
		public String getSdetVtypeCoinOrigin() {
			return sdetVtypeCoinOrigin;
		}

	/**
	 * <strong>type_vtype_coin_origin character varying</strong><br>
	 * Tipo de moneda origen
	 */
		public void setSdetVtypeCoinOrigin(String sdetVtypeCoinOrigin) {
			this.sdetVtypeCoinOrigin = sdetVtypeCoinOrigin;
		}

		 /**
		   * <strong>type_vtype_coin_currency character varying</strong><br>
		   * Tipo de moneda destino
		   */
		public String getSdetVtypeCoinCurrency() {
			return sdetVtypeCoinCurrency;
		}
		
		/**
		 * <strong>type_vtype_coin_currency character varying</strong><br>
		 * Tipo de moneda destino
		 */
		public void setSdetVtypeCoinCurrency(String sdetVtypeCoinCurrency) {
			this.sdetVtypeCoinCurrency = sdetVtypeCoinCurrency;
		}

		  /**
		   * <strong>type_damount_exchange_sales numeric</strong><br>
		   * Monto de cambio de moneda venta
		   */
		public BigDecimal getSdetDamountExchangeSales() {
			return sdetDamountExchangeSales;
		}
		
		/**
		 * <strong>type_damount_exchange_sales numeric</strong><br>
		 * Monto de cambio de moneda venta
		 */
		public void setSdetDamountExchangeSales(BigDecimal sdetDamountExchangeSales) {
			this.sdetDamountExchangeSales = sdetDamountExchangeSales;
		}

		 /**
		   * <strong>sdet_dcurrency_conversion numeric</strong><br>
		   * Conversion de moneda
		   */
		public BigDecimal getSdetDcurrencyConversion() {
			return sdetDcurrencyConversion;
		}
		
		/**
		  * <strong>sdet_dcurrency_conversion numeric</strong><br>
		  * Conversion de moneda
		  */
		public void setSdetDcurrencyConversion(BigDecimal sdetDcurrencyConversion) {
			this.sdetDcurrencyConversion = sdetDcurrencyConversion;
		}

		  /**
		   * <strong>sdet_dtotal_discount numeric</strong><br>
		   * total descuento de venta
		   */
		public BigDecimal getSdetDtotalDiscount() {
			return sdetDtotalDiscount;
		}
		
		/**
		 * <strong>sdet_dtotal_discount numeric</strong><br>
		 * total descuento de venta
		 */
		public void setSdetDtotalDiscount(BigDecimal sdetDtotalDiscount) {
			this.sdetDtotalDiscount = sdetDtotalDiscount;
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
			return "TSaleDetail [sdetBident=" + sdetBident + ", sdetDsubtotal=" + sdetDsubtotal + ", sdetDconversion="
					+ sdetDconversion + ", sdetBnumber=" + sdetBnumber + ", sdetVcode=" + sdetVcode
					+ ", sdetVcommercialCode=" + sdetVcommercialCode + ", sdetVconcept=" + sdetVconcept
					+ ", sdetVmeassureUnity=" + sdetVmeassureUnity + ", sdetDquantity=" + sdetDquantity
					+ ", sdetDunitValue=" + sdetDunitValue + ", sdetDigvUnit=" + sdetDigvUnit + ", sdetDpriceUnit="
					+ sdetDpriceUnit + ", sdetDvalueSale=" + sdetDvalueSale + ", sdetDdescPorcentage="
					+ sdetDdescPorcentage + ", sdetDdescImport=" + sdetDdescImport + ", sdetDtaxBase=" + sdetDtaxBase
					+ ", sdetBincludeIgv=" + sdetBincludeIgv + ", sdetDigv=" + sdetDigv + ", sdetDgrossTotal="
					+ sdetDgrossTotal + ", sdetDnetTotal=" + sdetDnetTotal + ", sdetVaffectionIndicator="
					+ sdetVaffectionIndicator + ", sdetVtypeAffectionIndicator=" + sdetVtypeAffectionIndicator
					+ ", sdetVdescripTypAffecInd=" + sdetVdescripTypAffecInd + ", sdetVobservation=" + sdetVobservation
					+ ", sdetVfreeTransfer=" + sdetVfreeTransfer + ", sdetDisc=" + sdetDisc + ", sdetTregistrationDate="
					+ sdetTregistrationDate + ", sdetTdateUpdate=" + sdetTdateUpdate + ", sdetBuserCreate="
					+ sdetBuserCreate + ", sdetBuserModify=" + sdetBuserModify + ", sdetDporcentagePerception="
					+ sdetDporcentagePerception + ", sdetDimportePerception=" + sdetDimportePerception
					+ ", sdetVexonerate=" + sdetVexonerate + ", sdetDvalueExportation=" + sdetDvalueExportation
					+ ", sdetDvalueTitleFree=" + sdetDvalueTitleFree + ", sdetVshortnameProd=" + sdetVshortnameProd
					+ ", sdetVdescriptionProd=" + sdetVdescriptionProd + ", sdetVshortnameServ=" + sdetVshortnameServ
					+ ", sdetVdescriptionServ=" + sdetVdescriptionServ + ", sdetVdescriptionPrice="
					+ sdetVdescriptionPrice + ", sdetVdescriptionCoinPrice=" + sdetVdescriptionCoinPrice
					+ ", sdetDsaleValuePrice=" + sdetDsaleValuePrice + ", sdetBigvIncludesPrice="
					+ sdetBigvIncludesPrice + ", sdetBexoneratedPrice=" + sdetBexoneratedPrice
					+ ", sdetDdiscountAmountPrice=" + sdetDdiscountAmountPrice + ", sdetDporcentageDiscountPrice="
					+ sdetDporcentageDiscountPrice + ", sdetDsalePrice=" + sdetDsalePrice + ", sdetBmainPrice="
					+ sdetBmainPrice + ", sdetVnameBrand=" + sdetVnameBrand + ", sdetVshortnameBrand="
					+ sdetVshortnameBrand + ", sdetVdescriptionBrand=" + sdetVdescriptionBrand + ", saleBident="
					+ saleBident + ", prodBident=" + prodBident + ", servBident=" + servBident
					+ ", sdetNdiscountValuePric=" + sdetNdiscountValuePric + ", sdetNigvdescuPric=" + sdetNigvdescuPric
					+ ", sdetNdiscountPrice=" + sdetNdiscountPrice + ", sdetVtypeCoinOrigin=" + sdetVtypeCoinOrigin
					+ ", sdetVtypeCoinCurrency=" + sdetVtypeCoinCurrency + ", sdetDamountExchangeSales="
					+ sdetDamountExchangeSales + ", sdetDcurrencyConversion=" + sdetDcurrencyConversion
					+ ", sdetDtotalDiscount=" + sdetDtotalDiscount + ", storeBident=" + storeBident + ", sdetCflagNote="
					+ sdetCflagNote + ", sdetDcantNote=" + sdetDcantNote + ", sdetVclassSunat=" + sdetVclassSunat + "]";
		}

		

	}
	