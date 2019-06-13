package pe.am.spring.entity;

import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;


/**
*
* @author ehr
*/

public class TBrand {
	


	  /**
	   * <strong>bran_bident bigint NOT NULL</strong>
	   */
//	  @NotNull(groups = { OperacionPut.class })
//	  @Null(groups = { OperacionPost.class })
//	  @Min(1)
	  Long branBident;

	  /**
	   * <strong>bran_vname character varying</strong><br>
	   * Nombre de la marca
	   */
//	  @Size(max = 50)
//	  @ApiModelProperty(value = "Nombre de la marca")
	  String branVname;

	  /**
	   * <strong>bran_vshortname character varying</strong><br>
	   * Nombre corto de marca
	   */
//	  @Size(max = 10)
//	  @ApiModelProperty(value = "Nombre corto de marca")
	  String branVshortname;

	  /**
	   * <strong>bran_vdescription character varying</strong>
	   */
//	  @Size(max = 200)
	  String branVdescription;

	  /**
	   * <strong>bran_bstate string</strong><br>
	   * Estado de marca de producto
	   */
//	  @ApiModelProperty(value = "Estado de marca de producto")
	  String branBstate;
	  
//	  @Min(1)
//	  @ApiModelProperty(value = "Clave foranea de tabla empresa")
	  Long busiBident;


	  public Long getBusiBident() {
		return busiBident;
	}

	public void setBusiBident(Long busiBident) {
		this.busiBident = busiBident;
	}

	/**
	   * <strong>bran_bident bigint NOT NULL</strong>
	   */
	  public void setBranBident(Long branBident) {
	    this.branBident = branBident;
	  }

	  /**
	   * <strong>bran_bident bigint NOT NULL</strong>
	   */
	  public Long getBranBident() {
	    return branBident;
	  }

	  /**
	   * <strong>bran_vname character varying</strong><br>
	   * Nombre de la marca
	   */
	  public void setBranVname(String branVname) {
	    this.branVname = branVname;
	  }

	  /**
	   * <strong>bran_vname character varying</strong><br>
	   * Nombre de la marca
	   */
	  public String getBranVname() {
	    return branVname;
	  }

	  /**
	   * <strong>bran_vshortname character varying</strong><br>
	   * Nombre corto de marca
	   */
	  public void setBranVshortname(String branVshortname) {
	    this.branVshortname = branVshortname;
	  }

	  /**
	   * <strong>bran_vshortname character varying</strong><br>
	   * Nombre corto de marca
	   */
	  public String getBranVshortname() {
	    return branVshortname;
	  }

	  /**
	   * <strong>bran_vdescription character varying</strong>
	   */
	  public void setBranVdescription(String branVdescription) {
	    this.branVdescription = branVdescription;
	  }

	  /**
	   * <strong>bran_vdescription character varying</strong>
	   */
	  public String getBranVdescription() {
	    return branVdescription;
	  }

	  /**
	   * <strong>bran_bstate boolean</strong><br>
	   * Estado de marca de producto
	   */
	  public void setBranBstate(String branBstate) {
	    this.branBstate = branBstate;
	  }

	  /**
	   * <strong>bran_bstate boolean</strong><br>
	   * Estado de marca de producto
	   */
	  public String getBranBstate() {
	    return branBstate;
	  }
	  	
	@Override
	public String toString() {
		return "TBrand [branBident=" + branBident + ", branVname=" + branVname + ", branVshortname=" + branVshortname
				+ ", branVdescription=" + branVdescription + ", branBstate=" + branBstate + "]";
	}


}
