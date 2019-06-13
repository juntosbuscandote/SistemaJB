package pe.am.spring.entity;

import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;
import java.util.Date;

public class TPerson {
	
	
	  /**
	   * <strong>pers_bident bigint NOT NULL</strong>
	   *  codigo autogenerado de persona
	   */
//	  @NotNull(groups = { OperacionPut.class })
//	  @Null(groups = { OperacionPost.class })
//	  @Min(1)
	  Long persBident;

	  /**
	   * <strong>lega_bident bigint</strong>
	   * codigo foraneo de persona juridica
	   */
//	  @Min(1)
	  Long legaBident;

	  /**
	   * <strong>natu_bident bigint</strong>
	   * codigo foraneo de persona natural
//	   */
//	  @Min(1)
	  Long natuBident;

	  /**
	   * <strong>pers_vtradename character varying</strong>
	   * nombre comercial de persona
	   */
//	  @Size(max = 100)
	  String persVtradename;

	  /**
	   * <strong>pers_vdoctype character varying</strong>
	   * tipo de documento de persona
	   */
//	  @Size(max = 30)
	  String persVdoctype;

	  /**
	   * <strong>pers_vnumdoc character varying</strong>
	   * numero de documento de persona
	   */
//	  @Size(max = 30)
	  String persVnumdoc;

	  /**
	   * <strong>pers_cperstype character varying</strong>
	   * tipo de persona 
	   */
//	  @Size(max = 1)
	  String persCperstype;

	  /**
	   * <strong>pers_vubigeo character varying</strong>
	   * ubigeo de persona departamento,provincia y distrito
	   */
//	  @Size(max = 100)
	  String persVubigeo;

	  /**
	   * <strong>pers_bcodcountry bigint</strong>
	   * codigo de pais de persona
	   */
	  Long persBcodcountry;

	  /**
	   * <strong>pers_tregistration_date timestamp with time zone</strong>
	   * fecha de registro de la tabla persona
	   */
	  Date persTregistrationDate;

	  /**
	   * <strong>pers_tdate_update timestamp with time zone</strong>
	   * fecha de actualizacion de la tabla persona
	   */
	  Date persTdateUpdate;

	  /**
	   * <strong>pers_buser_modify bigint</strong>
	   * usuario que modifica la tabla de persona
	   */
	  Long persBuserModify;
	  String persVdomiciled;

	  public String getPersVdomiciled() {
		return persVdomiciled;
	}

	public void setPersVdomiciled(String persVdomiciled) {
		this.persVdomiciled = persVdomiciled;
	}

	/**
	   * <strong>pers_bident bigint NOT NULL</strong>
	   * codigo autogenerado de persona
	   */
	  public void setPersBident(Long persBident) {
	    this.persBident = persBident;
	  }

	  /**
	   * <strong>pers_bident bigint NOT NULL</strong>
	   * codigo autogenerado de persona
	   */
	  public Long getPersBident() {
	    return persBident;
	  }

	  /**
	   * <strong>lega_bident bigint</strong>
	   * codigo foraneo de persona juridica
	   */
	  public void setLegaBident(Long legaBident) {
	    this.legaBident = legaBident;
	  }

	  /**
	   * <strong>lega_bident bigint</strong>
	   * codigo foraneo de persona juridica
	   */
	  public Long getLegaBident() {
	    return legaBident;
	  }

	  /**
	   * <strong>natu_bident bigint</strong>
	   * codigo foraneo de persona natural
	   */
	  public void setNatuBident(Long natuBident) {
	    this.natuBident = natuBident;
	  }

	  /**
	   * <strong>natu_bident bigint</strong>
	   * codigo foraneo de persona natural
	   */
	  public Long getNatuBident() {
	    return natuBident;
	  }

	  /**
	   * <strong>pers_vtradename character varying</strong>
	   * nombre comercial de persona
	   */
	  public void setPersVtradename(String persVtradename) {
	    this.persVtradename = persVtradename;
	  }

	  /**
	   * <strong>pers_vtradename character varying</strong>
	   * nombre comercial de persona
	   */
	  public String getPersVtradename() {
	    return persVtradename;
	  }

	  /**
	   * <strong>pers_vdoctype character varying</strong>
	   * tipo de documento de persona
	   */
	  public void setPersVdoctype(String persVdoctype) {
	    this.persVdoctype = persVdoctype;
	  }

	  /**
	   * <strong>pers_vdoctype character varying</strong>
	   * tipo de documento de persona
	   */
	  public String getPersVdoctype() {
	    return persVdoctype;
	  }

	  /**
	   * <strong>pers_vnumdoc character varying</strong>
	   * numero de documento de persona
	   */
	  public void setPersVnumdoc(String persVnumdoc) {
	    this.persVnumdoc = persVnumdoc;
	  }

	  /**
	   * <strong>pers_vnumdoc character varying</strong>
	   * numero de documento de persona
	   */
	  public String getPersVnumdoc() {
	    return persVnumdoc;
	  }

	  /**
	   * <strong>pers_cperstype character varying</strong>
	   * tipo de persona
	   */
	  public void setPersCperstype(String persCperstype) {
	    this.persCperstype = persCperstype;
	  }

	  /**
	   * <strong>pers_cperstype character varying</strong>
	   * tipo de persona
	   */
	  public String getPersCperstype() {
	    return persCperstype;
	  }

	  /**
	   * <strong>pers_vubigeo character varying</strong>
	   * ubigeo de persona departamento,provincia y distrito
	   */
	  public void setPersVubigeo(String persVubigeo) {
	    this.persVubigeo = persVubigeo;
	  }

	  /**
	   * <strong>pers_vubigeo character varying</strong>
	   * ubigeo de persona departamento,provincia y distrito
	   */
	  public String getPersVubigeo() {
	    return persVubigeo;
	  }

	  /**
	   * <strong>pers_bcodcountry bigint</strong>
	   * codigo de pais de persona
	   */
	  public void setPersBcodcountry(Long persBcodcountry) {
	    this.persBcodcountry = persBcodcountry;
	  }

	  /**
	   * <strong>pers_bcodcountry bigint</strong>
	   * codigo de pais de persona
	   */
	  public Long getPersBcodcountry() {
	    return persBcodcountry;
	  }

	  /**
	   * <strong>pers_tregistration_date timestamp with time zone</strong>
	   * fecha de registro de la tabla persona
	   */
	  public void setPersTregistrationDate(Date persTregistrationDate) {
	    this.persTregistrationDate = persTregistrationDate;
	  }

	  /**
	   * <strong>pers_tregistration_date timestamp with time zone</strong>
	   * fecha de registro de la tabla persona
	   */
	  public Date getPersTregistrationDate() {
	    return persTregistrationDate;
	  }

	  /**
	   * <strong>pers_tdate_update timestamp with time zone</strong>
	   * fecha de actualizacion de la tabla persona
	   */
	  public void setPersTdateUpdate(Date persTdateUpdate) {
	    this.persTdateUpdate = persTdateUpdate;
	  }

	  /**
	   * <strong>pers_tdate_update timestamp with time zone</strong>
	   * fecha de actualizacion de la tabla persona
	   */
	  public Date getPersTdateUpdate() {
	    return persTdateUpdate;
	  }

	  /**
	   * <strong>pers_buser_modify bigint</strong>
	   * usuario que modifica la tabla de persona
	   */
	  public void setPersBuserModify(Long persBuserModify) {
	    this.persBuserModify = persBuserModify;
	  }

	  /**
	   * <strong>pers_buser_modify bigint</strong>
	   * usuario que modifica la tabla de persona
	   */
	  public Long getPersBuserModify() {
	    return persBuserModify;
	  }

	  @Override
	public String toString() {
		return "TPerson [persBident=" + persBident + ", legaBident=" + legaBident + ", natuBident=" + natuBident
				+ ", persVtradename=" + persVtradename + ", persVdoctype=" + persVdoctype + ", persVnumdoc="
				+ persVnumdoc + ", persCperstype=" + persCperstype + ", persVubigeo=" + persVubigeo
				+ ", persBcodcountry=" + persBcodcountry + ", persTregistrationDate=" + persTregistrationDate
				+ ", persTdateUpdate=" + persTdateUpdate + ", persBuserModify=" + persBuserModify + "]";
	}

}
