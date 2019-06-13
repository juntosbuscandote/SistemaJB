 package pe.am.spring.entity;

import java.util.Date;





public class TBusiness {

	  /**
	   * <strong>busi_bcod bigint NOT NULL</strong><br>
	   * Codigo de empresa autogenerado
	   */
//	  @NotNull(groups = { OperacionPut.class })
//	  @Null(groups = { OperacionPost.class })
//	  @Min(1)
//	  @ApiModelProperty(value = "Codigo de empresa autogenerado")
	  Long busiBcod;

	  /**
	   * <strong>busi_vruc character varying NOT NULL</strong><br>
	   * Codigo de RUC de la empresa unico
	   */
//	  @NotNull(groups = { OperacionPost.class, OperacionPut.class })
//	  @Size(max = 11)
//	  @ApiModelProperty(value = "Codigo de RUC de la empresa unico")
	  String busiVruc;

	  /**
	   * <strong>busi_vbusiname character varying</strong><br>
	   * Razon social de la empresa
	   */
//	  @Size(max = 50)
//	  @ApiModelProperty(value = "Razon social de la empresa")
	  String busiVbusiname;
  
	  /**
	   * <strong>busi_tstartdate timestamp without time zone</strong><br>
	   * Fecha de inicio de la empresa
	   */
//	  @ApiModelProperty(value = "Fecha de inicio de la empresa")
	  Date busiTstartdate;

	  /**
	   * <strong>busi_vubigeo character varying</strong><br>
	   * Codigo de RUC de la empresa unico
	   */
//	  @Size(max = 6)
//	  @ApiModelProperty(value = "Codigo de RUC de la empresa unico")
	  String busiVubigeo;

	  /**
	   * <strong>busi_vaddress character varying</strong><br>
	   * Ubigeo de la empresa
	   */
//	  @Size(max = 100)
//	  @ApiModelProperty(value = "Ubigeo de la empresa")
	  String busiVaddress;

	  /**
	   * <strong>busi_vphone character varying</strong><br>
	   * Numero de telefono de la empresa
	   */
//	  @Size(max = 15)
//	  @ApiModelProperty(value = "Numero de telefono de la empresa")
	  String busiVphone;

	  /**
	   * <strong>busi_vlogo character varying</strong><br>
	   * Logo de representacion de la empresa
	   */
//	  @Size(max = 100)
//	  @ApiModelProperty(value = "Logo de representacion de la empresa")
	  String busiVlogo;

	  /**
	   * <strong>busi_vemail character varying</strong><br>
	   * Correo de la empresa
	   */
//	  @Size(max = 100)
//	  @APIMODELPRoperty(value = "Correo de la empresa")
	  String busiVemail;

	  /**
	   * <strong>busi_vconfigemail character varying</strong><br>
	   * Configuracion de correos
	   */
//	  @Size(max = 100)
//	  @ApiModelProperty(value = "Configuracion de correos")
	  String busiVconfigemail;

	  /**
	   * <strong>busi_vlegalrep character varying</strong><br>
	   * Representante legal de la empresa
	   */
//	  @Size(max = 45)
//	  @ApiModelProperty(value = "Representante legal de la empresa")
	  String busiVlegalrep;

	  /**
	   * <strong>busi_vcodcountry character varying</strong><br>
	   * Codigo de pais
	   */
//	  @Size(max = 4)
//	  @ApiModelProperty(value = "Codigo de pais")
	  String busiVcodcountry;

	  /**
	   * <strong>busi_vcodconfig character varying</strong><br>
	   * Codigo de configuracion
	   */
//	  @Size(max = 10)
//	  @ApiModelProperty(value = "Codigo de configuracion")
	  String busiVcodconfig;

	  /**
	   * <strong>busi_vcodsendsunat character varying</strong><br>
	   * Codigo de envio sunat
	   */
//	  @Size(max = 4)
//	  @ApiModelProperty(value = "Codigo de envio sunat")
	  String busiVcodsendsunat;

	  /**
	   * <strong>busi_vnamenatp character varying</strong><br>
	   * Nombre de persona natural
//	   */
//	  @Size(max = 50)
//	  @ApiModelProperty(value = "Nombre de persona natural")
	  String busiVnamenatp;

	  /**
	   * <strong>cert_bcod bigint</strong><br>
	   * Codigo foraneo de certificado
	   */
//	  @Min(1)
//	  @ApiModelProperty(value = "Codigo foraneo de certificado")
	  Long certBcod;

	  String busiState;

	  /**
	   * <strong>busi_bcod bigint NOT NULL</strong><br>
	   * Codigo de empresa autogenerado
	   */
	  public void setBusiBcod(Long busiBcod) {
	    this.busiBcod = busiBcod;
	  }

	  /**
	   * <strong>busi_bcod bigint NOT NULL</strong><br>
	   * Codigo de empresa autogenerado
	   */
	  public Long getBusiBcod() {
	    return busiBcod;
	  }

	  /**
	   * <strong>busi_vruc character varying NOT NULL</strong><br>
	   * Codigo de RUC de la empresa unico
	   */
	  public void setBusiVruc(String busiVruc) {
	    this.busiVruc = busiVruc;
	  }

	  /**
	   * <strong>busi_vruc character varying NOT NULL</strong><br>
	   * Codigo de RUC de la empresa unico
	   */
	  public String getBusiVruc() {
	    return busiVruc;
	  }

	  /**
	   * <strong>busi_vbusiname character varying</strong><br>
	   * Razon social de la empresa
	   */
	  public void setBusiVbusiname(String busiVbusiname) {
	    this.busiVbusiname = busiVbusiname;
	  }

	  /**
	   * <strong>busi_vbusiname character varying</strong><br>
	   * Razon social de la empresa
	   */
	  public String getBusiVbusiname() {
	    return busiVbusiname;
	  }

	  /**
	   * <strong>busi_tstartdate timestamp without time zone</strong><br>
	   * Fecha de inicio de la empresa
	   */
	  public void setBusiTstartdate(Date busiTstartdate) {
	    this.busiTstartdate = busiTstartdate;
	  }

	  /**
	   * <strong>busi_tstartdate timestamp without time zone</strong><br>
	   * Fecha de inicio de la empresa
	   */
	  public Date getBusiTstartdate() {
	    return busiTstartdate;
	  }

	  /**
	   * <strong>busi_vubigeo character varying</strong><br>
	   * Codigo de RUC de la empresa unico
	   */
	  public void setBusiVubigeo(String busiVubigeo) {
	    this.busiVubigeo = busiVubigeo;
	  }

	  /**
	   * <strong>busi_vubigeo character varying</strong><br>
	   * Codigo de RUC de la empresa unico
	   */
	  public String getBusiVubigeo() {
	    return busiVubigeo;
	  }

	  /**
	   * <strong>busi_vaddress character varying</strong><br>
	   * Ubigeo de la empresa
	   */
	  public void setBusiVaddress(String busiVaddress) {
	    this.busiVaddress = busiVaddress;
	  }

	  /**
	   * <strong>busi_vaddress character varying</strong><br>
	   * Ubigeo de la empresa
	   */
	  public String getBusiVaddress() {
	    return busiVaddress;
	  }

	  /**
	   * <strong>busi_vphone character varying</strong><br>
	   * Numero de telefono de la empresa
	   */
	  public void setBusiVphone(String busiVphone) {
	    this.busiVphone = busiVphone;
	  }

	  /**
	   * <strong>busi_vphone character varying</strong><br>
	   * Numero de telefono de la empresa
	   */
	  public String getBusiVphone() {
	    return busiVphone;
	  }

	  /**
	   * <strong>busi_vlogo character varying</strong><br>
	   * Logo de representacion de la empresa
	   */
	  public void setBusiVlogo(String busiVlogo) {
	    this.busiVlogo = busiVlogo;
	  }

	  /**
	   * <strong>busi_vlogo character varying</strong><br>
	   * Logo de representacion de la empresa
	   */
	  public String getBusiVlogo() {
	    return busiVlogo;
	  }

	  /**
	   * <strong>busi_vemail character varying</strong><br>
	   * Correo de la empresa
	   */
	  public void setBusiVemail(String busiVemail) {
	    this.busiVemail = busiVemail;
	  }

	  /**
	   * <strong>busi_vemail character varying</strong><br>
	   * Correo de la empresa
	   */
	  public String getBusiVemail() {
	    return busiVemail;
	  }

	  /**
	   * <strong>busi_vconfigemail character varying</strong><br>
	   * Configuracion de correos
	   */
	  public void setBusiVconfigemail(String busiVconfigemail) {
	    this.busiVconfigemail = busiVconfigemail;
	  }

	  /**
	   * <strong>busi_vconfigemail character varying</strong><br>
	   * Configuracion de correos
	   */
	  public String getBusiVconfigemail() {
	    return busiVconfigemail;
	  }

	  /**
	   * <strong>busi_vlegalrep character varying</strong><br>
	   * Representante legal de la empresa
	   */
	  public void setBusiVlegalrep(String busiVlegalrep) {
	    this.busiVlegalrep = busiVlegalrep;
	  }

	  /**
	   * <strong>busi_vlegalrep character varying</strong><br>
	   * Representante legal de la empresa
	   */
	  public String getBusiVlegalrep() {
	    return busiVlegalrep;
	  }

	  /**
	   * <strong>busi_vcodcountry character varying</strong><br>
	   * Codigo de pais
	   */
	  public void setBusiVcodcountry(String busiVcodcountry) {
	    this.busiVcodcountry = busiVcodcountry;
	  }

	  /**
	   * <strong>busi_vcodcountry character varying</strong><br>
	   * Codigo de pais
	   */
	  public String getBusiVcodcountry() {
	    return busiVcodcountry;
	  }

	  /**
	   * <strong>busi_vcodconfig character varying</strong><br>
	   * Codigo de configuracion
	   */
	  public void setBusiVcodconfig(String busiVcodconfig) {
	    this.busiVcodconfig = busiVcodconfig;
	  }

	  /**
	   * <strong>busi_vcodconfig character varying</strong><br>
	   * Codigo de configuracion
	   */
	  public String getBusiVcodconfig() {
	    return busiVcodconfig;
	  }

	  /**
	   * <strong>busi_vcodsendsunat character varying</strong><br>
	   * Codigo de envio sunat
	   */
	  public void setBusiVcodsendsunat(String busiVcodsendsunat) {
	    this.busiVcodsendsunat = busiVcodsendsunat;
	  }

	  /**
	   * <strong>busi_vcodsendsunat character varying</strong><br>
	   * Codigo de envio sunat
	   */
	  public String getBusiVcodsendsunat() {
	    return busiVcodsendsunat;
	  }

	  /**
	   * <strong>busi_vnamenatp character varying</strong><br>
	   * Nombre de persona natural
	   */
	  public void setBusiVnamenatp(String busiVnamenatp) {
	    this.busiVnamenatp = busiVnamenatp;
	  }

	  /**
	   * <strong>busi_vnamenatp character varying</strong><br>
	   * Nombre de persona natural
	   */
	  public String getBusiVnamenatp() {
	    return busiVnamenatp;
	  }

	  /**
	   * <strong>cert_bcod bigint</strong><br>
	   * Codigo foraneo de certificado
	   */
	  public void setCertBcod(Long certBcod) {
	    this.certBcod = certBcod;
	  }

	  /**
	   * <strong>cert_bcod bigint</strong><br>
	   * Codigo foraneo de certificado
	   */
	  public Long getCertBcod() {
	    return certBcod;
	  }

	public String getBusiState() {
		return busiState;
	}

	public void setBusiState(String busiState) {
		this.busiState = busiState;
	}

	@Override
	public String toString() {
		return "TBusiness [busiBcod=" + busiBcod + ", busiVruc=" + busiVruc + ", busiVbusiname=" + busiVbusiname
				+ ", busiTstartdate=" + busiTstartdate + ", busiVubigeo=" + busiVubigeo + ", busiVaddress="
				+ busiVaddress + ", busiVphone=" + busiVphone + ", busiVlogo=" + busiVlogo + ", busiVemail="
				+ busiVemail + ", busiVconfigemail=" + busiVconfigemail + ", busiVlegalrep=" + busiVlegalrep
				+ ", busiVcodcountry=" + busiVcodcountry + ", busiVcodconfig=" + busiVcodconfig + ", busiVcodsendsunat="
				+ busiVcodsendsunat + ", busiVnamenatp=" + busiVnamenatp + ", certBcod=" + certBcod + ", busiState="
				+ busiState + "]";
	}
	 
	
	
}
