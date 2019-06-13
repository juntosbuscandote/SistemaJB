package pe.am.spring.entity;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.*;

import java.util.*;


import com.fasterxml.jackson.annotation.*;


/**
 * <strong>t_branch_office</strong><br>
 * Tabla sucursal
 */
@JsonInclude(NON_NULL)
public class TBranchOffice {


  /**
   * <strong>offi_bident bigint NOT NULL</strong><br>
   * Clave primaria de sucursal
   */
//  @NotNull(groups = { OperacionPut.class })
//  @Null(groups = { OperacionPost.class })
//  @Min(1)
//  @ApiModelProperty(value = "Clave primaria de sucursal")
  Long offiBident;

  /**
   * <strong>offi_vname character varying</strong><br>
   * Nombre principal de sucursal
   */
//  @Size(max = 100)
//  @ApiModelProperty(value = "Nombre principal de sucursal")
  String offiVname;

  /**
   * <strong>offi_vshortname character varying</strong><br>
   * Nombre corto de sucursal
   */
//  @Size(max = 10)
//  @ApiModelProperty(value = "Nombre corto de sucursal")
  String offiVshortname;

  /**
   * <strong>offi_tregistration_date timestamp without time zone</strong><br>
   * Fecha de registro de sucursal
   */
//  @ApiModelProperty(value = "Fecha de registro de sucursal")
  Date offiTregistrationDate;

  /**
   * <strong>offi_tdate_update timestamp without time zone</strong><br>
   * Fecha de actualizacion de sucursal
   */
//  @ApiModelProperty(value = "Fecha de actualizacion de sucursal")
  Date offiTdateUpdate;

  /**
   * <strong>offi_buser_create bigint</strong><br>
   * Codigo de usuario que modifica sucursal
   */
//  @ApiModelProperty(value = "Codigo de usuario que modifica sucursal")
  String offiBuserCreate;

  /**
   * <strong>offi_buser_modify bigint</strong><br>
   * Codigo de usuario que modifica sucursal
   */
//  @ApiModelProperty(value = "Codigo de usuario que modifica sucursal")
  String offiBuserModify;

  /**
   * <strong>offi_bstate character</strong><br>
   * Estado de sucursal
   */
//  @Size(max = 2)
//  @ApiModelProperty(value = "Estado de sucursal")
  String offiBstate;

  String offiVstate;
  /**
   * <strong>busi_bident bigint</strong><br>
   * Clave foranea de empresa
   */
//  @Min(1)
//  @ApiModelProperty(value = "Clave foranea de empresa")
  Long busiBident;

  /**
   * <strong>offi_vaddress character varying</strong><br>
   * Direccion de la sucursal
   */
//  @Size(max = 250)
//  @ApiModelProperty(value = "Direccion de la sucursal")
  String offiVaddress;

  /**
   * <strong>offi_vphone character varying</strong><br>
   * Telefono de la sucursal
   */
//  @Size(max = 15)
//  @ApiModelProperty(value = "Telefono de la sucursal")
  String offiVphone;

  /**
   * <strong>offi_vcode character varying</strong><br>
   * Codigo de la sucursal
//   */
//  @Size(max = 5)
//  @ApiModelProperty(value = "Codigo de la sucursal")
  String offiVcode;


  /**
   * <strong>offi_bident bigint NOT NULL</strong><br>
   * Clave primaria de sucursal
   */
  public void setOffiBident(Long offiBident) {
    this.offiBident = offiBident;
  }

  /**
   * <strong>offi_bident bigint NOT NULL</strong><br>
   * Clave primaria de sucursal
   */
  public Long getOffiBident() {
    return offiBident;
  }

  /**
   * <strong>offi_vname character varying</strong><br>
   * Nombre principal de sucursal
   */
  public void setOffiVname(String offiVname) {
    this.offiVname = offiVname;
  }

  /**
   * <strong>offi_vname character varying</strong><br>
   * Nombre principal de sucursal
   */
  public String getOffiVname() {
    return offiVname;
  }

  /**
   * <strong>offi_vshortname character varying</strong><br>
   * Nombre corto de sucursal
   */
  public void setOffiVshortname(String offiVshortname) {
    this.offiVshortname = offiVshortname;
  }

  /**
   * <strong>offi_vshortname character varying</strong><br>
   * Nombre corto de sucursal
   */
  public String getOffiVshortname() {
    return offiVshortname;
  }

  /**
   * <strong>offi_tregistration_date timestamp without time zone</strong><br>
   * Fecha de registro de sucursal
   */
  public void setOffiTregistrationDate(Date offiTregistrationDate) {
    this.offiTregistrationDate = offiTregistrationDate;
  }

  /**
   * <strong>offi_tregistration_date timestamp without time zone</strong><br>
   * Fecha de registro de sucursal
   */
  public Date getOffiTregistrationDate() {
    return offiTregistrationDate;
  }

  /**
   * <strong>offi_tdate_update timestamp without time zone</strong><br>
   * Fecha de actualizacion de sucursal
   */
  public void setOffiTdateUpdate(Date offiTdateUpdate) {
    this.offiTdateUpdate = offiTdateUpdate;
  }

  /**
   * <strong>offi_tdate_update timestamp without time zone</strong><br>
   * Fecha de actualizacion de sucursal
   */
  public Date getOffiTdateUpdate() {
    return offiTdateUpdate;
  }

  /**
   * <strong>offi_buser_create bigint</strong><br>
   * Codigo de usuario que modifica sucursal
   */
  public void setOffiBuserCreate(String offiBuserCreate) {
    this.offiBuserCreate = offiBuserCreate;
  }

  /**
   * <strong>offi_buser_create bigint</strong><br>
   * Codigo de usuario que modifica sucursal
   */
  public String getOffiBuserCreate() {
    return offiBuserCreate;
  }

  /**
   * <strong>offi_buser_modify bigint</strong><br>
   * Codigo de usuario que modifica sucursal
   */
  public void setOffiBuserModify(String offiBuserModify) {
    this.offiBuserModify = offiBuserModify;
  }

  /**
   * <strong>offi_buser_modify bigint</strong><br>
   * Codigo de usuario que modifica sucursal
   */
  public String getOffiBuserModify() {
    return offiBuserModify;
  }

  /**
   * <strong>offi_bstate character</strong><br>
   * Estado de sucursal
   */
  public void setOffiBstate(String offiBstate) {
    this.offiBstate = offiBstate;
  }

  /**
   * <strong>offi_bstate character</strong><br>
   * Estado de sucursal
   */
  public String getOffiBstate() {
    return offiBstate;
  }

  
  public String getOffiVstate() {
	return offiVstate;
  }

  public void setOffiVstate(String offiVstate) {
	this.offiVstate = offiVstate;
  }

/**
   * <strong>busi_bident bigint</strong><br>
   * Clave foranea de empresa
   */
  public void setBusiBident(Long busiBident) {
    this.busiBident = busiBident;
  }

  /**
   * <strong>busi_bident bigint</strong><br>
   * Clave foranea de empresa
   */
  public Long getBusiBident() {
    return busiBident;
  }

  /**
   * <strong>offi_vaddress character varying</strong><br>
   * Direccion de la sucursal
   */
  public void setOffiVaddress(String offiVaddress) {
    this.offiVaddress = offiVaddress;
  }

  /**
   * <strong>offi_vaddress character varying</strong><br>
   * Direccion de la sucursal
   */
  public String getOffiVaddress() {
    return offiVaddress;
  }

  /**
   * <strong>offi_vphone character varying</strong><br>
   * Telefono de la sucursal
   */
  public void setOffiVphone(String offiVphone) {
    this.offiVphone = offiVphone;
  }

  /**
   * <strong>offi_vphone character varying</strong><br>
   * Telefono de la sucursal
   */
  public String getOffiVphone() {
    return offiVphone;
  }

  /**
   * <strong>offi_vcode character varying</strong><br>
   * Codigo de la sucursal
   */
  public void setOffiVcode(String offiVcode) {
    this.offiVcode = offiVcode;
  }

  /**
   * <strong>offi_vcode character varying</strong><br>
   * Codigo de la sucursal
   */
  public String getOffiVcode() {
    return offiVcode;
  }

//  @Override
//  public String toString() {
//    return reflectionToString(this, SHORT_PREFIX_STYLE);
//  }
}