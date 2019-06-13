package pe.am.spring.entity;


import java.math.*;
import java.util.*;





/**
 * <strong>t_catalogue_det</strong><br>
 * Tabla 23 detalle de catalogo
 */
//@JsonInclude(NON_NULL)
public class TCountry {


  /**
   * <strong>coun_bident bigint NOT NULL</strong><br>
   * Codigo de pais de catalogo
   */
 
//  @Size(max = 6)
//  @ApiModelProperty(value = "Nombre de Pais")
  String counBident;

  /**
   * <strong>coun_Vname character</strong><br>
   * Nombre de pais de las tablas
   */
//  @Size(max = 50)
//  @ApiModelProperty(value = "Nombre de Pais")
  String counVname;



  /**
   * <strong>coun_bstate boolean</strong><br>
   * Estado de Pais
   */
//  @ApiModelProperty(value = "Estado de Pais")
  Boolean counBstate;




public String getCounBident() {
	return counBident;
}

public void setCounBident(String counBident) {
	this.counBident = counBident;
}

public String getCounVname() {
	return counVname;
}

public void setCounVname(String counVname) {
	this.counVname = counVname;
}


public Boolean getCounBstate() {
	return counBstate;
}

public void setCounBstate(Boolean counBstate) {
	this.counBstate = counBstate;
}

//@Override
//public String toString() {
//  return  "TCountry [clieBcod=" + clieBcod + ", profBcod=" + profBcod + ", busiBcod=" + busiBcod
//			+ ", clieVpass=" + clieVpass + ", clieVuser=" + clieVuser + ", clieVdoctype="
//			+ clieVdoctype + ", clieInumdoc" + clieInumdoc + ", clieVusersol=" + clieVusersol + ", clieVkeysol="
//			+ clieVkeysol + ", clieVemail=" + clieVemail + "]";
//}  
}