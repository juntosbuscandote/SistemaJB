package pe.am.spring.entity;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.*;
import static org.apache.commons.lang3.builder.ToStringBuilder.*;
import static org.apache.commons.lang3.builder.ToStringStyle.*;

import java.math.*;
import java.util.*;


import com.fasterxml.jackson.annotation.*;


@JsonInclude(NON_NULL)
public class TVoucher {


  /**
   * <strong>vouc_bident bigint NOT NULL</strong>
   */
  Long voucBident;

  /**
   * <strong>vouc_tfechaemision timestamp without time zone</strong>
   */
  Date voucTfechaemision;

  /**
   * <strong>vouc_tfecharecepcion timestamp without time zone</strong>
   */
  Date voucTfecharecepcion;

  /**
   * <strong>vouc_trequestdate timestamp without time zone</strong>
   */
  Date voucTrequestdate;

  /**
   * <strong>vouc_tfechaoper timestamp without time zone</strong>
   */
  Date voucTfechaoper;

  /**
   * <strong>vouc_vtipodoc character varying</strong>
   */
  String voucVtipodoc;

  /**
   * <strong>vouc_vnumero character varying</strong>
   */
  String voucVnumero;

  /**
   * <strong>vouc_vmoneda character varying</strong>
   */
  String voucVmoneda;

  /**
   * <strong>vouc_vgrabada character varying</strong>
   */
  String voucVgrabada;

  /**
   * <strong>vouc_vinafecta character varying</strong>
   */
  String voucVinafecta;

  /**
   * <strong>vouc_vexonerada character varying</strong>
   */
  String voucVexonerada;

  /**
   * <strong>vouc_vgratuita character varying</strong>
   */
  String voucVgratuita;

  /**
   * <strong>vouc_vdescuento character varying</strong>
   */
  String voucVdescuento;

  /**
   * <strong>vouc_subtotal character varying</strong>
   */
  String voucSubtotal;

  /**
   * <strong>vouc_total character varying</strong>
   */
  String voucTotal;

  /**
   * <strong>vouc_igv character varying</strong>
   */
  String voucIgv;

  /**
   * <strong>vouc_proce_status character varying</strong>
   */
  String voucProceStatus;

  /**
   * <strong>vouc_proce_date timestamp without time zone</strong>
   */
  Date voucProceDate;

  /**
   * <strong>vouc_url_pdf character varying</strong>
   */
  String voucUrlPdf;

  /**
   * <strong>vouc_url_xml character varying</strong>
   */
  String voucUrlXml;

  /**
   * <strong>vouc_url_cdr character varying</strong>
   */
  String voucUrlCdr;

  /**
   * <strong>vouc_forma_pago character varying</strong>
   */
  String voucFormaPago;

  /**
   * <strong>vouc_obs character varying</strong>
   */
  String voucObs;

  /**
   * <strong>vouc_tipo_operacion character varying</strong>
   */
  String voucTipoOperacion;

  /**
   * <strong>vouc_idexterno character varying</strong>
   */
  String voucIdexterno;

  /**
   * <strong>vouc_empr_razonsocial character varying</strong>
   */
  String voucEmprRazonsocial;

  /**
   * <strong>vouc_empr_ubigeo character varying</strong>
   */
  String voucEmprUbigeo;

  /**
   * <strong>vouc_empr_nombrecomercial character varying</strong>
   */
  String voucEmprNombrecomercial;

  /**
   * <strong>vouc_empr_direccion character varying</strong>
   */
  String voucEmprDireccion;

  /**
   * <strong>vouc_empr_provincia character varying</strong>
   */
  String voucEmprProvincia;

  /**
   * <strong>vouc_empr_departamento character varying</strong>
   */
  String voucEmprDepartamento;

  /**
   * <strong>vouc_empr_distrito character varying</strong>
   */
  String voucEmprDistrito;

  /**
   * <strong>vouc_empr_pais character varying</strong>
   */
  String voucEmprPais;

  /**
   * <strong>vouc_empr_nroruc character varying</strong>
   */
  String voucEmprNroruc;

  /**
   * <strong>vouc_empr_tipodoc character varying</strong>
   */
  String voucEmprTipodoc;

  /**
   * <strong>vouc_clie_numero character varying</strong>
   */
  String voucClieNumero;

  /**
   * <strong>vouc_clie_tipodoc character varying</strong>
   */
  String voucClieTipodoc;

  /**
   * <strong>vouc_clie_nombre character varying</strong>
   */
  String voucClieNombre;

  /**
   * <strong>vouc_tasa_igv character varying</strong>
   */
  String voucTasaIgv;

  /**
   * <strong>vouc_docu_isc character varying</strong>
   */
  String voucDocuIsc;

  /**
   * <strong>vouc_tasa_isc character varying</strong>
   */
  String voucTasaIsc;

  /**
   * <strong>vouc_docu_otrostributos character varying</strong>
   */
  String voucDocuOtrostributos;

  /**
   * <strong>vouc_tasa_otrostributos character varying</strong>
   */
  String voucTasaOtrostributos;

  /**
   * <strong>vouc_rete_regi character varying</strong>
   */
  String voucReteRegi;

  /**
   * <strong>vouc_rete_tasa character varying</strong>
   */
  String voucReteTasa;

  /**
   * <strong>vouc_rete_total_elec character varying</strong>
   */
  String voucReteTotalElec;

  /**
   * <strong>vouc_rete_total_rete character varying</strong>
   */
  String voucReteTotalRete;

  /**
   * <strong>vouc_docu_otroscargos character varying</strong>
   */
  String voucDocuOtroscargos;

  /**
   * <strong>vouc_docu_percepcion character varying</strong>
   */
  String voucDocuPercepcion;

  /**
   * <strong>vouc_nota_motivo character varying</strong>
   */
  String voucNotaMotivo;

  /**
   * <strong>vouc_nota_sustento character varying</strong>
   */
  String voucNotaSustento;

  /**
   * <strong>vouc_nota_tipodoc character varying</strong>
   */
  String voucNotaTipodoc;

  /**
   * <strong>vouc_nota_documento character varying</strong>
   */
  String voucNotaDocumento;

  /**
   * <strong>vouc_estado_cdr character varying</strong>
   */
  String voucEstadoCdr;

  /**
   * <strong>vouc_cdr_nota character varying</strong>
   */
  String voucCdrNota;

  /**
   * <strong>vouc_cdr_observacion character varying</strong>
   */
  String voucCdrObservacion;

  /**
   * <strong>vouc_clie_direccion character varying</strong>
   */
  String voucClieDireccion;

  /**
   * <strong>vouc_docu_vendedor character varying</strong>
   */
  String voucDocuVendedor;

  /**
   * <strong>vouc_docu_pedido character varying</strong>
   */
  String voucDocuPedido;

  /**
   * <strong>vouc_docu_guia_remision character varying</strong>
   */
  String voucDocuGuiaRemision;

  /**
   * <strong>vouc_clie_orden_compra character varying</strong>
   */
  String voucClieOrdenCompra;

  /**
   * <strong>vouc_clie_correo_cpe1 character varying</strong>
   */
  String voucClieCorreoCpe1;

  /**
   * <strong>vouc_clie_correo_cpe2 character varying</strong>
   */
  String voucClieCorreoCpe2;

  /**
   * <strong>vouc_clie_correo_cpe0 character varying</strong>
   */
  String voucClieCorreoCpe0;

  /**
   * <strong>vouc_docu_anticipo_total character varying</strong>
   */
  String voucDocuAnticipoTotal;

  /**
   * <strong>vouc_empr_direccion_suc character varying</strong>
   */
  String voucEmprDireccionSuc;

  /**
   * <strong>vouc_empr_ubigeo_suc character varying</strong>
   */
  String voucEmprUbigeoSuc;

  /**
   * <strong>vouc_empr_departamento_suc character varying</strong>
   */
  String voucEmprDepartamentoSuc;

  /**
   * <strong>vouc_empr_provincia_suc character varying</strong>
   */
  String voucEmprProvinciaSuc;

  /**
   * <strong>vouc_empr_distrito_suc character varying</strong>
   */
  String voucEmprDistritoSuc;

  /**
   * <strong>vouc_resu_fecha_generacion character varying</strong>
   */
  String voucResuFechaGeneracion;

  /**
   * <strong>vouc_resu_identificador character varying</strong>
   */
  String voucResuIdentificador;

  /**
   * <strong>vouc_resu_fila character varying</strong>
   */
  String voucResuFila;

  /**
   * <strong>vouc_resu_version character varying</strong>
   */
  String voucResuVersion;

  /**
   * <strong>vouc_resu_estado character varying</strong>
   */
  String voucResuEstado;

  /**
   * <strong>vouc_item_estado character varying</strong>
   */
  String voucItemEstado;

  /**
   * <strong>vouc_tregistration_date timestamp with time zone</strong>
   */
  Date voucTregistrationDate;

  /**
   * <strong>vouc_tdate_update timestamp with time zone</strong>
   */
  Date voucTdateUpdate;

  /**
   * <strong>vouc_buser_modify bigint</strong>
   */
  Long voucBuserModify;

  /**
   * <strong>busi_bident bigint</strong>
   */
  Long busiBident;

  /**
   * <strong>clie_bident bigint</strong>
   */
  Long clieBident;

  String voucVestado;

  
  public String getVoucVestado() {
	return voucVestado;
}

public void setVoucVestado(String voucVestado) {
	this.voucVestado = voucVestado;
}

/**
   * <strong>vouc_bident bigint NOT NULL</strong>
   */
  public void setVoucBident(Long voucBident) {
    this.voucBident = voucBident;
  }

  /**
   * <strong>vouc_bident bigint NOT NULL</strong>
   */
  public Long getVoucBident() {
    return voucBident;
  }

  /**
   * <strong>vouc_tfechaemision timestamp without time zone</strong>
   */
  public void setVoucTfechaemision(Date voucTfechaemision) {
    this.voucTfechaemision = voucTfechaemision;
  }

  /**
   * <strong>vouc_tfechaemision timestamp without time zone</strong>
   */
  public Date getVoucTfechaemision() {
    return voucTfechaemision;
  }

  /**
   * <strong>vouc_tfecharecepcion timestamp without time zone</strong>
   */
  public void setVoucTfecharecepcion(Date voucTfecharecepcion) {
    this.voucTfecharecepcion = voucTfecharecepcion;
  }

  /**
   * <strong>vouc_tfecharecepcion timestamp without time zone</strong>
   */
  public Date getVoucTfecharecepcion() {
    return voucTfecharecepcion;
  }

  /**
   * <strong>vouc_trequestdate timestamp without time zone</strong>
   */
  public void setVoucTrequestdate(Date voucTrequestdate) {
    this.voucTrequestdate = voucTrequestdate;
  }

  /**
   * <strong>vouc_trequestdate timestamp without time zone</strong>
   */
  public Date getVoucTrequestdate() {
    return voucTrequestdate;
  }

  /**
   * <strong>vouc_tfechaoper timestamp without time zone</strong>
   */
  public void setVoucTfechaoper(Date voucTfechaoper) {
    this.voucTfechaoper = voucTfechaoper;
  }

  /**
   * <strong>vouc_tfechaoper timestamp without time zone</strong>
   */
  public Date getVoucTfechaoper() {
    return voucTfechaoper;
  }

  /**
   * <strong>vouc_vtipodoc character varying</strong>
   */
  public void setVoucVtipodoc(String voucVtipodoc) {
    this.voucVtipodoc = voucVtipodoc;
  }

  /**
   * <strong>vouc_vtipodoc character varying</strong>
   */
  public String getVoucVtipodoc() {
    return voucVtipodoc;
  }

  /**
   * <strong>vouc_vnumero character varying</strong>
   */
  public void setVoucVnumero(String voucVnumero) {
    this.voucVnumero = voucVnumero;
  }

  /**
   * <strong>vouc_vnumero character varying</strong>
   */
  public String getVoucVnumero() {
    return voucVnumero;
  }

  /**
   * <strong>vouc_vmoneda character varying</strong>
   */
  public void setVoucVmoneda(String voucVmoneda) {
    this.voucVmoneda = voucVmoneda;
  }

  /**
   * <strong>vouc_vmoneda character varying</strong>
   */
  public String getVoucVmoneda() {
    return voucVmoneda;
  }

  /**
   * <strong>vouc_vgrabada character varying</strong>
   */
  public void setVoucVgrabada(String voucVgrabada) {
    this.voucVgrabada = voucVgrabada;
  }

  /**
   * <strong>vouc_vgrabada character varying</strong>
   */
  public String getVoucVgrabada() {
    return voucVgrabada;
  }

  /**
   * <strong>vouc_vinafecta character varying</strong>
   */
  public void setVoucVinafecta(String voucVinafecta) {
    this.voucVinafecta = voucVinafecta;
  }

  /**
   * <strong>vouc_vinafecta character varying</strong>
   */
  public String getVoucVinafecta() {
    return voucVinafecta;
  }

  /**
   * <strong>vouc_vexonerada character varying</strong>
   */
  public void setVoucVexonerada(String voucVexonerada) {
    this.voucVexonerada = voucVexonerada;
  }

  /**
   * <strong>vouc_vexonerada character varying</strong>
   */
  public String getVoucVexonerada() {
    return voucVexonerada;
  }

  /**
   * <strong>vouc_vgratuita character varying</strong>
   */
  public void setVoucVgratuita(String voucVgratuita) {
    this.voucVgratuita = voucVgratuita;
  }

  /**
   * <strong>vouc_vgratuita character varying</strong>
   */
  public String getVoucVgratuita() {
    return voucVgratuita;
  }

  /**
   * <strong>vouc_vdescuento character varying</strong>
   */
  public void setVoucVdescuento(String voucVdescuento) {
    this.voucVdescuento = voucVdescuento;
  }

  /**
   * <strong>vouc_vdescuento character varying</strong>
   */
  public String getVoucVdescuento() {
    return voucVdescuento;
  }

  /**
   * <strong>vouc_subtotal character varying</strong>
   */
  public void setVoucSubtotal(String voucSubtotal) {
    this.voucSubtotal = voucSubtotal;
  }

  /**
   * <strong>vouc_subtotal character varying</strong>
   */
  public String getVoucSubtotal() {
    return voucSubtotal;
  }

  /**
   * <strong>vouc_total character varying</strong>
   */
  public void setVoucTotal(String voucTotal) {
    this.voucTotal = voucTotal;
  }

  /**
   * <strong>vouc_total character varying</strong>
   */
  public String getVoucTotal() {
    return voucTotal;
  }

  /**
   * <strong>vouc_igv character varying</strong>
   */
  public void setVoucIgv(String voucIgv) {
    this.voucIgv = voucIgv;
  }

  /**
   * <strong>vouc_igv character varying</strong>
   */
  public String getVoucIgv() {
    return voucIgv;
  }

  /**
   * <strong>vouc_proce_status character varying</strong>
   */
  public void setVoucProceStatus(String voucProceStatus) {
    this.voucProceStatus = voucProceStatus;
  }

  /**
   * <strong>vouc_proce_status character varying</strong>
   */
  public String getVoucProceStatus() {
    return voucProceStatus;
  }

  /**
   * <strong>vouc_proce_date timestamp without time zone</strong>
   */
  public void setVoucProceDate(Date voucProceDate) {
    this.voucProceDate = voucProceDate;
  }

  /**
   * <strong>vouc_proce_date timestamp without time zone</strong>
   */
  public Date getVoucProceDate() {
    return voucProceDate;
  }

  /**
   * <strong>vouc_url_pdf character varying</strong>
   */
  public void setVoucUrlPdf(String voucUrlPdf) {
    this.voucUrlPdf = voucUrlPdf;
  }

  /**
   * <strong>vouc_url_pdf character varying</strong>
   */
  public String getVoucUrlPdf() {
    return voucUrlPdf;
  }

  /**
   * <strong>vouc_url_xml character varying</strong>
   */
  public void setVoucUrlXml(String voucUrlXml) {
    this.voucUrlXml = voucUrlXml;
  }

  /**
   * <strong>vouc_url_xml character varying</strong>
   */
  public String getVoucUrlXml() {
    return voucUrlXml;
  }

  /**
   * <strong>vouc_url_cdr character varying</strong>
   */
  public void setVoucUrlCdr(String voucUrlCdr) {
    this.voucUrlCdr = voucUrlCdr;
  }

  /**
   * <strong>vouc_url_cdr character varying</strong>
   */
  public String getVoucUrlCdr() {
    return voucUrlCdr;
  }

  /**
   * <strong>vouc_forma_pago character varying</strong>
   */
  public void setVoucFormaPago(String voucFormaPago) {
    this.voucFormaPago = voucFormaPago;
  }

  /**
   * <strong>vouc_forma_pago character varying</strong>
   */
  public String getVoucFormaPago() {
    return voucFormaPago;
  }

  /**
   * <strong>vouc_obs character varying</strong>
   */
  public void setVoucObs(String voucObs) {
    this.voucObs = voucObs;
  }

  /**
   * <strong>vouc_obs character varying</strong>
   */
  public String getVoucObs() {
    return voucObs;
  }

  /**
   * <strong>vouc_tipo_operacion character varying</strong>
   */
  public void setVoucTipoOperacion(String voucTipoOperacion) {
    this.voucTipoOperacion = voucTipoOperacion;
  }

  /**
   * <strong>vouc_tipo_operacion character varying</strong>
   */
  public String getVoucTipoOperacion() {
    return voucTipoOperacion;
  }

  /**
   * <strong>vouc_idexterno character varying</strong>
   */
  public void setVoucIdexterno(String voucIdexterno) {
    this.voucIdexterno = voucIdexterno;
  }

  /**
   * <strong>vouc_idexterno character varying</strong>
   */
  public String getVoucIdexterno() {
    return voucIdexterno;
  }

  /**
   * <strong>vouc_empr_razonsocial character varying</strong>
   */
  public void setVoucEmprRazonsocial(String voucEmprRazonsocial) {
    this.voucEmprRazonsocial = voucEmprRazonsocial;
  }

  /**
   * <strong>vouc_empr_razonsocial character varying</strong>
   */
  public String getVoucEmprRazonsocial() {
    return voucEmprRazonsocial;
  }

  /**
   * <strong>vouc_empr_ubigeo character varying</strong>
   */
  public void setVoucEmprUbigeo(String voucEmprUbigeo) {
    this.voucEmprUbigeo = voucEmprUbigeo;
  }

  /**
   * <strong>vouc_empr_ubigeo character varying</strong>
   */
  public String getVoucEmprUbigeo() {
    return voucEmprUbigeo;
  }

  /**
   * <strong>vouc_empr_nombrecomercial character varying</strong>
   */
  public void setVoucEmprNombrecomercial(String voucEmprNombrecomercial) {
    this.voucEmprNombrecomercial = voucEmprNombrecomercial;
  }

  /**
   * <strong>vouc_empr_nombrecomercial character varying</strong>
   */
  public String getVoucEmprNombrecomercial() {
    return voucEmprNombrecomercial;
  }

  /**
   * <strong>vouc_empr_direccion character varying</strong>
   */
  public void setVoucEmprDireccion(String voucEmprDireccion) {
    this.voucEmprDireccion = voucEmprDireccion;
  }

  /**
   * <strong>vouc_empr_direccion character varying</strong>
   */
  public String getVoucEmprDireccion() {
    return voucEmprDireccion;
  }

  /**
   * <strong>vouc_empr_provincia character varying</strong>
   */
  public void setVoucEmprProvincia(String voucEmprProvincia) {
    this.voucEmprProvincia = voucEmprProvincia;
  }

  /**
   * <strong>vouc_empr_provincia character varying</strong>
   */
  public String getVoucEmprProvincia() {
    return voucEmprProvincia;
  }

  /**
   * <strong>vouc_empr_departamento character varying</strong>
   */
  public void setVoucEmprDepartamento(String voucEmprDepartamento) {
    this.voucEmprDepartamento = voucEmprDepartamento;
  }

  /**
   * <strong>vouc_empr_departamento character varying</strong>
   */
  public String getVoucEmprDepartamento() {
    return voucEmprDepartamento;
  }

  /**
   * <strong>vouc_empr_distrito character varying</strong>
   */
  public void setVoucEmprDistrito(String voucEmprDistrito) {
    this.voucEmprDistrito = voucEmprDistrito;
  }

  /**
   * <strong>vouc_empr_distrito character varying</strong>
   */
  public String getVoucEmprDistrito() {
    return voucEmprDistrito;
  }

  /**
   * <strong>vouc_empr_pais character varying</strong>
   */
  public void setVoucEmprPais(String voucEmprPais) {
    this.voucEmprPais = voucEmprPais;
  }

  /**
   * <strong>vouc_empr_pais character varying</strong>
   */
  public String getVoucEmprPais() {
    return voucEmprPais;
  }

  /**
   * <strong>vouc_empr_nroruc character varying</strong>
   */
  public void setVoucEmprNroruc(String voucEmprNroruc) {
    this.voucEmprNroruc = voucEmprNroruc;
  }

  /**
   * <strong>vouc_empr_nroruc character varying</strong>
   */
  public String getVoucEmprNroruc() {
    return voucEmprNroruc;
  }

  /**
   * <strong>vouc_empr_tipodoc character varying</strong>
   */
  public void setVoucEmprTipodoc(String voucEmprTipodoc) {
    this.voucEmprTipodoc = voucEmprTipodoc;
  }

  /**
   * <strong>vouc_empr_tipodoc character varying</strong>
   */
  public String getVoucEmprTipodoc() {
    return voucEmprTipodoc;
  }

  /**
   * <strong>vouc_clie_numero character varying</strong>
   */
  public void setVoucClieNumero(String voucClieNumero) {
    this.voucClieNumero = voucClieNumero;
  }

  /**
   * <strong>vouc_clie_numero character varying</strong>
   */
  public String getVoucClieNumero() {
    return voucClieNumero;
  }

  /**
   * <strong>vouc_clie_tipodoc character varying</strong>
   */
  public void setVoucClieTipodoc(String voucClieTipodoc) {
    this.voucClieTipodoc = voucClieTipodoc;
  }

  /**
   * <strong>vouc_clie_tipodoc character varying</strong>
   */
  public String getVoucClieTipodoc() {
    return voucClieTipodoc;
  }

  /**
   * <strong>vouc_clie_nombre character varying</strong>
   */
  public void setVoucClieNombre(String voucClieNombre) {
    this.voucClieNombre = voucClieNombre;
  }

  /**
   * <strong>vouc_clie_nombre character varying</strong>
   */
  public String getVoucClieNombre() {
    return voucClieNombre;
  }

  /**
   * <strong>vouc_tasa_igv character varying</strong>
   */
  public void setVoucTasaIgv(String voucTasaIgv) {
    this.voucTasaIgv = voucTasaIgv;
  }

  /**
   * <strong>vouc_tasa_igv character varying</strong>
   */
  public String getVoucTasaIgv() {
    return voucTasaIgv;
  }

  /**
   * <strong>vouc_docu_isc character varying</strong>
   */
  public void setVoucDocuIsc(String voucDocuIsc) {
    this.voucDocuIsc = voucDocuIsc;
  }

  /**
   * <strong>vouc_docu_isc character varying</strong>
   */
  public String getVoucDocuIsc() {
    return voucDocuIsc;
  }

  /**
   * <strong>vouc_tasa_isc character varying</strong>
   */
  public void setVoucTasaIsc(String voucTasaIsc) {
    this.voucTasaIsc = voucTasaIsc;
  }

  /**
   * <strong>vouc_tasa_isc character varying</strong>
   */
  public String getVoucTasaIsc() {
    return voucTasaIsc;
  }

  /**
   * <strong>vouc_docu_otrostributos character varying</strong>
   */
  public void setVoucDocuOtrostributos(String voucDocuOtrostributos) {
    this.voucDocuOtrostributos = voucDocuOtrostributos;
  }

  /**
   * <strong>vouc_docu_otrostributos character varying</strong>
   */
  public String getVoucDocuOtrostributos() {
    return voucDocuOtrostributos;
  }

  /**
   * <strong>vouc_tasa_otrostributos character varying</strong>
   */
  public void setVoucTasaOtrostributos(String voucTasaOtrostributos) {
    this.voucTasaOtrostributos = voucTasaOtrostributos;
  }

  /**
   * <strong>vouc_tasa_otrostributos character varying</strong>
   */
  public String getVoucTasaOtrostributos() {
    return voucTasaOtrostributos;
  }

  /**
   * <strong>vouc_rete_regi character varying</strong>
   */
  public void setVoucReteRegi(String voucReteRegi) {
    this.voucReteRegi = voucReteRegi;
  }

  /**
   * <strong>vouc_rete_regi character varying</strong>
   */
  public String getVoucReteRegi() {
    return voucReteRegi;
  }

  /**
   * <strong>vouc_rete_tasa character varying</strong>
   */
  public void setVoucReteTasa(String voucReteTasa) {
    this.voucReteTasa = voucReteTasa;
  }

  /**
   * <strong>vouc_rete_tasa character varying</strong>
   */
  public String getVoucReteTasa() {
    return voucReteTasa;
  }

  /**
   * <strong>vouc_rete_total_elec character varying</strong>
   */
  public void setVoucReteTotalElec(String voucReteTotalElec) {
    this.voucReteTotalElec = voucReteTotalElec;
  }

  /**
   * <strong>vouc_rete_total_elec character varying</strong>
   */
  public String getVoucReteTotalElec() {
    return voucReteTotalElec;
  }

  /**
   * <strong>vouc_rete_total_rete character varying</strong>
   */
  public void setVoucReteTotalRete(String voucReteTotalRete) {
    this.voucReteTotalRete = voucReteTotalRete;
  }

  /**
   * <strong>vouc_rete_total_rete character varying</strong>
   */
  public String getVoucReteTotalRete() {
    return voucReteTotalRete;
  }

  /**
   * <strong>vouc_docu_otroscargos character varying</strong>
   */
  public void setVoucDocuOtroscargos(String voucDocuOtroscargos) {
    this.voucDocuOtroscargos = voucDocuOtroscargos;
  }

  /**
   * <strong>vouc_docu_otroscargos character varying</strong>
   */
  public String getVoucDocuOtroscargos() {
    return voucDocuOtroscargos;
  }

  /**
   * <strong>vouc_docu_percepcion character varying</strong>
   */
  public void setVoucDocuPercepcion(String voucDocuPercepcion) {
    this.voucDocuPercepcion = voucDocuPercepcion;
  }

  /**
   * <strong>vouc_docu_percepcion character varying</strong>
   */
  public String getVoucDocuPercepcion() {
    return voucDocuPercepcion;
  }

  /**
   * <strong>vouc_nota_motivo character varying</strong>
   */
  public void setVoucNotaMotivo(String voucNotaMotivo) {
    this.voucNotaMotivo = voucNotaMotivo;
  }

  /**
   * <strong>vouc_nota_motivo character varying</strong>
   */
  public String getVoucNotaMotivo() {
    return voucNotaMotivo;
  }

  /**
   * <strong>vouc_nota_sustento character varying</strong>
   */
  public void setVoucNotaSustento(String voucNotaSustento) {
    this.voucNotaSustento = voucNotaSustento;
  }

  /**
   * <strong>vouc_nota_sustento character varying</strong>
   */
  public String getVoucNotaSustento() {
    return voucNotaSustento;
  }

  /**
   * <strong>vouc_nota_tipodoc character varying</strong>
   */
  public void setVoucNotaTipodoc(String voucNotaTipodoc) {
    this.voucNotaTipodoc = voucNotaTipodoc;
  }

  /**
   * <strong>vouc_nota_tipodoc character varying</strong>
   */
  public String getVoucNotaTipodoc() {
    return voucNotaTipodoc;
  }

  /**
   * <strong>vouc_nota_documento character varying</strong>
   */
  public void setVoucNotaDocumento(String voucNotaDocumento) {
    this.voucNotaDocumento = voucNotaDocumento;
  }

  /**
   * <strong>vouc_nota_documento character varying</strong>
   */
  public String getVoucNotaDocumento() {
    return voucNotaDocumento;
  }

  /**
   * <strong>vouc_estado_cdr character varying</strong>
   */
  public void setVoucEstadoCdr(String voucEstadoCdr) {
    this.voucEstadoCdr = voucEstadoCdr;
  }

  /**
   * <strong>vouc_estado_cdr character varying</strong>
   */
  public String getVoucEstadoCdr() {
    return voucEstadoCdr;
  }

  /**
   * <strong>vouc_cdr_nota character varying</strong>
   */
  public void setVoucCdrNota(String voucCdrNota) {
    this.voucCdrNota = voucCdrNota;
  }

  /**
   * <strong>vouc_cdr_nota character varying</strong>
   */
  public String getVoucCdrNota() {
    return voucCdrNota;
  }

  /**
   * <strong>vouc_cdr_observacion character varying</strong>
   */
  public void setVoucCdrObservacion(String voucCdrObservacion) {
    this.voucCdrObservacion = voucCdrObservacion;
  }

  /**
   * <strong>vouc_cdr_observacion character varying</strong>
   */
  public String getVoucCdrObservacion() {
    return voucCdrObservacion;
  }

  /**
   * <strong>vouc_clie_direccion character varying</strong>
   */
  public void setVoucClieDireccion(String voucClieDireccion) {
    this.voucClieDireccion = voucClieDireccion;
  }

  /**
   * <strong>vouc_clie_direccion character varying</strong>
   */
  public String getVoucClieDireccion() {
    return voucClieDireccion;
  }

  /**
   * <strong>vouc_docu_vendedor character varying</strong>
   */
  public void setVoucDocuVendedor(String voucDocuVendedor) {
    this.voucDocuVendedor = voucDocuVendedor;
  }

  /**
   * <strong>vouc_docu_vendedor character varying</strong>
   */
  public String getVoucDocuVendedor() {
    return voucDocuVendedor;
  }

  /**
   * <strong>vouc_docu_pedido character varying</strong>
   */
  public void setVoucDocuPedido(String voucDocuPedido) {
    this.voucDocuPedido = voucDocuPedido;
  }

  /**
   * <strong>vouc_docu_pedido character varying</strong>
   */
  public String getVoucDocuPedido() {
    return voucDocuPedido;
  }

  /**
   * <strong>vouc_docu_guia_remision character varying</strong>
   */
  public void setVoucDocuGuiaRemision(String voucDocuGuiaRemision) {
    this.voucDocuGuiaRemision = voucDocuGuiaRemision;
  }

  /**
   * <strong>vouc_docu_guia_remision character varying</strong>
   */
  public String getVoucDocuGuiaRemision() {
    return voucDocuGuiaRemision;
  }

  /**
   * <strong>vouc_clie_orden_compra character varying</strong>
   */
  public void setVoucClieOrdenCompra(String voucClieOrdenCompra) {
    this.voucClieOrdenCompra = voucClieOrdenCompra;
  }

  /**
   * <strong>vouc_clie_orden_compra character varying</strong>
   */
  public String getVoucClieOrdenCompra() {
    return voucClieOrdenCompra;
  }

  /**
   * <strong>vouc_clie_correo_cpe1 character varying</strong>
   */
  public void setVoucClieCorreoCpe1(String voucClieCorreoCpe1) {
    this.voucClieCorreoCpe1 = voucClieCorreoCpe1;
  }

  /**
   * <strong>vouc_clie_correo_cpe1 character varying</strong>
   */
  public String getVoucClieCorreoCpe1() {
    return voucClieCorreoCpe1;
  }

  /**
   * <strong>vouc_clie_correo_cpe2 character varying</strong>
   */
  public void setVoucClieCorreoCpe2(String voucClieCorreoCpe2) {
    this.voucClieCorreoCpe2 = voucClieCorreoCpe2;
  }

  /**
   * <strong>vouc_clie_correo_cpe2 character varying</strong>
   */
  public String getVoucClieCorreoCpe2() {
    return voucClieCorreoCpe2;
  }

  /**
   * <strong>vouc_clie_correo_cpe0 character varying</strong>
   */
  public void setVoucClieCorreoCpe0(String voucClieCorreoCpe0) {
    this.voucClieCorreoCpe0 = voucClieCorreoCpe0;
  }

  /**
   * <strong>vouc_clie_correo_cpe0 character varying</strong>
   */
  public String getVoucClieCorreoCpe0() {
    return voucClieCorreoCpe0;
  }

  /**
   * <strong>vouc_docu_anticipo_total character varying</strong>
   */
  public void setVoucDocuAnticipoTotal(String voucDocuAnticipoTotal) {
    this.voucDocuAnticipoTotal = voucDocuAnticipoTotal;
  }

  /**
   * <strong>vouc_docu_anticipo_total character varying</strong>
   */
  public String getVoucDocuAnticipoTotal() {
    return voucDocuAnticipoTotal;
  }

  /**
   * <strong>vouc_empr_direccion_suc character varying</strong>
   */
  public void setVoucEmprDireccionSuc(String voucEmprDireccionSuc) {
    this.voucEmprDireccionSuc = voucEmprDireccionSuc;
  }

  /**
   * <strong>vouc_empr_direccion_suc character varying</strong>
   */
  public String getVoucEmprDireccionSuc() {
    return voucEmprDireccionSuc;
  }

  /**
   * <strong>vouc_empr_ubigeo_suc character varying</strong>
   */
  public void setVoucEmprUbigeoSuc(String voucEmprUbigeoSuc) {
    this.voucEmprUbigeoSuc = voucEmprUbigeoSuc;
  }

  /**
   * <strong>vouc_empr_ubigeo_suc character varying</strong>
   */
  public String getVoucEmprUbigeoSuc() {
    return voucEmprUbigeoSuc;
  }

  /**
   * <strong>vouc_empr_departamento_suc character varying</strong>
   */
  public void setVoucEmprDepartamentoSuc(String voucEmprDepartamentoSuc) {
    this.voucEmprDepartamentoSuc = voucEmprDepartamentoSuc;
  }

  /**
   * <strong>vouc_empr_departamento_suc character varying</strong>
   */
  public String getVoucEmprDepartamentoSuc() {
    return voucEmprDepartamentoSuc;
  }

  /**
   * <strong>vouc_empr_provincia_suc character varying</strong>
   */
  public void setVoucEmprProvinciaSuc(String voucEmprProvinciaSuc) {
    this.voucEmprProvinciaSuc = voucEmprProvinciaSuc;
  }

  /**
   * <strong>vouc_empr_provincia_suc character varying</strong>
   */
  public String getVoucEmprProvinciaSuc() {
    return voucEmprProvinciaSuc;
  }

  /**
   * <strong>vouc_empr_distrito_suc character varying</strong>
   */
  public void setVoucEmprDistritoSuc(String voucEmprDistritoSuc) {
    this.voucEmprDistritoSuc = voucEmprDistritoSuc;
  }

  /**
   * <strong>vouc_empr_distrito_suc character varying</strong>
   */
  public String getVoucEmprDistritoSuc() {
    return voucEmprDistritoSuc;
  }

  /**
   * <strong>vouc_resu_fecha_generacion character varying</strong>
   */
  public void setVoucResuFechaGeneracion(String voucResuFechaGeneracion) {
    this.voucResuFechaGeneracion = voucResuFechaGeneracion;
  }

  /**
   * <strong>vouc_resu_fecha_generacion character varying</strong>
   */
  public String getVoucResuFechaGeneracion() {
    return voucResuFechaGeneracion;
  }

  /**
   * <strong>vouc_resu_identificador character varying</strong>
   */
  public void setVoucResuIdentificador(String voucResuIdentificador) {
    this.voucResuIdentificador = voucResuIdentificador;
  }

  /**
   * <strong>vouc_resu_identificador character varying</strong>
   */
  public String getVoucResuIdentificador() {
    return voucResuIdentificador;
  }

  /**
   * <strong>vouc_resu_fila character varying</strong>
   */
  public void setVoucResuFila(String voucResuFila) {
    this.voucResuFila = voucResuFila;
  }

  /**
   * <strong>vouc_resu_fila character varying</strong>
   */
  public String getVoucResuFila() {
    return voucResuFila;
  }

  /**
   * <strong>vouc_resu_version character varying</strong>
   */
  public void setVoucResuVersion(String voucResuVersion) {
    this.voucResuVersion = voucResuVersion;
  }

  /**
   * <strong>vouc_resu_version character varying</strong>
   */
  public String getVoucResuVersion() {
    return voucResuVersion;
  }

  /**
   * <strong>vouc_resu_estado character varying</strong>
   */
  public void setVoucResuEstado(String voucResuEstado) {
    this.voucResuEstado = voucResuEstado;
  }

  /**
   * <strong>vouc_resu_estado character varying</strong>
   */
  public String getVoucResuEstado() {
    return voucResuEstado;
  }

  /**
   * <strong>vouc_item_estado character varying</strong>
   */
  public void setVoucItemEstado(String voucItemEstado) {
    this.voucItemEstado = voucItemEstado;
  }

  /**
   * <strong>vouc_item_estado character varying</strong>
   */
  public String getVoucItemEstado() {
    return voucItemEstado;
  }

  /**
   * <strong>vouc_tregistration_date timestamp with time zone</strong>
   */
  public void setVoucTregistrationDate(Date voucTregistrationDate) {
    this.voucTregistrationDate = voucTregistrationDate;
  }

  /**
   * <strong>vouc_tregistration_date timestamp with time zone</strong>
   */
  public Date getVoucTregistrationDate() {
    return voucTregistrationDate;
  }

  /**
   * <strong>vouc_tdate_update timestamp with time zone</strong>
   */
  public void setVoucTdateUpdate(Date voucTdateUpdate) {
    this.voucTdateUpdate = voucTdateUpdate;
  }

  /**
   * <strong>vouc_tdate_update timestamp with time zone</strong>
   */
  public Date getVoucTdateUpdate() {
    return voucTdateUpdate;
  }

  /**
   * <strong>vouc_buser_modify bigint</strong>
   */
  public void setVoucBuserModify(Long voucBuserModify) {
    this.voucBuserModify = voucBuserModify;
  }

  /**
   * <strong>vouc_buser_modify bigint</strong>
   */
  public Long getVoucBuserModify() {
    return voucBuserModify;
  }

  /**
   * <strong>busi_bident bigint</strong>
   */
  public void setBusiBident(Long busiBident) {
    this.busiBident = busiBident;
  }

  /**
   * <strong>busi_bident bigint</strong>
   */
  public Long getBusiBident() {
    return busiBident;
  }

  /**
   * <strong>clie_bident bigint</strong>
   */
  public void setClieBident(Long clieBident) {
    this.clieBident = clieBident;
  }

  /**
   * <strong>clie_bident bigint</strong>
   */
  public Long getClieBident() {
    return clieBident;
  }

  @Override
  public String toString() {
    return reflectionToString(this, SHORT_PREFIX_STYLE);
  }
}