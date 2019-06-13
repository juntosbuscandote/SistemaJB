package pe.am.spring.entity;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

import java.util.Date;


import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * <strong>t_module</strong><br>
 * Tabla de los modulos de la Web ContaNet
 */
@JsonInclude(NON_NULL)
public class TModule {


  /**
   * <strong>modu_bident bigint NOT NULL</strong><br>
   * Id de la tabla
   */
  Long moduBident;

  /**
   * <strong>modu_vlabel character varying</strong><br>
   * Texto que ira en el menu  web
   */
  String moduVlabel;

  /**
   * <strong>modu_description character varying</strong><br>
   * Descripcion del modulo
   */
  String moduDescription;

  /**
   * <strong>modu_vicon character varying</strong><br>
   * Icono que ira junto al texto en el menu de la web
   */
  String moduVicon;

  /**
   * <strong>modu_tregistration_date timestamp without time zone</strong><br>
   * Auditoria de fecha de registro
   */
  Date moduTregistrationDate;

  /**
   * <strong>modu_tupdate_date timestamp without time zone</strong><br>
   * Auditoria de fecha de modificacion
   */
  Date moduTupdateDate;

  /**
   * <strong>modu_buser_create bigint</strong><br>
   * Auditoria de fecha de modificacion
   */
  Long moduBuserCreate;

  /**
   * <strong>modu_buser_modify bigint</strong><br>
   * Auditoria de usuario creador
   */
  Long moduBuserModify;

  /**
   * <strong>modu_bstate character</strong><br>
   * Estado del modulo
   */
  String moduBstate;


  /**
   * <strong>modu_bident bigint NOT NULL</strong><br>
   * Id de la tabla
   */
  public void setModuBident(Long moduBident) {
    this.moduBident = moduBident;
  }

  /**
   * <strong>modu_bident bigint NOT NULL</strong><br>
   * Id de la tabla
   */
  public Long getModuBident() {
    return moduBident;
  }

  /**
   * <strong>modu_vlabel character varying</strong><br>
   * Texto que ira en el menu  web
   */
  public void setModuVlabel(String moduVlabel) {
    this.moduVlabel = moduVlabel;
  }

  /**
   * <strong>modu_vlabel character varying</strong><br>
   * Texto que ira en el menu  web
   */
  public String getModuVlabel() {
    return moduVlabel;
  }

  /**
   * <strong>modu_description character varying</strong><br>
   * Descripcion del modulo
   */
  public void setModuDescription(String moduDescription) {
    this.moduDescription = moduDescription;
  }

  /**
   * <strong>modu_description character varying</strong><br>
   * Descripcion del modulo
   */
  public String getModuDescription() {
    return moduDescription;
  }

  /**
   * <strong>modu_vicon character varying</strong><br>
   * Icono que ira junto al texto en el menu de la web
   */
  public void setModuVicon(String moduVicon) {
    this.moduVicon = moduVicon;
  }

  /**
   * <strong>modu_vicon character varying</strong><br>
   * Icono que ira junto al texto en el menu de la web
   */
  public String getModuVicon() {
    return moduVicon;
  }

  /**
   * <strong>modu_tregistration_date timestamp without time zone</strong><br>
   * Auditoria de fecha de registro
   */
  public void setModuTregistrationDate(Date moduTregistrationDate) {
    this.moduTregistrationDate = moduTregistrationDate;
  }

  /**
   * <strong>modu_tregistration_date timestamp without time zone</strong><br>
   * Auditoria de fecha de registro
   */
  public Date getModuTregistrationDate() {
    return moduTregistrationDate;
  }

  /**
   * <strong>modu_tupdate_date timestamp without time zone</strong><br>
   * Auditoria de fecha de modificacion
   */
  public void setModuTupdateDate(Date moduTupdateDate) {
    this.moduTupdateDate = moduTupdateDate;
  }

  /**
   * <strong>modu_tupdate_date timestamp without time zone</strong><br>
   * Auditoria de fecha de modificacion
   */
  public Date getModuTupdateDate() {
    return moduTupdateDate;
  }

  /**
   * <strong>modu_buser_create bigint</strong><br>
   * Auditoria de fecha de modificacion
   */
  public void setModuBuserCreate(Long moduBuserCreate) {
    this.moduBuserCreate = moduBuserCreate;
  }

  /**
   * <strong>modu_buser_create bigint</strong><br>
   * Auditoria de fecha de modificacion
   */
  public Long getModuBuserCreate() {
    return moduBuserCreate;
  }

  /**
   * <strong>modu_buser_modify bigint</strong><br>
   * Auditoria de usuario creador
   */
  public void setModuBuserModify(Long moduBuserModify) {
    this.moduBuserModify = moduBuserModify;
  }

  /**
   * <strong>modu_buser_modify bigint</strong><br>
   * Auditoria de usuario creador
   */
  public Long getModuBuserModify() {
    return moduBuserModify;
  }

  /**
   * <strong>modu_bstate character</strong><br>
   * Estado del modulo
   */
  public void setModuBstate(String moduBstate) {
    this.moduBstate = moduBstate;
  }

  /**
   * <strong>modu_bstate character</strong><br>
   * Estado del modulo
   */
  public String getModuBstate() {
    return moduBstate;
  }

  @Override
  public String toString() {
    return reflectionToString(this, SHORT_PREFIX_STYLE);
  }
}