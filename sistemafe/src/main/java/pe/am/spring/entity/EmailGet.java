package pe.am.spring.entity;

public class EmailGet extends Email {

	private String codResultado;
	private String mensajeResultado;

	public EmailGet() {
		// TODO Auto-generated constructor stub
	}

	public String getCodResultado() {
		return codResultado;
	}

	public void setCodResultado(String codResultado) {
		this.codResultado = codResultado;
	}

	public String getMensajeResultado() {
		return mensajeResultado;
	}

	public void setMensajeResultado(String mensajeResultado) {
		this.mensajeResultado = mensajeResultado;
	}

}
