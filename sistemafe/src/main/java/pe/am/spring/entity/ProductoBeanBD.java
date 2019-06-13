package pe.am.spring.entity;

import java.util.List;
import java.io.Serializable;

public class ProductoBeanBD implements Serializable {

	List<AlmacenBeanBD> almacen;
	private String codigoprod;
	private String nombrePrincipal;
	private String nombreSecundario;
	private String nombreCorto;
	private String descripcion;
	private String fechaCaducidad;
	private String tipoExistencia;
	private String codComercial;
	private String codBarras;
	private String user;
	private String claseSunat;
	
	
	public ProductoBeanBD() {
		super();
	}

	public List<AlmacenBeanBD> getAlmacen() {
		return almacen;
	}

	public void setAlmacen(List<AlmacenBeanBD> almacen) {
		this.almacen = almacen;
	}

	public String getCodigoprod() {
		return codigoprod;
	}

	public void setCodigoprod(String codigoprod) {
		this.codigoprod = codigoprod;
	}

	public String getNombrePrincipal() {
		return nombrePrincipal;
	}

	public void setNombrePrincipal(String nombrePrincipal) {
		this.nombrePrincipal = nombrePrincipal;
	}

	public String getNombreSecundario() {
		return nombreSecundario;
	}

	public void setNombreSecundario(String nombreSecundario) {
		this.nombreSecundario = nombreSecundario;
	}

	public String getNombreCorto() {
		return nombreCorto;
	}

	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(String fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	public String getTipoExistencia() {
		return tipoExistencia;
	}

	public void setTipoExistencia(String tipoExistencia) {
		this.tipoExistencia = tipoExistencia;
	}

	public String getCodComercial() {
		return codComercial;
	}

	public void setCodComercial(String codComercial) {
		this.codComercial = codComercial;
	}

	public String getCodBarras() {
		return codBarras;
	}

	public void setCodBarras(String codBarras) {
		this.codBarras = codBarras;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
	public String getClaseSunat() {
		return claseSunat;
	}

	public void setClaseSunat(String claseSunat) {
		this.claseSunat = claseSunat;
	}

}
