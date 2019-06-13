package pe.am.spring.entity;

import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;


public class TClient {


	  /**
	   * <strong>clie_bcod bigint NOT NULL</strong><br>
	   * Código autogenerado del cliente
	   */
//	  @NotNull(groups = { OperacionPut.class })
//	  @Null(groups = { OperacionPost.class })
//	  @Min(1)
//	  @ApiModelProperty(value = "Código autogenerado del cliente")
	  Long clieBcod;

	  /**
	   * <strong>prof_bcod bigint</strong><br>
	   * Fk Código foraneo autogenerado de perfil
	   */
//	  @Min(1)
//	  @ApiModelProperty(value = "Fk Código foraneo autogenerado de perfil")
	  Long profBcod;

	  /**
	   * <strong>busi_bcod bigint</strong><br>
	   * Fk Código foraneo autogenerado de empresa
	   */
//	  @Min(1)
//	  @ApiModelProperty(value = "Fk Código foraneo autogenerado de empresa")
	  Long busiBcod;

	  /**
	   * <strong>clie_vpass character varying NOT NULL</strong><br>
	   * Contraseña de acceso al cliente
	   */
//	  @NotNull(groups = { OperacionPost.class, OperacionPut.class })
//	  @Size(max = 30)
//	  @ApiModelProperty(value = "Contraseña de acceso al cliente")
	  String clieVpass;

	  /**
	   * <strong>clie_vuser character varying NOT NULL</strong><br>
	   * Usuario de acceso al cliente
	   */
//	  @NotNull(groups = { OperacionPost.class, OperacionPut.class })
//	  @Size(max = 30)
//	  @ApiModelProperty(value = "Usuario de acceso al cliente")
	  String clieVuser;

	  /**
	   * <strong>clie_vdoctype character varying</strong><br>
	   * Tipo de documento del cliente
	   */
//	  @Size(max = 30)
//	  @ApiModelProperty(value = "Tipo de documento del cliente")
	  String clieVdoctype;

	  /**
	   * <strong>clie_inumdoc character varying NOT NULL</strong><br>
	   * Número de documento del cliente
	   */
//	  @NotNull(groups = { OperacionPost.class, OperacionPut.class })
//	  @Size(max = 30)
//	  @ApiModelProperty(value = "Número de documento del cliente")
	  String clieInumdoc;

	  /**
	   * <strong>clie_vusersol character varying NOT NULL</strong><br>
	   * Usuario Sol
	   */
//	  @NotNull(groups = { OperacionPost.class, OperacionPut.class })
//	  @Size(max = 30)
//	  @ApiModelProperty(value = "Usuario Sol")
	  String clieVusersol;

	  /**
	   * <strong>clie_vkeysol character varying NOT NULL</strong><br>
	   * Clave Sol
	   */
//	  @NotNull(groups = { OperacionPost.class, OperacionPut.class })
//	  @Size(max = 12)
//	  @ApiModelProperty(value = "Clave Sol")
	  String clieVkeysol;

	  /**
	   * <strong>clie_vemail character varying</strong><br>
	   * Correo de cliente final
	   */
//	  @Size(max = 100)
//	  @ApiModelProperty(value = "Correo de cliente final")
	  String clieVemail;


	  /**
	   * <strong>clie_bcod bigint NOT NULL</strong><br>
	   * Código autogenerado del cliente
	   */
	  public void setClieBcod(Long clieBcod) {
	    this.clieBcod = clieBcod;
	  }

	  /**
	   * <strong>clie_bcod bigint NOT NULL</strong><br>
	   * Código autogenerado del cliente
	   */
	  public Long getClieBcod() {
	    return clieBcod;
	  }

	  /**
	   * <strong>prof_bcod bigint</strong><br>
	   * Fk Código foraneo autogenerado de perfil
	   */
	  public void setProfBcod(Long profBcod) {
	    this.profBcod = profBcod;
	  }

	  /**
	   * <strong>prof_bcod bigint</strong><br>
	   * Fk Código foraneo autogenerado de perfil
	   */
	  public Long getProfBcod() {
	    return profBcod;
	  }

	  /**
	   * <strong>busi_bcod bigint</strong><br>
	   * Fk Código foraneo autogenerado de empresa
	   */
	  public void setBusiBcod(Long busiBcod) {
	    this.busiBcod = busiBcod;
	  }

	  /**
	   * <strong>busi_bcod bigint</strong><br>
	   * Fk Código foraneo autogenerado de empresa
	   */
	  public Long getBusiBcod() {
	    return busiBcod;
	  }

	  /**
	   * <strong>clie_vpass character varying NOT NULL</strong><br>
	   * Contraseña de acceso al cliente
	   */
	  public void setClieVpass(String clieVpass) {
	    this.clieVpass = clieVpass;
	  }

	  /**
	   * <strong>clie_vpass character varying NOT NULL</strong><br>
	   * Contraseña de acceso al cliente
	   */
	  public String getClieVpass() {
	    return clieVpass;
	  }

	  /**
	   * <strong>clie_vuser character varying NOT NULL</strong><br>
	   * Usuario de acceso al cliente
	   */
	  public void setClieVuser(String clieVuser) {
	    this.clieVuser = clieVuser;
	  }

	  /**
	   * <strong>clie_vuser character varying NOT NULL</strong><br>
	   * Usuario de acceso al cliente
	   */
	  public String getClieVuser() {
	    return clieVuser;
	  }

	  /**
	   * <strong>clie_vdoctype character varying</strong><br>
	   * Tipo de documento del cliente
	   */
	  public void setClieVdoctype(String clieVdoctype) {
	    this.clieVdoctype = clieVdoctype;
	  }

	  /**
	   * <strong>clie_vdoctype character varying</strong><br>
	   * Tipo de documento del cliente
	   */
	  public String getClieVdoctype() {
	    return clieVdoctype;
	  }

	  /**
	   * <strong>clie_inumdoc character varying NOT NULL</strong><br>
	   * Número de documento del cliente
	   */
	  public void setClieInumdoc(String clieInumdoc) {
	    this.clieInumdoc = clieInumdoc;
	  }

	  /**
	   * <strong>clie_inumdoc character varying NOT NULL</strong><br>
	   * Número de documento del cliente
	   */
	  public String getClieInumdoc() {
	    return clieInumdoc;
	  }

	  /**
	   * <strong>clie_vusersol character varying NOT NULL</strong><br>
	   * Usuario Sol
	   */
	  public void setClieVusersol(String clieVusersol) {
	    this.clieVusersol = clieVusersol;
	  }

	  /**
	   * <strong>clie_vusersol character varying NOT NULL</strong><br>
	   * Usuario Sol
	   */
	  public String getClieVusersol() {
	    return clieVusersol;
	  }

	  /**
	   * <strong>clie_vkeysol character varying NOT NULL</strong><br>
	   * Clave Sol
	   */
	  public void setClieVkeysol(String clieVkeysol) {
	    this.clieVkeysol = clieVkeysol;
	  }

	  /**
	   * <strong>clie_vkeysol character varying NOT NULL</strong><br>
	   * Clave Sol
	   */
	  public String getClieVkeysol() {
	    return clieVkeysol;
	  }

	  /**
	   * <strong>clie_vemail character varying</strong><br>
	   * Correo de cliente final
	   */
	  public void setClieVemail(String clieVemail) {
	    this.clieVemail = clieVemail;
	  }

	  /**
	   * <strong>clie_vemail character varying</strong><br>
	   * Correo de cliente final
	   */
	  public String getClieVemail() {
	    return clieVemail;
	  }

	  
	  
	  @Override
	  public String toString() {
	    return  "TClient [clieBcod=" + clieBcod + ", profBcod=" + profBcod + ", busiBcod=" + busiBcod
				+ ", clieVpass=" + clieVpass + ", clieVuser=" + clieVuser + ", clieVdoctype="
				+ clieVdoctype + ", clieInumdoc" + clieInumdoc + ", clieVusersol=" + clieVusersol + ", clieVkeysol="
				+ clieVkeysol + ", clieVemail=" + clieVemail + "]";
	  }  

}
