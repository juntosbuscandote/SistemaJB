package pe.am.spring.entity;

import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

import java.util.Date;

/**
 * <strong>t_profile</strong><br>
 * Tabla de Perfiles de la Web ContaNet
 */
public class TProfile {


  /**
   * <strong>prof_bident bigint NOT NULL</strong><br>
   * Id de la tabla
   */
  Long profBident;

  /**
   * <strong>prof_vname character varying</strong><br>
   * nombre del perfil
   */
  String profVname;

  /**
   * <strong>prof_vdescription character varying</strong><br>
   * Descripcion del perfil
   */
  String profVdescription;

  /**
   * <strong>prof_bstate character</strong><br>
   * Estado del perfil
   */
  String profBstate;

  /**
   * <strong>prof_tregistration_date timestamp without time zone</strong><br>
   * Auditoria de fecha de registro
   */
  Date profTregistrationDate;

  /**
   * <strong>prof_tupdate_date timestamp without time zone</strong><br>
   * Auditoria de fecha de modificacion
   */
  Date profTupdateDate;

  /**
   * <strong>prof_buser_create bigint</strong><br>
   * Auditoria de usuario de creador
   */
  Long profBuserCreate;

  /**
   * <strong>prof_buser_modify bigint</strong><br>
   * Auditoria de usuario modificacion
   */
  Long profBuserModify;


  /**
   * <strong>prof_bident bigint NOT NULL</strong><br>
   * Id de la tabla
   */
  public void setProfBident(Long profBident) {
    this.profBident = profBident;
  }

  /**
   * <strong>prof_bident bigint NOT NULL</strong><br>
   * Id de la tabla
   */
  public Long getProfBident() {
    return profBident;
  }

  /**
   * <strong>prof_vname character varying</strong><br>
   * nombre del perfil
   */
  public void setProfVname(String profVname) {
    this.profVname = profVname;
  }

  /**
   * <strong>prof_vname character varying</strong><br>
   * nombre del perfil
   */
  public String getProfVname() {
    return profVname;
  }

  /**
   * <strong>prof_vdescription character varying</strong><br>
   * Descripcion del perfil
   */
  public void setProfVdescription(String profVdescription) {
    this.profVdescription = profVdescription;
  }

  /**
   * <strong>prof_vdescription character varying</strong><br>
   * Descripcion del perfil
   */
  public String getProfVdescription() {
    return profVdescription;
  }

  /**
   * <strong>prof_bstate character</strong><br>
   * Estado del perfil
   */
  public void setProfBstate(String profBstate) {
    this.profBstate = profBstate;
  }

  /**
   * <strong>prof_bstate character</strong><br>
   * Estado del perfil
   */
  public String getProfBstate() {
    return profBstate;
  }

  /**
   * <strong>prof_tregistration_date timestamp without time zone</strong><br>
   * Auditoria de fecha de registro
   */
  public void setProfTregistrationDate(Date profTregistrationDate) {
    this.profTregistrationDate = profTregistrationDate;
  }

  /**
   * <strong>prof_tregistration_date timestamp without time zone</strong><br>
   * Auditoria de fecha de registro
   */
  public Date getProfTregistrationDate() {
    return profTregistrationDate;
  }

  /**
   * <strong>prof_tupdate_date timestamp without time zone</strong><br>
   * Auditoria de fecha de modificacion
   */
  public void setProfTupdateDate(Date profTupdateDate) {
    this.profTupdateDate = profTupdateDate;
  }

  /**
   * <strong>prof_tupdate_date timestamp without time zone</strong><br>
   * Auditoria de fecha de modificacion
   */
  public Date getProfTupdateDate() {
    return profTupdateDate;
  }

  /**
   * <strong>prof_buser_create bigint</strong><br>
   * Auditoria de usuario de creador
   */
  public void setProfBuserCreate(Long profBuserCreate) {
    this.profBuserCreate = profBuserCreate;
  }

  /**
   * <strong>prof_buser_create bigint</strong><br>
   * Auditoria de usuario de creador
   */
  public Long getProfBuserCreate() {
    return profBuserCreate;
  }

  /**
   * <strong>prof_buser_modify bigint</strong><br>
   * Auditoria de usuario modificacion
   */
  public void setProfBuserModify(Long profBuserModify) {
    this.profBuserModify = profBuserModify;
  }

  /**
   * <strong>prof_buser_modify bigint</strong><br>
   * Auditoria de usuario modificacion
   */
  public Long getProfBuserModify() {
    return profBuserModify;
  }

  @Override
  public String toString() {
    return reflectionToString(this, SHORT_PREFIX_STYLE);
  }
}