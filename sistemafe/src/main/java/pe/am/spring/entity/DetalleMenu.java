package pe.am.spring.entity;

import java.util.List;

public class DetalleMenu {

	private String idMenu;
	private String etiqueta;
	private String descripcion;
	private String icono;
	private String nroDetMenu;
	private String nroDetPadreMenu;
	private String estadoMenu;
	private String urlMenu;
	private String idModulo;

	private List<DetalleMenu> detalleMenu;

	public String getIdMenu() {
		return idMenu;
	}

	public void setIdMenu(String idMenu) {
		this.idMenu = idMenu;
	}

	public String getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
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

	public String getNroDetMenu() {
		return nroDetMenu;
	}

	public void setNroDetMenu(String nroDetMenu) {
		this.nroDetMenu = nroDetMenu;
	}

	public String getNroDetPadreMenu() {
		return nroDetPadreMenu;
	}

	public void setNroDetPadreMenu(String nroDetPadreMenu) {
		this.nroDetPadreMenu = nroDetPadreMenu;
	}

	public String getEstadoMenu() {
		return estadoMenu;
	}

	public void setEstadoMenu(String estadoMenu) {
		this.estadoMenu = estadoMenu;
	}

	public String getIdModulo() {
		return idModulo;
	}

	public void setIdModulo(String idModulo) {
		this.idModulo = idModulo;
	}

	public List<DetalleMenu> getDetalleMenu() {
		return detalleMenu;
	}

	public void setDetalleMenu(List<DetalleMenu> detalleMenu) {
		this.detalleMenu = detalleMenu;
	}

	public String getUrlMenu() {
		return urlMenu;
	}

	public void setUrlMenu(String urlMenu) {
		this.urlMenu = urlMenu;
	}

}
