package pe.am.spring.entity;

import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

import java.util.Date;




/**
 * <strong>t_business_group</strong><br>
 * Tabla de Perfiles de la Web ContaNet
 */
//@JsonInclude(NON_NULL)
public class TBusinessGroup {


  /**
   * <strong>busgr_bident bigint NOT NULL</strong><br>
   * Id de la tabla
   */
//  @NotNull(groups = { OperacionPut.class })
//  @Null(groups = { OperacionPost.class })
//  @Min(1)
//  @ApiModelProperty(value = "Id de la tabla")
  Long busgrBident;

  /**
   * <strong>busgr_vname character varying</strong><br>
   * nombre del grupo comercial
   */
//  @Size(max = 30)
//  @ApiModelProperty(value = "nombre del grupo comercial")
  String busgrVname;

  /**
   * <strong>busgr_vdescription character varying</strong><br>
   * Descripcion del grupo comercial
   */
//  @Size(max = 150)
//  @ApiModelProperty(value = "Descripcion del grupo comercial")
  String busgrVdescription;

  /**
   * <strong>busgr_bstate character</strong><br>
   * Estado del grupo comercial
   */
//  @Size(max = 2)
//  @ApiModelProperty(value = "Estado del grupo comercial")
  String busgrBstate;

  /**
   * <strong>busgr_tregistration_date timestamp without time zone</strong><br>
   * Auditoria de fecha de registro
   */
//  @ApiModelProperty(value = "Auditoria de fecha de registro")
  Date busgrTregistrationDate;

  /**
   * <strong>busgr_tupdate_date timestamp without time zone</strong><br>
   * Auditoria de fecha de modificacion
   */
//  @ApiModelProperty(value = "Auditoria de fecha de modificacion")
  Date busgrTupdateDate;

  /**
   * <strong>busgr_buser_create bigint</strong><br>
   * Auditoria de usuario de creador
   */
//  @ApiModelProperty(value = "Auditoria de usuario de creador")
  Long busgrBuserCreate;

  /**
   * <strong>busgr_buser_modify bigint</strong><br>
   * Auditoria de usuario modificacion
   */
//  @ApiModelProperty(value = "Auditoria de usuario modificacion")
  Long busgrBuserModify;


  /**
   * <strong>busgr_bident bigint NOT NULL</strong><br>
   * Id de la tabla
   */
  public void setBusgrBident(Long busgrBident) {
    this.busgrBident = busgrBident;
  }

  /**
   * <strong>busgr_bident bigint NOT NULL</strong><br>
   * Id de la tabla
   */
  public Long getBusgrBident() {
    return busgrBident;
  }

  /**
   * <strong>busgr_vname character varying</strong><br>
   * nombre del grupo comercial
   */
  public void setBusgrVname(String busgrVname) {
    this.busgrVname = busgrVname;
  }

  /**
   * <strong>busgr_vname character varying</strong><br>
   * nombre del grupo comercial
   */
  public String getBusgrVname() {
    return busgrVname;
  }

  /**
   * <strong>busgr_vdescription character varying</strong><br>
   * Descripcion del grupo comercial
   */
  public void setBusgrVdescription(String busgrVdescription) {
    this.busgrVdescription = busgrVdescription;
  }

  /**
   * <strong>busgr_vdescription character varying</strong><br>
   * Descripcion del grupo comercial
   */
  public String getBusgrVdescription() {
    return busgrVdescription;
  }

  /**
   * <strong>busgr_bstate character</strong><br>
   * Estado del grupo comercial
   */
  public void setBusgrBstate(String busgrBstate) {
    this.busgrBstate = busgrBstate;
  }

  /**
   * <strong>busgr_bstate character</strong><br>
   * Estado del grupo comercial
   */
  public String getBusgrBstate() {
    return busgrBstate;
  }

  /**
   * <strong>busgr_tregistration_date timestamp without time zone</strong><br>
   * Auditoria de fecha de registro
   */
  public void setBusgrTregistrationDate(Date busgrTregistrationDate) {
    this.busgrTregistrationDate = busgrTregistrationDate;
  }

  /**
   * <strong>busgr_tregistration_date timestamp without time zone</strong><br>
   * Auditoria de fecha de registro
   */
  public Date getBusgrTregistrationDate() {
    return busgrTregistrationDate;
  }

  /**
   * <strong>busgr_tupdate_date timestamp without time zone</strong><br>
   * Auditoria de fecha de modificacion
   */
  public void setBusgrTupdateDate(Date busgrTupdateDate) {
    this.busgrTupdateDate = busgrTupdateDate;
  }

  /**
   * <strong>busgr_tupdate_date timestamp without time zone</strong><br>
   * Auditoria de fecha de modificacion
   */
  public Date getBusgrTupdateDate() {
    return busgrTupdateDate;
  }

  /**
   * <strong>busgr_buser_create bigint</strong><br>
   * Auditoria de usuario de creador
   */
  public void setBusgrBuserCreate(Long busgrBuserCreate) {
    this.busgrBuserCreate = busgrBuserCreate;
  }

  /**
   * <strong>busgr_buser_create bigint</strong><br>
   * Auditoria de usuario de creador
   */
  public Long getBusgrBuserCreate() {
    return busgrBuserCreate;
  }

  /**
   * <strong>busgr_buser_modify bigint</strong><br>
   * Auditoria de usuario modificacion
   */
  public void setBusgrBuserModify(Long busgrBuserModify) {
    this.busgrBuserModify = busgrBuserModify;
  }

  /**
   * <strong>busgr_buser_modify bigint</strong><br>
   * Auditoria de usuario modificacion
   */
  public Long getBusgrBuserModify() {
    return busgrBuserModify;
  }

  @Override
  public String toString() {
    return reflectionToString(this, SHORT_PREFIX_STYLE);
  }
}