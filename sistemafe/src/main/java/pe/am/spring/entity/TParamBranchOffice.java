package pe.am.spring.entity;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.*;
import static org.apache.commons.lang3.builder.ToStringBuilder.*;
import static org.apache.commons.lang3.builder.ToStringStyle.*;


import com.fasterxml.jackson.annotation.*;



@JsonInclude(NON_NULL)
public class TParamBranchOffice {


  /**
   * <strong>paof_bident bigint NOT NULL</strong><br>
   * Codigo autogenerado de la tabla parametros de empresa
   */
  Long paofBident;

  /**
   * <strong>paof_vdescription character varying</strong><br>
   * Descripcion del parametro de la empresa
   */
  String paofVdescription;

  /**
   * <strong>paof_bkey character varying</strong><br>
   * Key del parametro de la empresa
   */
  String paofBkey1;
  
  String paofBkey2;
  
  String paofBvalue;

  /**
   * <strong>paof_bstate boolean</strong><br>
   * Estado del parametro
   */
  Boolean paofBstate;

  /**
   * <strong>busi_bident bigint</strong><br>
   * Llave de la empresa
   */
  Long offiBident;


  /**
   * <strong>paof_bident bigint NOT NULL</strong><br>
   * Codigo autogenerado de la tabla parametros de empresa
   */
  public void setPaofBident(Long paofBident) {
    this.paofBident = paofBident;
  }

  /**
   * <strong>paof_bident bigint NOT NULL</strong><br>
   * Codigo autogenerado de la tabla parametros de empresa
   */
  public Long getPaofBident() {
    return paofBident;
  }

  /**
   * <strong>paof_vdescription character varying</strong><br>
   * Descripcion del parametro de la empresa
   */
  public void setPaofVdescription(String paofVdescription) {
    this.paofVdescription = paofVdescription;
  }

  /**
   * <strong>paof_vdescription character varying</strong><br>
   * Descripcion del parametro de la empresa
   */
  public String getPaofVdescription() {
    return paofVdescription;
  }

  /**
   * <strong>paof_bkey character varying</strong><br>
   * Key del parametro de la empresa
   */
  public void setPaofBkey1(String paofBkey1) {
    this.paofBkey1 = paofBkey1;
  }

  /**
   * <strong>paof_bkey character varying</strong><br>
   * Key del parametro de la empresa
   */
  public String getPaofBkey1() {
    return paofBkey1;
  }
  
  /**
   * <strong>paof_bkey character varying</strong><br>
   * Key del parametro de la empresa
   */
  public void setPaofBkey2(String paofBkey2) {
    this.paofBkey2 = paofBkey2;
  }

  /**
   * <strong>paof_bkey character varying</strong><br>
   * Key del parametro de la empresa
   */
  public String getPaofBkey2() {
    return paofBkey2;
  }

  /**
   * <strong>paof_bstate boolean</strong><br>
   * Estado del parametro
   */
  public void setPaofBstate(Boolean paofBstate) {
    this.paofBstate = paofBstate;
  }

  /**
   * <strong>paof_bstate boolean</strong><br>
   * Estado del parametro
   */
  public Boolean getPaofBstate() {
    return paofBstate;
  }

  /**
   * <strong>busi_bident bigint</strong><br>
   * Llave de la empresa
   */
  public void setOffiBident(Long offiBident) {
    this.offiBident = offiBident;
  }

  /**
   * <strong>busi_bident bigint</strong><br>
   * Llave de la empresa
   */
  public Long getOffiBident() {
    return offiBident;
  }

  
  
  public String getPaofBvalue() {
	return paofBvalue;
}

public void setPaofBvalue(String paofBvalue) {
	this.paofBvalue = paofBvalue;
}

@Override
  public String toString() {
    return reflectionToString(this, SHORT_PREFIX_STYLE);
  }
}