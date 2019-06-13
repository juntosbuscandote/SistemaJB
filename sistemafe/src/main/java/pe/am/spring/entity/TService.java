package pe.am.spring.entity;

import java.util.Date;

public class TService {


	  /**
	   * <strong>serv_bident bigint NOT NULL</strong><br>
	   * Clave primaria de servicio
	   */
//	  @NotNull(groups = { OperacionPut.class })
//	  @Null(groups = { OperacionPost.class })
//	  @Min(1)
//	  @ApiModelProperty(value = "Clave primaria de servicio")
	  Long servBident;

	  /**
	   * <strong>busi_bident bigint</strong>
	   */
//	  @Min(1)
	  Long busiBident;

	  /**
	   * <strong>serv_vmain_name character varying</strong><br>
	   * Nombre principal de servicio
	   */
//	  @Size(max = 100)
//	  @ApiModelProperty(value = "Nombre principal de servicio")
	  String servVmainName;
	  
	  /**
	   * <strong>serv_vmain_name character varying</strong><br>
	   * Nombre principal de servicio (codigo)
	   */
//	  @Size(max = 100)
//	  @ApiModelProperty(value = "Nombre principal de servicio (codigo)")
	  String servVmainNameCod;

	  /**
	   * <strong>serv_vsecond_name character varying</strong><br>
	   * Nombre secundario de servicio
	   */
//	  @Size(max = 100)
//	  @ApiModelProperty(value = "Nombre secundario de servicio")
	  String servVsecondName;

	  /**
	   * <strong>serv_vshortname character varying</strong><br>
	   * Nombre corto de servicio
	   */
//	  @Size(max = 10)
//	  @ApiModelProperty(value = "Nombre corto de servicio")
	  String servVshortname;

	  /**
	   * <strong>serv_vdescription character varying</strong><br>
	   * Descripcion de servicio
	   */
//	  @Size(max = 200)
//	  @ApiModelProperty(value = "Descripcion de servicio")
	  String servVdescription;
	  
	  /**
	   * <strong>serv_create_user bigint</strong><br>
	   * Usuario que crea el servicio
	   */
//	  @Min(1)
	  Long servCreateUser;


	  /**
	   * <strong>serv_tregistration_date timestamp without time zone</strong><br>
	   * Fecha de registro de servicio
	   */
//	  @ApiModelProperty(value = "Fecha de registro de servicio")
	  Date servTregistrationDate;

	  /**
	   * <strong>serv_tdate_update timestamp without time zone</strong><br>
	   * Fecha de actualizacion de servicio
	   */
//	  @ApiModelProperty(value = "Fecha de actualizacion de servicio")
	  Date servTdateUpdate;

	  /**
	   * <strong>serv_bstate string</strong>
	   */
//	  @Size(max = 1)
//	  @ApiModelProperty(value = "Estado")
	  String servBstate;

	  /**
	   * <strong>serv_buser_modify bigint</strong><br>
	   * Usuario que modifica precios
	   */
//	  @ApiModelProperty(value = "Usuario que modifica precios")
	  Long servBuserModify;
	  
	  String servVclassSunat;
	  
	  public String getServVclassSunat() {
		return servVclassSunat;
	  }

	  public void setServVclassSunat(String servVclassSunat) {
		this.servVclassSunat = servVclassSunat;
	  }

	/**
	   * <strong>serv_bident bigint NOT NULL</strong><br>
	   * Clave primaria de servicio
	   */
	  public void setServBident(Long servBident) {
	    this.servBident = servBident;
	  }

	  /**
	   * <strong>serv_bident bigint NOT NULL</strong><br>
	   * Clave primaria de servicio
	   */
	  public Long getServBident() {
	    return servBident;
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
	   * <strong>serv_vmain_name character varying</strong><br>
	   * Nombre principal de servicio
	   */
	  public void setServVmainName(String servVmainName) {
	    this.servVmainName = servVmainName;
	  }

	  /**
	   * <strong>serv_vmain_name character varying</strong><br>
	   * Nombre principal de servicio
	   */
	  public String getServVmainName() {
	    return servVmainName;
	  }
	  
	  /**
	   * <strong>serv_vmain_name character varying</strong><br>
	   * Nombre principal de servicio (codigo)
	   */
	  public String getServVmainNameCod() {
		return servVmainNameCod;
	  }

	  /**
	   * <strong>serv_vmain_name character varying</strong><br>
	   * Nombre principal de servicio (codigo)
	   */
	  public void setServVmainNameCod(String servVmainNameCod) {
		this.servVmainNameCod = servVmainNameCod;
	  }

	  /**
	   * <strong>serv_vsecond_name character varying</strong><br>
	   * Nombre secundario de servicio
	   */
	  public void setServVsecondName(String servVsecondName) {
	    this.servVsecondName = servVsecondName;
	  }

	  /**
	   * <strong>serv_vsecond_name character varying</strong><br>
	   * Nombre secundario de servicio
	   */
	  public String getServVsecondName() {
	    return servVsecondName;
	  }

	  /**
	   * <strong>serv_vshortname character varying</strong><br>
	   * Nombre corto de servicio
	   */
	  public void setServVshortname(String servVshortname) {
	    this.servVshortname = servVshortname;
	  }

	  /**
	   * <strong>serv_vshortname character varying</strong><br>
	   * Nombre corto de servicio
	   */
	  public String getServVshortname() {
	    return servVshortname;
	  }

	  /**
	   * <strong>serv_vdescription character varying</strong><br>
	   * Descripcion de servicio
	   */
	  public void setServVdescription(String servVdescription) {
	    this.servVdescription = servVdescription;
	  }

	  /**
	   * <strong>serv_vdescription character varying</strong><br>
	   * Descripcion de servicio
	   */
	  public String getServVdescription() {
	    return servVdescription;
	  }

	  /**
	   * <strong>serv_create_user character varying</strong><br>
	   * Usuario que crea el servicio
	   */
	  public void setServCreateUser(Long servCreateUser) {
	    this.servCreateUser = servCreateUser;
	  }

	  /**
	   * <strong>serv_create_user character varying</strong><br>
	   * Usuario que crea el servicio
	   */
	  public Long getServCreateUser() {
	    return servCreateUser;
	  }

	  /**
	   * <strong>serv_tregistration_date timestamp without time zone</strong><br>
	   * Fecha de registro de servicio
	   */
	  public void setServTregistrationDate(Date servTregistrationDate) {
	    this.servTregistrationDate = servTregistrationDate;
	  }

	  /**
	   * <strong>serv_tregistration_date timestamp without time zone</strong><br>
	   * Fecha de registro de servicio
	   */
	  public Date getServTregistrationDate() {
	    return servTregistrationDate;
	  }

	  /**
	   * <strong>serv_tdate_update timestamp without time zone</strong><br>
	   * Fecha de actualizacion de servicio
	   */
	  public void setServTdateUpdate(Date servTdateUpdate) {
	    this.servTdateUpdate = servTdateUpdate;
	  }

	  /**
	   * <strong>serv_tdate_update timestamp without time zone</strong><br>
	   * Fecha de actualizacion de servicio
	   */
	  public Date getServTdateUpdate() {
	    return servTdateUpdate;
	  }

	  /**
	   * <strong>serv_bstate boolean</strong>
	   */
	  public void setServBstate(String servBstate) {
	    this.servBstate = servBstate;
	  }

	  /**
	   * <strong>serv_bstate boolean</strong>
	   */
	  public String getServBstate() {
	    return servBstate;
	  }

	  /**
	   * <strong>serv_buser_modify bigint</strong><br>
	   * Usuario que modifica precios
	   */
	  public void setServBuserModify(Long servBuserModify) {
	    this.servBuserModify = servBuserModify;
	  }

	  /**
	   * <strong>serv_buser_modify bigint</strong><br>
	   * Usuario que modifica precios
	   */
	  public Long getServBuserModify() {
	    return servBuserModify;
	  }

	@Override
	public String toString() {
		return "TService [servBident=" + servBident + ", busiBident=" + busiBident + ", servVmainName=" + servVmainName
				+ ", servVsecondName=" + servVsecondName + ", servVshortname=" + servVshortname + ", servVdescription="
				+ servVdescription + ", servCreateUser=" + servCreateUser + ", servTregistrationDate="
				+ servTregistrationDate + ", servTdateUpdate=" + servTdateUpdate + ", servBstate=" + servBstate
				+ ", servBuserModify=" + servBuserModify + "]";
	}
	  
}