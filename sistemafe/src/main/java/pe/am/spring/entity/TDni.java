package pe.am.spring.entity;

public class TDni {
	String dni;

	/**
	 * <strong>nombre character varying</strong>
	 */
	String tipoPersona;

	String nombre;

	/**
	 * <strong>estado character varying</strong>
	 */
	String estado;

	/**
	 * <strong>condicion_domicilio character varying</strong>
	 */
	String condicionDomicilio;

	/**
	 * <strong>ubigeo character varying</strong>
	 */
	String ubigeo;

	String direccion;

	
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getTipoPersona() {
		return tipoPersona;
	}

	public void setTipoPersona(String tipoPersona) {
		this.tipoPersona = tipoPersona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCondicionDomicilio() {
		return condicionDomicilio;
	}

	public void setCondicionDomicilio(String condicionDomicilio) {
		this.condicionDomicilio = condicionDomicilio;
	}

	public String getUbigeo() {
		return ubigeo;
	}

	public void setUbigeo(String ubigeo) {
		this.ubigeo = ubigeo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
}
