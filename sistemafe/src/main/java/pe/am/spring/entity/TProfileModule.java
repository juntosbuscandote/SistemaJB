package pe.am.spring.entity;

import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

import java.util.Date;


/**
 * <strong>t_profile_module</strong><br>
 * Tabla de Perfiles de la Web ContaNet
 */
public class TProfileModule {


  /**
   * <strong>profmod_bident bigint NOT NULL</strong><br>
   * Id de la tabla
   */
  Long profmodBident;

  /**
   * <strong>prof_bident bigint NOT NULL</strong><br>
   * Id de la tabla de perfiles
   */
  Long profBident;

  /**
   * <strong>moddet_bident bigint NOT NULL</strong><br>
   * Id de la tabla de detalle del modulo
   */
  Long moddetBident;

  /**
   * <strong>profmod_tregistration_date timestamp without time zone</strong><br>
   * Auditoria de fecha de registro
   */
  Date profmodTregistrationDate;

  /**
   * <strong>profmod_tupdate_date timestamp without time zone</strong><br>
   * Auditoria de fecha de modificacion
   */
  Date profmodTupdateDate;

  /**
   * <strong>profmod_buser_create bigint</strong><br>
   * Auditoria de usuario creador
   */
  Long profmodBuserCreate;

  /**
   * <strong>profmod_buser_modify bigint</strong><br>
   * Auditoria de usuario creador
   */
  Long profmodBuserModify;

  /**
   * <strong>profmod_bstate character</strong><br>
   * Estado del modulo
   */
  String profmodBstate;


  /**
   * <strong>profmod_bident bigint NOT NULL</strong><br>
   * Id de la tabla
   */
  public void setProfmodBident(Long profmodBident) {
    this.profmodBident = profmodBident;
  }

  /**
   * <strong>profmod_bident bigint NOT NULL</strong><br>
   * Id de la tabla
   */
  public Long getProfmodBident() {
    return profmodBident;
  }

  /**
   * <strong>prof_bident bigint NOT NULL</strong><br>
   * Id de la tabla de perfiles
   */
  public void setProfBident(Long profBident) {
    this.profBident = profBident;
  }

  /**
   * <strong>prof_bident bigint NOT NULL</strong><br>
   * Id de la tabla de perfiles
   */
  public Long getProfBident() {
    return profBident;
  }

  /**
   * <strong>moddet_bident bigint NOT NULL</strong><br>
   * Id de la tabla de detalle del modulo
   */
  public void setModdetBident(Long moddetBident) {
    this.moddetBident = moddetBident;
  }

  /**
   * <strong>moddet_bident bigint NOT NULL</strong><br>
   * Id de la tabla de detalle del modulo
   */
  public Long getModdetBident() {
    return moddetBident;
  }

  /**
   * <strong>profmod_tregistration_date timestamp without time zone</strong><br>
   * Auditoria de fecha de registro
   */
  public void setProfmodTregistrationDate(Date profmodTregistrationDate) {
    this.profmodTregistrationDate = profmodTregistrationDate;
  }

  /**
   * <strong>profmod_tregistration_date timestamp without time zone</strong><br>
   * Auditoria de fecha de registro
   */
  public Date getProfmodTregistrationDate() {
    return profmodTregistrationDate;
  }

  /**
   * <strong>profmod_tupdate_date timestamp without time zone</strong><br>
   * Auditoria de fecha de modificacion
   */
  public void setProfmodTupdateDate(Date profmodTupdateDate) {
    this.profmodTupdateDate = profmodTupdateDate;
  }

  /**
   * <strong>profmod_tupdate_date timestamp without time zone</strong><br>
   * Auditoria de fecha de modificacion
   */
  public Date getProfmodTupdateDate() {
    return profmodTupdateDate;
  }

  /**
   * <strong>profmod_buser_create bigint</strong><br>
   * Auditoria de usuario creador
   */
  public void setProfmodBuserCreate(Long profmodBuserCreate) {
    this.profmodBuserCreate = profmodBuserCreate;
  }

  /**
   * <strong>profmod_buser_create bigint</strong><br>
   * Auditoria de usuario creador
   */
  public Long getProfmodBuserCreate() {
    return profmodBuserCreate;
  }

  /**
   * <strong>profmod_buser_modify bigint</strong><br>
   * Auditoria de usuario creador
   */
  public void setProfmodBuserModify(Long profmodBuserModify) {
    this.profmodBuserModify = profmodBuserModify;
  }

  /**
   * <strong>profmod_buser_modify bigint</strong><br>
   * Auditoria de usuario creador
   */
  public Long getProfmodBuserModify() {
    return profmodBuserModify;
  }

  /**
   * <strong>profmod_bstate character</strong><br>
   * Estado del modulo
   */
  public void setProfmodBstate(String profmodBstate) {
    this.profmodBstate = profmodBstate;
  }

  /**
   * <strong>profmod_bstate character</strong><br>
   * Estado del modulo
   */
  public String getProfmodBstate() {
    return profmodBstate;
  }

  @Override
  public String toString() {
    return reflectionToString(this, SHORT_PREFIX_STYLE);
  }
}