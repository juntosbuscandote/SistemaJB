package pe.am.spring.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <strong>t_branch_office</strong><br>
 * Tabla sucursal
 */
public class TBranchOfficePost extends TBranchOffice {
	/**
	 * <strong>repo_bident bigint NOT NULL</strong><br>
	 * Codigo identificador de almacen
	 */
	// @NotNull(groups = { OperacionPut.class })
	// @Null(groups = { OperacionPost.class })
	// @Min(1)
	// @ApiModelProperty(value = "Codigo identificador de almacen")
	Long repoBident;

	/**
	 * <strong>offi_bident bigint</strong><br>
	 * Codigo identificador de sucursal
	 */
	// @Min(1)
	// @ApiModelProperty(value = "Codigo identificador de sucursal")

	/**
	 * <strong>repo_vcode character varying</strong><br>
	 * Codigo de almacen
	 */
	// @Size(max = 5)
	// @ApiModelProperty(value = "Codigo de almacen")
	String repoVcode;

	/**
	 * <strong>repo_vname character varying</strong><br>
	 * Nombre de almacen
	 */
	// @Size(max = 100)
	// @ApiModelProperty(value = "Nombre de almacen")
	String repoVname;

	/**
	 * <strong>repo_vshortname character varying</strong><br>
	 * Nombre corto de almacen
	 */
	// @Size(max = 50)
	// @ApiModelProperty(value = "Nombre corto de almacen")
	String repoVshortname;

	/**
	 * <strong>repo_vphone character varying</strong><br>
	 * Telefono de almacen
	 */
	// @Size(max = 50)
	// @ApiModelProperty(value = "Telefono de almacen")
	String repoVphone;

	/**
	 * <strong>repo_vmandated character varying</strong><br>
	 * Nombre completo del encargado del almacen
	 */
	// @Size(max = 250)
	// @ApiModelProperty(value = "Nombre completo del encargado del almacen")
	String repoVmandated;

	/**
	 * <strong>repo_stock numeric</strong>
	 */
	BigDecimal repoStock;

	/**
	 * <strong>repo_tregistration_date timestamp with time zone</strong><br>
	 * Fecha de registro
	 */
	// @ApiModelProperty(value = "Fecha de registro")
	Date repoTregistrationDate;

	/**
	 * <strong>repo_tdate_update timestamp with time zone</strong><br>
	 * Fecha de ultima actualización
	 */
	// @ApiModelProperty(value = "Fecha de ultima actualización")
	Date repoTdateUpdate;

	/**
	 * <strong>repo_buser_register character varying</strong><br>
	 * Usuario que registro el almacen
	 */
	// @Size(max = 45)
	// @ApiModelProperty(value = "Usuario que registro el almacen")
	String repoBuserRegister;

	/**
	 * <strong>repo_buser_modify character varying</strong><br>
	 * Ultimo usuario que modifico el almacen
	 */
	// @Size(max = 45)
	// @ApiModelProperty(value = "Ultimo usuario que modifico el almacen")
	String repoBuserModify;

	/**
	 * <strong>offi_bident bigint NOT NULL</strong><br>
	 * Clave primaria de sucursal
	 */
	// @ApiModelProperty(hidden = true)
	
	  String repoBstate;
	
	public String getRepoBstate() {
		return repoBstate;
	}

	public void setRepoBstate(String repoBstate) {
		this.repoBstate = repoBstate;
	}

	@Override
	public Long getOffiBident() {
		return super.getOffiBident();
	}

	public Long getRepoBident() {
		return repoBident;
	}

	public void setRepoBident(Long repoBident) {
		this.repoBident = repoBident;
	}

	public String getRepoVcode() {
		return repoVcode;
	}

	public void setRepoVcode(String repoVcode) {
		this.repoVcode = repoVcode;
	}

	public String getRepoVname() {
		return repoVname;
	}

	public void setRepoVname(String repoVname) {
		this.repoVname = repoVname;
	}

	public String getRepoVshortname() {
		return repoVshortname;
	}

	public void setRepoVshortname(String repoVshortname) {
		this.repoVshortname = repoVshortname;
	}

	public String getRepoVphone() {
		return repoVphone;
	}

	public void setRepoVphone(String repoVphone) {
		this.repoVphone = repoVphone;
	}

	public String getRepoVmandated() {
		return repoVmandated;
	}

	public void setRepoVmandated(String repoVmandated) {
		this.repoVmandated = repoVmandated;
	}

	public BigDecimal getRepoStock() {
		return repoStock;
	}

	public void setRepoStock(BigDecimal repoStock) {
		this.repoStock = repoStock;
	}

	public Date getRepoTregistrationDate() {
		return repoTregistrationDate;
	}

	public void setRepoTregistrationDate(Date repoTregistrationDate) {
		this.repoTregistrationDate = repoTregistrationDate;
	}

	public Date getRepoTdateUpdate() {
		return repoTdateUpdate;
	}

	public void setRepoTdateUpdate(Date repoTdateUpdate) {
		this.repoTdateUpdate = repoTdateUpdate;
	}

	public String getRepoBuserRegister() {
		return repoBuserRegister;
	}

	public void setRepoBuserRegister(String repoBuserRegister) {
		this.repoBuserRegister = repoBuserRegister;
	}

	public String getRepoBuserModify() {
		return repoBuserModify;
	}

	public void setRepoBuserModify(String repoBuserModify) {
		this.repoBuserModify = repoBuserModify;
	}


}