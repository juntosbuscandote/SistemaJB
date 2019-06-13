package pe.am.spring.entity;

public class CorreoPersona {

	private String correo;
	private String nombre;

	public CorreoPersona() {
		// TODO Auto-generated constructor stub
	}
	
	

	public CorreoPersona(String correo, String nombre) {
		super();
		this.correo = correo;
		this.nombre = nombre;
	}



	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
