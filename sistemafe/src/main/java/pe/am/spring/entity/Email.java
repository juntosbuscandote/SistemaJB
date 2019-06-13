package pe.am.spring.entity;

import java.util.*;

public class Email {

	List<CorreoPersona> to;
	List<CorreoPersona> cc;
	List<CorreoPersona> bcc;
	List<Archivo> files;
	String tituloMensaje;
	String cuerpoMensaje;

	public Email() {
		// TODO Auto-generated constructor stub
	}

	public List<CorreoPersona> getTo() {
		return to;
	}

	public void setTo(List<CorreoPersona> to) {
		this.to = to;
	}

	public List<CorreoPersona> getCc() {
		return cc;
	}

	public void setCc(List<CorreoPersona> cc) {
		this.cc = cc;
	}

	public List<CorreoPersona> getBcc() {
		return bcc;
	}

	public void setBcc(List<CorreoPersona> bcc) {
		this.bcc = bcc;
	}

	public String getTituloMensaje() {
		return tituloMensaje;
	}

	public void setTituloMensaje(String tituloMensaje) {
		this.tituloMensaje = tituloMensaje;
	}

	public String getCuerpoMensaje() {
		return cuerpoMensaje;
	}

	public void setCuerpoMensaje(String cuerpoMensaje) {
		this.cuerpoMensaje = cuerpoMensaje;
	}

	public List<Archivo> getFiles() {
		return files;
	}

	public void setFiles(List<Archivo> files) {
		this.files = files;
	}

}
