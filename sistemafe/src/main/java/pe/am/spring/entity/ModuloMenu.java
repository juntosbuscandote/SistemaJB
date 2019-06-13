package pe.am.spring.entity;

import java.util.List;

public class ModuloMenu {

	private String id;
	private String label;
	private String descripcion;
	private String icono;
	private String estado;

	private List<DetalleMenu> cabMenu;


	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getIcono() {
		return icono;
	}

	public void setIcono(String icono) {
		this.icono = icono;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<DetalleMenu> getCabMenu() {
		return cabMenu;
	}

	public void setCabMenu(List<DetalleMenu> cabMenu) {
		this.cabMenu = cabMenu;
	}

}
