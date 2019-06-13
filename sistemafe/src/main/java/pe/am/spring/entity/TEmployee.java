package pe.am.spring.entity;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.*;
import static org.apache.commons.lang3.builder.ToStringBuilder.*;
import static org.apache.commons.lang3.builder.ToStringStyle.*;

//@JsonInclude(NON_NULL)
public class TEmployee {

	/**
	 * <strong>empl_bident bigint NOT NULL</strong><br>
	 * Codigo autogenerado de empleado
	 */
	// @NotNull(groups = { OperacionPut.class })
	// @Null(groups = { OperacionPost.class })
	// @Min(1)
	// @ApiModelProperty(value = "Codigo autogenerado de empleado")
	Long emplBident;

	/**
	 * <strong>empl_vposition character varying</strong><br>
	 * Cargo del empleado
	 */
	// @Size(max = 50)
	// @ApiModelProperty(value = "Cargo del empleado")
	String emplVposition;

	/**
	 * <strong>empl_bstate boolean</strong><br>
	 * Estado de empleado activo_inactivo
	 */
	// @ApiModelProperty(value = "Estado de empleado activo_inactivo")
	Boolean emplBstate;

	/**
	 * <strong>pers_bident bigint</strong><br>
	 * Codigo foraneo de persona
	 */
	// @Min(1)
	// @ApiModelProperty(value = "Codigo foraneo de persona")
	Long persBident;

	/**
	 * <strong>busi_bident bigint</strong><br>
	 * Codigo foraneo de empresa
	 */
	// @Min(1)
	// @ApiModelProperty(value = "Codigo foraneo de empresa")
	Long busiBident;

	String userVuser;

	/**
	 * <strong>empl_bident bigint NOT NULL</strong><br>
	 * Codigo autogenerado de empleado
	 */
	public void setEmplBident(Long emplBident) {
		this.emplBident = emplBident;
	}

	/**
	 * <strong>empl_bident bigint NOT NULL</strong><br>
	 * Codigo autogenerado de empleado
	 */
	public Long getEmplBident() {
		return emplBident;
	}

	/**
	 * <strong>empl_vposition character varying</strong><br>
	 * Cargo del empleado
	 */
	public void setEmplVposition(String emplVposition) {
		this.emplVposition = emplVposition;
	}

	/**
	 * <strong>empl_vposition character varying</strong><br>
	 * Cargo del empleado
	 */
	public String getEmplVposition() {
		return emplVposition;
	}

	/**
	 * <strong>empl_bstate boolean</strong><br>
	 * Estado de empleado activo_inactivo
	 */
	public void setEmplBstate(Boolean emplBstate) {
		this.emplBstate = emplBstate;
	}

	/**
	 * <strong>empl_bstate boolean</strong><br>
	 * Estado de empleado activo_inactivo
	 */
	public Boolean getEmplBstate() {
		return emplBstate;
	}

	/**
	 * <strong>pers_bident bigint</strong><br>
	 * Codigo foraneo de persona
	 */
	public void setPersBident(Long persBident) {
		this.persBident = persBident;
	}

	/**
	 * <strong>pers_bident bigint</strong><br>
	 * Codigo foraneo de persona
	 */
	public Long getPersBident() {
		return persBident;
	}

	/**
	 * <strong>busi_bident bigint</strong><br>
	 * Codigo foraneo de empresa
	 */
	public void setBusiBident(Long busiBident) {
		this.busiBident = busiBident;
	}

	/**
	 * <strong>busi_bident bigint</strong><br>
	 * Codigo foraneo de empresa
	 */
	public Long getBusiBident() {
		return busiBident;
	}

	public String getUserVuser() {
		return userVuser;
	}

	public void setUserVuser(String userVuser) {
		this.userVuser = userVuser;
	}

	@Override
	public String toString() {
		return "TEmployee [emplBident=" + emplBident + ", emplVposition=" + emplVposition + ", emplBstate=" + emplBstate
				+ ", persBident=" + persBident + ", busiBident=" + busiBident + "]";
	}

}