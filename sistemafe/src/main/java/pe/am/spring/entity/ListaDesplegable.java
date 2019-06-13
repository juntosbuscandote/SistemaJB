package pe.am.spring.entity;

public class ListaDesplegable {

	TCatalogueDet opcion;
	String opcAnio;
	Boolean estado;
	
	TBranchOffice opcSucursal;
	
	public ListaDesplegable() {
		super();
	}
	public TCatalogueDet getOpcion() {
		return opcion;
	}
	public void setOpcion(TCatalogueDet opcion) {
		this.opcion = opcion;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	public String getOpcAnio() {
		return opcAnio;
	}
	public void setOpcAnio(String opcAnio) {
		this.opcAnio = opcAnio;
	}
	public TBranchOffice getOpcSucursal() {
		return opcSucursal;
	}
	public void setOpcSucursal(TBranchOffice opcSucursal) {
		this.opcSucursal = opcSucursal;
	}
	
	
	
	
}
