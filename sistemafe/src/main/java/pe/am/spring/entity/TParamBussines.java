package pe.am.spring.entity;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.*;
import static org.apache.commons.lang3.builder.ToStringBuilder.*;
import static org.apache.commons.lang3.builder.ToStringStyle.*;


import com.fasterxml.jackson.annotation.*;



@JsonInclude(NON_NULL)
public class TParamBussines {


  /**
   * <strong>pabu_bident bigint NOT NULL</strong><br>
   * Codigo autogenerado de la tabla parametros de empresa
   */
  Long pabuBident;

  /**
   * <strong>pabu_vdescription character varying</strong><br>
   * Descripcion del parametro de la empresa
   */
  String pabuVdescription;

  /**
   * <strong>pabu_bkey character varying</strong><br>
   * Key del parametro de la empresa
   */
  String pabuBkey;
  
  String pabuBvalue;

  /**
   * <strong>pabu_bstate boolean</strong><br>
   * Estado del parametro
   */
  Boolean pabuBstate;

  /**
   * <strong>busi_bident bigint</strong><br>
   * Llave de la empresa
   */
  Long busiBident;


  /**
   * <strong>pabu_bident bigint NOT NULL</strong><br>
   * Codigo autogenerado de la tabla parametros de empresa
   */
  public void setPabuBident(Long pabuBident) {
    this.pabuBident = pabuBident;
  }

  /**
   * <strong>pabu_bident bigint NOT NULL</strong><br>
   * Codigo autogenerado de la tabla parametros de empresa
   */
  public Long getPabuBident() {
    return pabuBident;
  }

  /**
   * <strong>pabu_vdescription character varying</strong><br>
   * Descripcion del parametro de la empresa
   */
  public void setPabuVdescription(String pabuVdescription) {
    this.pabuVdescription = pabuVdescription;
  }

  /**
   * <strong>pabu_vdescription character varying</strong><br>
   * Descripcion del parametro de la empresa
   */
  public String getPabuVdescription() {
    return pabuVdescription;
  }

  /**
   * <strong>pabu_bkey character varying</strong><br>
   * Key del parametro de la empresa
   */
  public void setPabuBkey(String pabuBkey) {
    this.pabuBkey = pabuBkey;
  }

  /**
   * <strong>pabu_bkey character varying</strong><br>
   * Key del parametro de la empresa
   */
  public String getPabuBkey() {
    return pabuBkey;
  }

  /**
   * <strong>pabu_bstate boolean</strong><br>
   * Estado del parametro
   */
  public void setPabuBstate(Boolean pabuBstate) {
    this.pabuBstate = pabuBstate;
  }

  /**
   * <strong>pabu_bstate boolean</strong><br>
   * Estado del parametro
   */
  public Boolean getPabuBstate() {
    return pabuBstate;
  }

  /**
   * <strong>busi_bident bigint</strong><br>
   * Llave de la empresa
   */
  public void setBusiBident(Long busiBident) {
    this.busiBident = busiBident;
  }

  /**
   * <strong>busi_bident bigint</strong><br>
   * Llave de la empresa
   */
  public Long getBusiBident() {
    return busiBident;
  }

  
  
  public String getPabuBvalue() {
	return pabuBvalue;
}

public void setPabuBvalue(String pabuBvalue) {
	this.pabuBvalue = pabuBvalue;
}

@Override
  public String toString() {
    return reflectionToString(this, SHORT_PREFIX_STYLE);
  }
}