package pe.am.spring.entity;


/**
 * <strong>t_branch_office</strong><br>
 * Tabla sucursal
 */
public class TBranchOfficePut extends TBranchOffice {

	/**
	 * <strong>offi_bident bigint NOT NULL</strong><br>
	 * Clave primaria de sucursal
	 */
//	@ApiModelProperty(value = "Clave primaria de sucursal", required = true)
	@Override
	public Long getOffiBident() {
		return super.getOffiBident();
	}

}