package pe.am.spring.entity;

public class TClientPost extends TClient {
	  /**
	   * <strong>clie_bcod bigint NOT NULL</strong><br>
	   * Código autogenerado del cliente
	   */
//	  @ApiModelProperty(hidden = true)
//	  @Override
	  public Long getClieBcod() {
	    return super.getClieBcod();
	  }


	  /**
	   * <strong>clie_vpass character varying NOT NULL</strong><br>
	   * Contraseña de acceso al cliente
	   */
//	  @ApiModelProperty(value = "Contraseña de acceso al cliente", required = true)
//	  @Override
	  public String getClieVpass() {
	    return super.getClieVpass();
	  }


	  /**
	   * <strong>clie_vuser character varying NOT NULL</strong><br>
	   * Usuario de acceso al cliente
	   */
//	  @ApiModelProperty(value = "Usuario de acceso al cliente", required = true)
//	  @Override
	  public String getClieVuser() {
	    return super.getClieVuser();
	  }




	  /**
	   * <strong>clie_inumdoc character varying NOT NULL</strong><br>
	   * Número de documento del cliente
	   */
//	  @ApiModelProperty(value = "Número de documento del cliente", required = true)
//	  @Override
	  public String getClieInumdoc() {
	    return super.getClieInumdoc();
	  }


	  /**
	   * <strong>clie_vusersol character varying NOT NULL</strong><br>
	   * Usuario Sol
	   */
//	  @ApiModelProperty(value = "Usuario Sol", required = true)
//	  @Override
	  public String getClieVusersol() {
	    return super.getClieVusersol();
	  }


	  /**
	   * <strong>clie_vkeysol character varying NOT NULL</strong><br>
	   * Clave Sol
	   */
//	  @ApiModelProperty(value = "Clave Sol", required = true)
//	  @Override
	  public String getClieVkeysol() {
	    return super.getClieVkeysol();
	  }

}
